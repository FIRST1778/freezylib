package org.frc1778.freezylib.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

public class MeasurementTest {

  @Test
  public void testConversion() {
    var kilometer = new Measurement(1.5, Measurement.Length.KILOMETERS);
    assertThat(kilometer.convertTo(Measurement.Length.INCHES).getValue())
        .isEqualTo(59055.118110236224, Offset.offset(1e-9));

    var fahrenheit = new Measurement(212, Measurement.Temperature.DEGREE_FAHRENHEIT);
    assertThat(fahrenheit.convertTo(Measurement.Temperature.DEGREE_CELSIUS).getValue())
        .isEqualTo(100.0, Offset.offset(1e-9));

    var pounds = new Measurement(1.5, Measurement.Mass.POUNDS);
    assertThat(pounds.convertTo(Measurement.Mass.GRAMS).getValue())
        .isEqualTo(680.3885564999999, Offset.offset(1e-9));
  }

  @Test
  public void incompatibleTypesShouldThrowException() {
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(
            () ->
                new Measurement(0.0, Measurement.Acceleration.GRAVITY)
                    .convertTo(Measurement.Duration.HOURS));
  }
}
