package org.frc1778.freezylib.logging;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.fail;

import com.google.common.io.Files;
import edu.wpi.first.wpilibj.DriverStation.MatchType;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import org.frc1778.freezylib.util.Measurement.UnitAngle;
import org.frc1778.freezylib.util.Measurement.UnitDuration;
import org.frc1778.freezylib.util.Measurement.UnitLength;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * Tests the FreezyLog class and main methods.
 *
 * @author FRC 1778 Chill Out
 */
public class FreezyLogTest {

  @Test
  public void providingAnInvalidFileNameShouldThrowException(@TempDir Path folder) {
    String goodMetaFile = "/meta.json";
    String badMetaFile = "/meta.notjson";
    String goodLogFile = "/log.csv";
    String badLogFile = "/log.notcsv";

    assertThatExceptionOfType(Exception.class)
        .isThrownBy(() -> FreezyLog.setMetaFileName(badMetaFile));
    assertThatCode(() -> FreezyLog.setMetaFileName(goodMetaFile)).doesNotThrowAnyException();

    assertThatExceptionOfType(Exception.class)
        .isThrownBy(() -> FreezyLog.setLogFileName(badLogFile));
    assertThatCode(() -> FreezyLog.setLogFileName(goodLogFile)).doesNotThrowAnyException();
  }

  @Test
  public void freezyLogShouldFormatCsvAndJsonFilesToMatchExamples(@TempDir Path folder) {
    FreezyLog.setPath(folder.toString());
    FreezyLog.dump();
    FreezyLog.populateMatchStructure(MatchType.Qualification, 0);
    FreezyLog.addField(new MetaField("MetaField", "ul", "meta"));
    FreezyLog.addField(new PolledField("PolledField", UnitLength.INCHES, () -> "polled"));
    SubscribedField subscribedField =
        new SubscribedField("SubscribedField", UnitAngle.DEGREES, String.class);
    FreezyLog.addField(subscribedField);

    subscribedField.pushValue("subscribed");
    FreezyLog.log();

    try {
      assertThat(
              Files.asCharSource(FreezyLog.getCsvFile(), Charset.forName("UTF-8"))
                  .read()
                  .replaceAll("\\r\\n", "\n")
                  .replaceAll("\\r", "\n"))
          .isEqualTo(
              Files.asCharSource(
                      new File(getClass().getClassLoader().getResource("log.csv").getFile()),
                      Charset.forName("UTF-8"))
                  .read()
                  .replaceAll("\\r\\n", "\n")
                  .replaceAll("\\r", "\n"));
      assertThat(
              Files.asCharSource(FreezyLog.getJsonFile(), Charset.forName("UTF-8"))
                  .read()
                  .replaceAll("\\r\\n", "\n")
                  .replaceAll("\\r", "\n"))
          .isEqualTo(
              Files.asCharSource(
                      new File(getClass().getClassLoader().getResource("meta.json").getFile()),
                      Charset.forName("UTF-8"))
                  .read()
                  .replaceAll("\\r\\n", "\n")
                  .replaceAll("\\r", "\n"));
    } catch (IOException e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void yoink() {
    FreezyLog.setPath("logs");
    FreezyLog.dump();
    FreezyLog.populateMatchStructure(MatchType.Qualification, 0);
    FreezyLog.addField(new PolledField("Poll", UnitLength.INCHES, () -> 0));

    SubscribedField subscribedField =
        new SubscribedField("Time", UnitDuration.SECONDS, Double.class);
    FreezyLog.addField(subscribedField);

    long max = Long.MIN_VALUE;
    long min = Long.MAX_VALUE;
    long sum = 0;

    for (int i = 0; i < 1000; i++) {
      long pre = System.nanoTime();
      FreezyLog.log();
      long post = System.nanoTime();
      long length = post - pre;

      max = Math.max(max, length);
      min = Math.min(min, length);
      sum += length;

      ((SubscribedField) FreezyLog.getFieldByName("Time")).pushValue(length);
    }

    System.out.println(
        "Min: " + (min / 1e+9) + ", max: " + (max / 1e+9) + ", average: " + ((sum / 1000) / 1e+9));
  }
}
