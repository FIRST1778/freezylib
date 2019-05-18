package org.frc1778.freezylib.logging;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.wpi.first.wpilibj.DriverStation.MatchType;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A logging framework to log data from the robot to files on the robot.
 *
 * @author FRC 1778 Chill Out
 */
public class FreezyLog {

  private static List<Field> fields = new ArrayList<>();

  private static String csvFileName = "log.csv";
  private static String jsonFileName = "meta.json";

  private static String pathToLogDirectory = "/home/lvuser/logs/";
  private static File csvFile;
  private static File jsonFile;

  private static boolean filesDirty;

  private static Gson gson =
      new GsonBuilder()
          .setPrettyPrinting()
          .serializeNulls()
          .excludeFieldsWithoutExposeAnnotation()
          .create();

  public static void setPath(String path) {
    pathToLogDirectory = path;
  }

  public static void populateMatchStructure(MatchType matchType, int matchNumber) {
    Path path =
        Path.of(
            pathToLogDirectory,
            matchType.name().toLowerCase(),
            "match" + String.format("%02d", matchNumber));
    try {
      Files.createDirectories(path);
      jsonFile = new File(path.toString(), jsonFileName);
      csvFile = new File(path.toString(), csvFileName);
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }

    filesDirty = true;
  }

  public static void setLogFileName(String name) throws Exception {
    int i = name.lastIndexOf('.');

    if (!new String(i > 0 ? name.substring(i + 1) : "").equals("csv")) {
      throw new Exception(
          "Invalid file extension, should be 'csv', but was '"
              + (i > 0 ? name.substring(i + 1) : "")
              + "'.");
    } else {
      csvFileName = name;
    }

    filesDirty = true;
  }

  public static void setMetaFileName(String name) throws Exception {
    int i = name.lastIndexOf('.');

    if (!new String(i > 0 ? name.substring(i + 1) : "").equals("json")) {
      throw new Exception(
          "Invalid file extension, should be 'json', but was '"
              + (i > 0 ? name.substring(i + 1) : "")
              + "'.");
    } else {
      jsonFileName = name;
    }

    filesDirty = true;
  }

  public static File getJsonFile() {
    return jsonFile;
  }

  public static File getCsvFile() {
    return csvFile;
  }

  public static void addField(Field field) {
    fields.add(field);

    filesDirty = true;
  }

  public static void removeField(Field field) {
    fields.remove(field);

    filesDirty = true;
  }

  public static void dump() {
    fields.clear();

    filesDirty = true;
  }

  public static void pollFields() {
    fields.stream()
        .filter(o -> o instanceof PolledField)
        .map(o -> (PolledField) o)
        .forEach(PolledField::pollSupplier);
  }

  public static List<Field> getFields() {
    return fields;
  }

  public static Field getFieldByName(String name) {
    return fields.stream().filter(o -> o.getName().equals(name)).findFirst().get();
  }

  public static String getCsvHeader() {
    return fields.stream()
        .filter(o -> !o.getClass().equals(MetaField.class))
        .map(o -> o.getName())
        .collect(Collectors.joining(","));
  }

  public static String getCollectedFields() {
    return fields.stream()
        .filter(o -> !o.getClass().equals(MetaField.class))
        .map(o -> o.getValue())
        .collect(Collectors.joining(","));
  }

  public static void log() {
    pollFields();

    try {
      String csvOut = "";
      if (filesDirty) {
        csvFile.delete();
        csvOut += getCsvHeader() + "\n";

        try (Writer writer = new FileWriter(jsonFile, Charset.defaultCharset(), false)) {
          gson.toJson(fields, writer);
        }

        filesDirty = false;
      }
      csvOut += getCollectedFields() + "\n";

      try (PrintWriter csvWriter =
          new PrintWriter(new FileWriter(csvFile, Charset.defaultCharset(), true))) {
        csvWriter.write(csvOut);
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }
}
