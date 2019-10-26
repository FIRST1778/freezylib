package org.frc1778.freezylib.logging

import org.frc1778.freezylib.util.Measurement

class PolledField<T>(name: String, unit: Measurement.Base, supplier: () -> T) : Field() {

    private val supplier: () -> String
    override lateinit var value: String

    init {
        this.name = name
        this.unit = unit
        setType((supplier.invoke() as Any)::class)
        this.supplier = { supplier().toString() }
    }

    fun pollSupplier() {
        value = supplier()
    }
}
