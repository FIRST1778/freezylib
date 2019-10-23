

plugins {
    kotlin("jvm") version "1.3.50"

    idea
    maven
    `maven-publish`
    `java-library`

    id("org.jetbrains.dokka") version "0.10.0"
    id("com.diffplug.gradle.spotless") version "3.25.0"
    id("com.github.ben-manes.versions") version "0.27.0"

    id("io.gitlab.arturbosch.detekt") version "1.1.1"

    id("edu.wpi.first.GradleRIO") version "2020.1.1-beta-1"
}

group = "com.github.MTHSRoboticsClub"

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform(kotlin("bom")))
    implementation(kotlin("stdlib-jdk8"))

    implementation("com.google.guava:guava:28.1-jre")
    implementation("com.google.code.gson:gson:2.8.6")
    wpi.deps.wpilib().forEach { compile(it) }

    testImplementation("io.kotlintest:kotlintest-runner-junit5:3.4.2")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
        dependsOn("spotlessApply")
    }

    test {
        useJUnitPlatform {}
    }
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
