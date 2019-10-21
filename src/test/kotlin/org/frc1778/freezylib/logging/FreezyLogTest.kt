package org.frc1778.freezylib.logging

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.fail

import com.google.common.io.Files
import edu.wpi.first.wpilibj.DriverStation.MatchType
import java.io.File
import java.io.IOException
import java.nio.charset.StandardCharsets
import java.nio.file.Path
import org.frc1778.freezylib.util.Measurement
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.io.TempDir
import kotlin.test.assertFailsWith

/**
 * Tests the FreezyLog class and main methods.
 *
 * @author FRC 1778 Chill Out
 */
class FreezyLogTest {

    @BeforeEach
    private fun dumpFreezyLog() {
        FreezyLog.dump()
    }

    @Test
    private fun providingAnInvalidFileNameShouldThrowException() {
        assertFailsWith<Exception> { FreezyLog.setMetaFileName("/meta.notjson") }
        assertDoesNotThrow { FreezyLog.setMetaFileName("/meta.json") }

        assertFailsWith<Exception> { FreezyLog.setLogFileName("/log.notcsv") }
        assertDoesNotThrow { FreezyLog.setLogFileName("/log.csv") }
    }

    @Test
    private fun freezyLogShouldFormatCsvAndJsonFilesToMatchExamples(@TempDir folder: Path) {
        FreezyLog.setPath(folder.toString())
        FreezyLog.populateMatchStructure(MatchType.Qualification, 0)
        FreezyLog.addField(MetaField("MetaField", Measurement.Unitless.UNITLESS, "meta"))
        FreezyLog.addField(PolledField("PolledField", Measurement.Length.INCHES) { "polled" })
        val subscribedField = SubscribedField("SubscribedField", Measurement.Angle.DEGREES, String::class)
        FreezyLog.addField(subscribedField)
        subscribedField.pushValue("subscribed")

        FreezyLog.log()

        try {
            assertThat(readFileAsCharSource(FreezyLog.logFile)).isEqualTo(readFileAsCharSource(File(Thread.currentThread().contextClassLoader.getResource("log.csv")!!.file)))
            assertThat(readFileAsCharSource(FreezyLog.metaFile)).isEqualTo(readFileAsCharSource(File(Thread.currentThread().contextClassLoader.getResource("meta.json")!!.file)))
        } catch (e: IOException) {
            fail<Any>(e.message)
        }
    }

    @Throws(IOException::class)
    private fun readFileAsCharSource(file: File): String {
        return Files.asCharSource(file, StandardCharsets.UTF_8).read().replace("\\r\\n".toRegex(), "\n").replace("\\r".toRegex(), "\n")
    }
}
