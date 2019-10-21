plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.41"

    idea
    maven
    `maven-publish`
    `java-library`

    id("org.jetbrains.dokka") version "0.10.0"
    id("com.diffplug.gradle.spotless") version "3.24.0"
    id("com.github.ben-manes.versions") version "0.21.0"

    id("io.gitlab.arturbosch.detekt") version "1.1.1"

    id("edu.wpi.first.GradleRIO") version "2019.4.1"
}

group = "com.github.MTHSRoboticsClub"

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("com.google.guava:guava:28.0-jre")
    implementation("com.google.code.gson:gson:2.8.5")
    wpi.deps.wpilib().forEach { compile(it) }

    testImplementation("org.junit.jupiter:junit-jupiter:5.5.1")
    testImplementation("org.assertj:assertj-core:3.13.1")
}

tasks.test {
    useJUnitPlatform()
    testLogging.showStandardStreams = true
}

spotless {
    kotlin { ktlint() }
    java { googleJavaFormat("1.7") }
    kotlinGradle { ktlint() }
}

detekt {
    config = files("$rootDir/detekt-config.yml")
}

publishing {
    publications {
        create<MavenPublication>("freezylib") {
            from(components["java"])
        }
    }
}
