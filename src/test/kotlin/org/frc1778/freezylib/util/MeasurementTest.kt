package org.frc1778.freezylib.util

import org.assertj.core.api.Assertions.assertThat

import org.assertj.core.data.Offset
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

class MeasurementTest {

    @Test
    private fun testConversion() {
        val kilometer = Measurement(1.5, Measurement.Length.KILOMETERS)
        assertThat(kilometer.convertTo(Measurement.Length.INCHES).value)
                .isEqualTo(59055.118110236224, Offset.offset(1e-9))

        val fahrenheit = Measurement(212.0, Measurement.Temperature.DEGREE_FAHRENHEIT)
        assertThat(fahrenheit.convertTo(Measurement.Temperature.DEGREE_CELSIUS).value)
                .isEqualTo(100.0, Offset.offset(1e-9))

        val pounds = Measurement(1.5, Measurement.Mass.POUNDS)
        assertThat(pounds.convertTo(Measurement.Mass.GRAMS).value)
                .isEqualTo(680.3885564999999, Offset.offset(1e-9))
    }

    @Test
    private fun incompatibleTypesShouldThrowException() {
        assertFailsWith<IllegalArgumentException> {
                    Measurement(0.0, Measurement.Acceleration.GRAVITY)
                            .convertTo(Measurement.Duration.HOURS)
                }
    }
}
