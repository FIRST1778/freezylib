package org.frc1778.freezylib.util

import io.kotlintest.data.forall
import io.kotlintest.matchers.doubles.plusOrMinus
import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.row
import java.lang.IllegalArgumentException

class MeasurementTest : StringSpec() {

    init {
        "An incompatible type should throw an IllegalArgumentException" {
            shouldThrow<IllegalArgumentException> { Measurement(0.0, Measurement.Acceleration.GRAVITY).convertTo(Measurement.Duration.HOURS) }
        }

        "Conversion tests" {
            forall(
                    row(1.5, Measurement.Length.KILOMETERS, Measurement.Length.FEET, 4921.26),
                    row(212.0, Measurement.Temperature.DEGREE_FAHRENHEIT, Measurement.Temperature.DEGREE_CELSIUS, 100.0),
                    row(1.5, Measurement.Mass.POUNDS, Measurement.Mass.GRAMS, 680.389)
            ) { input: Double, inputUnit: Measurement.Base, convertedUnit: Measurement.Base, converted: Double ->
                Measurement(input, inputUnit).convertTo(convertedUnit).value shouldBe (converted plusOrMinus 1e-3)
            }
        }
    }
}
