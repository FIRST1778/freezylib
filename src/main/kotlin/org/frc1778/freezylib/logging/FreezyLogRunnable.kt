package org.frc1778.freezylib.logging

abstract class FreezyLogRunnable : Runnable {

    override fun run() {
        try {
            runWithLogging()
        } catch (t: Throwable) {
            FreezyLog.exceptionsField.updateTag(t.stackTrace)
        }
    }

    abstract fun runWithLogging()
}
