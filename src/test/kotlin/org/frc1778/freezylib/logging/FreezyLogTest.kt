package org.frc1778.freezylib.logging

import edu.wpi.first.wpilibj.DriverStation.MatchType
import io.kotlintest.shouldBe
import io.kotlintest.shouldNotThrowAny
import io.kotlintest.shouldThrow
import io.kotlintest.specs.StringSpec
import java.io.IOException
import org.frc1778.freezylib.util.Measurement

/**
 * Tests the FreezyLog class and main methods.
 *
 * @author FRC 1778 Chill Out
 */
class FreezyLogTest : StringSpec() {

    init {
        FreezyLog.dump()
        FreezyLog.setPath(createTempDir().toString())

        "An invalid file name should throw an exception" {
            shouldThrow<Exception> { FreezyLog.setMetaFileName("/meta.notjson") }
            shouldThrow<Exception> { FreezyLog.setLogFileName("/meta.notcsv") }
        }

        "A valid file name should not throw an exception" {
            shouldNotThrowAny { FreezyLog.setMetaFileName("/meta.json") }
            shouldNotThrowAny { FreezyLog.setLogFileName("/meta.csv") }
        }

        FreezyLog.populateMatchStructure(MatchType.Qualification, 0)
        FreezyLog.addField(MetaField("MetaField", Measurement.Unitless.UNITLESS, "meta"))
        FreezyLog.addField(PolledField("PolledField", Measurement.Length.INCHES) { "polled" })

        val taggedField = TaggedField("TaggedField", Measurement.Acceleration.METERS_PER_SECOND_SQUARED, Int::class)
        taggedField.updateTag(0)
        FreezyLog.addField(taggedField)

        val subscribedField = SubscribedField("SubscribedField", Measurement.Angle.DEGREES, Int::class)
        subscribedField.pushValue(0)
        FreezyLog.addField(subscribedField)

        try {
            throw IOException("Forcefully thrown exception")
        } catch (e: Exception) {
            FreezyLog.logException(e)
        }

        for (i in 1 until 4) {
            FreezyLog.log()
            subscribedField.pushValue(i)
            taggedField.updateTag(-i)
        }

        "Log file should match with example CSV" {
            FreezyLog.logFile.readText() shouldBe Thread.currentThread().contextClassLoader.getResource("log.csv")!!.readText()
        }
        "Meta file should match with example JSON" {
            FreezyLog.metaFile.readText() shouldBe Thread.currentThread().contextClassLoader.getResource("meta.json")!!.readText()
        }
    }
}
