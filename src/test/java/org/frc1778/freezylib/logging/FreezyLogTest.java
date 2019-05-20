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
    FreezyLog.populateMatchStructure(MatchType.Qualification, 0);
    FreezyLog.addField(new MetaField("MetaField", "ul", "meta"));
    FreezyLog.addField(new PolledField("PolledField", Measurement.Length.INCHES, () -> "polled"));
    SubscribedField subscribedField =
        new SubscribedField("SubscribedField", Measurement.Angle.DEGREES, String.class);
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
}
