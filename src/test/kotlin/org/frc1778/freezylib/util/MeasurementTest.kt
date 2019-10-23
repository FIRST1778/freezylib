package org.frc1778.freezylib.util

import io.kotlintest.matchers.doubles.plusOrMinus
import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import io.kotlintest.specs.StringSpec
import java.lang.IllegalArgumentException

class MeasurementTest : StringSpec() {

    init {
        "An incompatible type should throw an IllegalArgumentException" {
                shouldThrow<IllegalArgumentException> { Measurement(0.0, Measurement.Acceleration.GRAVITY).convertTo(Measurement.Duration.HOURS) }
        }

        "1.5 Kilometers should be 4921.26 feet" {
            Measurement(1.5, Measurement.Length.KILOMETERS).convertTo(Measurement.Length.FEET).value shouldBe (4921.26 plusOrMinus 1e-3)
        }

        "212 degrees Fahrenheit should be 100 degrees Celsius" {
            Measurement(212.0, Measurement.Temperature.DEGREE_FAHRENHEIT).convertTo(Measurement.Temperature.DEGREE_CELSIUS).value shouldBe (100.0 plusOrMinus 1e-3)
        }

        "1.5 pounds should be 680.389 grams" {
            Measurement(1.5, Measurement.Mass.POUNDS).convertTo(Measurement.Mass.GRAMS).value shouldBe (680.389 plusOrMinus 1e-3)
        }
    }
}
