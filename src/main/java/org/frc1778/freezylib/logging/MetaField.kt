package org.frc1778.freezylib.logging

import com.google.gson.annotations.Expose
import org.frc1778.freezylib.util.Measurement

class MetaField<T>(name: String, unit: Measurement.Base, value: T) : Field() {

    @Expose
    override lateinit var value: String

    init {
        this.name = name
        this.unit = unit.symbol
        this.value = value.toString()
        setType((value as Any)::class.java)
    }
}
