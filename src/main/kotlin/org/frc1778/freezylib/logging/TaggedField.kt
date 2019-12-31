package org.frc1778.freezylib.logging

import kotlin.reflect.KClass
import org.frc1778.freezylib.util.Measurement

class TaggedField(name: String, unit: Measurement.Base, type: KClass<*>) : Field() {

    override var value: String = ""

    init {
        this.name = name
        this.unit = unit
        setType(type)
    }

    fun <T> updateTag(value: T) {
        this.value = value.toString()
    }

    fun acknowledgeTag() {
        value = ""
    }
}
