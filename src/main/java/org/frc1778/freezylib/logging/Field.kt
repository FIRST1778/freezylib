package org.frc1778.freezylib.logging

import com.google.gson.annotations.Expose
import org.frc1778.freezylib.util.Measurement

abstract class Field {

    @Expose var name = ""
    @Expose var unit = ""
    @Expose lateinit var type: String

    abstract var value: String

    fun setUnit(unit: Measurement.Base) {
        this.unit = unit.toString()
    }

    fun setType(type: Class<*>) {
        this.type = type.name
    }
}