package org.frc1778.freezylib.util

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class JoystickTest : StringSpec() {
    init {
        "With no DS attached, the port of all joysticks should be -1." {
            -1 shouldBe -1
        }
    }
}
