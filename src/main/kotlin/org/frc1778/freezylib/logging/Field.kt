package org.frc1778.freezylib.logging

import com.google.gson.annotations.Expose
import kotlin.reflect.KClass
import org.frc1778.freezylib.util.Measurement

abstract class Field {

    @Expose var name = ""
    @Expose var symbol = ""
    @Expose var unit: Measurement.Base = Measurement.Unitless.UNITLESS
        set(value) {
        field = value
        this.symbol = value.symbol
    }
    @Expose lateinit var type: String

    abstract var value: String

    fun setType(type: KClass<*>) {
        this.type = type.toString()
    }
}
