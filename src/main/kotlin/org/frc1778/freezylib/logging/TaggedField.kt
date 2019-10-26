package org.frc1778.freezylib.logging

import kotlin.reflect.KClass
import org.frc1778.freezylib.util.Measurement

class TaggedField(name: String, unit: Measurement.Base, type: KClass<*>) : Field() {

    private var isNewValue = false
    override var value: String = ""
        get() {
            val out = if (isNewValue) field else ""
            isNewValue = false
            return out
        }

    init {
        this.name = name
        this.unit = unit
        this.value = value
        setType(type)
    }

    fun <T> updateTag(value: T) {
        this.value = value.toString()
        isNewValue = true
    }
}
