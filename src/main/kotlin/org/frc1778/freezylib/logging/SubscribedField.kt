package org.frc1778.freezylib.logging

import org.frc1778.freezylib.util.Measurement
import kotlin.reflect.KClass

class SubscribedField(name: String, unit: Measurement.Base, type: KClass<*>) : Field() {

    override var value = ""

    init {
        this.name = name
        this.unit = unit.symbol
        setType(type)
    }

    fun <T> pushValue(value: T) {
        this.value = value.toString()
    }
}
