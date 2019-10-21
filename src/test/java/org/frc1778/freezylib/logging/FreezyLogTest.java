package org.frc1778.freezylib.logging;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.fail;

import com.google.common.io.Files;
import edu.wpi.first.wpilibj.DriverStation.MatchType;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import org.frc1778.freezylib.util.Measurement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * Tests the FreezyLog class and main methods.
 *
 * @author FRC 1778 Chill Out
 */
public class FreezyLogTest {

  @BeforeEach
  public void dumpFreezyLog() {
    FreezyLog.dump();
  }

  @Test
  public void providingAnInvalidFileNameShouldThrowException() {
    assertThatExceptionOfType(Exception.class)
        .isThrownBy(() -> FreezyLog.setMetaFileName("/meta.notjson"));
    assertThatCode(() -> FreezyLog.setMetaFileName("/meta.json")).doesNotThrowAnyException();

    assertThatExceptionOfType(Exception.class)
        .isThrownBy(() -> FreezyLog.setLogFileName("/log.notcsv"));
    assertThatCode(() -> FreezyLog.setLogFileName("/log.csv")).doesNotThrowAnyException();
  }

  @Test
  public void freezyLogShouldFormatCsvAndJsonFilesToMatchExamples(@TempDir Path folder) {
    FreezyLog.setPath(folder.toString());
    FreezyLog.populateMatchStructure(MatchType.Qualification, 0);
    FreezyLog.addField(new MetaField("MetaField", Measurement.Unitless.UNITLESS, "meta"));
    FreezyLog.addField(new PolledField("PolledField", Measurement.Length.INCHES, () -> "polled"));
    var subscribedField =
        new SubscribedField("SubscribedField", Measurement.Angle.DEGREES, String.class);
    FreezyLog.addField(subscribedField);
    subscribedField.pushValue("subscribed");

    FreezyLog.log();

    try {
      assertThat(readFileAsCharSource(FreezyLog.getLogFile()))
          .isEqualTo(
              readFileAsCharSource(
                  new File(
                      Thread.currentThread()
                          .getContextClassLoader()
                          .getResource("log.csv")
                          .getFile())));
      assertThat(readFileAsCharSource(FreezyLog.getMetaFile()))
          .isEqualTo(
              readFileAsCharSource(
                  new File(
                      Thread.currentThread()
                          .getContextClassLoader()
                          .getResource("meta.json")
                          .getFile())));
    } catch (IOException e) {
      fail(e.getMessage());
    }
  }

  private String readFileAsCharSource(File file) throws IOException {
    return Files.asCharSource(file, StandardCharsets.UTF_8)
        .read()
        .replaceAll("\\r\\n", "\n")
        .replaceAll("\\r", "\n");
  }
}
