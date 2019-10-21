package org.frc1778.freezylib.logging

import com.google.gson.GsonBuilder
import edu.wpi.first.wpilibj.DriverStation.MatchType
import java.io.File
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.util.Locale
import java.util.stream.Collectors

/**
 * A logging framework to log data from the robot to files on the robot.
 *
 * @author FRC 1778 Chill Out
 */
object FreezyLog {

    private var fields = mutableListOf<Field>()

    private var csvFileName = "log.csv"
    private var jsonFileName = "meta.json"

    private var pathToLogDirectory = "/home/lvuser/logs"
    lateinit var logFile: File
    lateinit var metaFile: File

    private var filesDirty = true

    private val gson = GsonBuilder().setPrettyPrinting().serializeNulls().excludeFieldsWithoutExposeAnnotation().create()

    val csvHeader: String
        get() = fields.stream().filter { it::class != MetaField::class }.map { o -> o.name }.collect(Collectors.joining(","))

    private val collectedFields: String
        get() = fields.stream().filter { it::class != MetaField::class }.map { o -> o.value }.collect(Collectors.joining(","))

    fun setPath(path: String) {
        pathToLogDirectory = path
        filesDirty = true
    }

    fun populateMatchStructure(matchType: MatchType, matchNumber: Int) {
        val path = Path.of(
                pathToLogDirectory,
                matchType.name.toLowerCase(Locale.ENGLISH),
                "match" + String.format("%02d", matchNumber))
        try {
            Files.createDirectories(path)
            metaFile = File(path.toString(), jsonFileName)
            logFile = File(path.toString(), csvFileName)
        } catch (e: IOException) {
            System.err.println(e.message)
        }

        filesDirty = true
    }

    @Throws(Exception::class)
    fun setLogFileName(name: String) {
        val i = name.lastIndexOf('.')

        if ((if (i > 0) name.substring(i + 1) else "") != "csv") {
            throw Exception(
                    "Invalid file extension, should be 'csv', but was '" +
                            (if (i > 0) name.substring(i + 1) else "") +
                            "'.")
        } else {
            csvFileName = name
        }

        filesDirty = true
    }

    @Throws(Exception::class)
    fun setMetaFileName(name: String) {
        val i = name.lastIndexOf('.')

        if ((if (i > 0) name.substring(i + 1) else "") != "json") {
            throw Exception(
                    "Invalid file extension, should be 'json', but was '" +
                            (if (i > 0) name.substring(i + 1) else "") +
                            "'.")
        } else {
            jsonFileName = name
        }

        filesDirty = true
    }

    fun addField(field: Field) {
        fields.add(field)
        filesDirty = true
    }

    fun removeField(field: Field) {
        fields.remove(field)
        filesDirty = true
    }

    fun dump() {
        fields.clear()
        filesDirty = true
    }

    private fun pollFields() {
        fields.stream()
                .filter { o -> o is PolledField<*> }
                .map { o -> o as PolledField<*> }
                .forEach { it.pollSupplier() }
    }

    fun getFields(): List<Field> {
        return fields
    }

    fun getFieldByName(name: String): Field {
        return fields.stream().filter { o -> o.name == name }.findFirst().get()
    }

    fun log() {
        pollFields()

        try {
            var csvOut = ""
            if (filesDirty) {
                logFile.delete()
                csvOut += csvHeader + "\n"

                metaFile.writeText(gson.toJson(fields))

                filesDirty = false
            }

            csvOut += if (collectedFields.replace(",".toRegex(), "").isNotEmpty()) collectedFields else ""

            if (csvOut.isNotEmpty()) {
                logFile.writeText(csvOut + "\n")
            }
        } catch (e: IOException) {
            System.err.println(e.message)
        }
    }
}
