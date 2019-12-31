package org.frc1778.freezylib.framework

import edu.wpi.first.wpilibj.DriverStation
import edu.wpi.first.wpilibj.RobotBase
import edu.wpi.first.wpilibj.TimedRobot
import edu.wpi.first.wpilibj.livewindow.LiveWindow
import org.frc1778.freezylib.logging.FreezyLog
import org.frc1778.freezylib.logging.TaggedField
import org.frc1778.freezylib.util.Measurement

abstract class LoggedTimedRobot {

    private val timedRobot = DefaultTimedRobot()

    inner class DefaultTimedRobot : TimedRobot() {

        val programStateField = TaggedField("Program State", Measurement.Unitless.UNITLESS, String::class)

        init {
            FreezyLog.addField(programStateField)
        }

        override fun robotInit() {
            FreezyLog.populateMatchStructure(DriverStation.getInstance().matchType, DriverStation.getInstance().matchNumber)
            programStateField.updateTag("robotoInit")
            try {
                this@LoggedTimedRobot.robotInit()
                LiveWindow.disableAllTelemetry()
            } catch (e: Exception) {
                FreezyLog.logException(e)
            }
            FreezyLog.log()
            programStateField.updateTag("robotPeriodic")
        }

        override fun autonomousInit() {
            programStateField.updateTag("autonomousInit")
            try {
                this@LoggedTimedRobot.autonomousInit()
            } catch (e: Exception) {
                FreezyLog.logException(e)
            }
            FreezyLog.log()
            programStateField.updateTag("autonomousPeriodic")
        }

        override fun teleopInit() {
            programStateField.updateTag("teleopInit")
            try {
                this@LoggedTimedRobot.teleopInit()
            } catch (e: Exception) {
                FreezyLog.logException(e)
            }
            FreezyLog.log()
            programStateField.updateTag("teleopPeriodic")
        }

        override fun disabledInit() {
            programStateField.updateTag("disabledInit")
            try {
                this@LoggedTimedRobot.disabledInit()
            } catch (e: Exception) {
                FreezyLog.logException(e)
            }
            FreezyLog.log()
            programStateField.updateTag("disabledPeriodic")
        }

        override fun testInit() {
            programStateField.updateTag("testInit")
            try {
                this@LoggedTimedRobot.testInit()
            } catch (e: Exception) {
                FreezyLog.logException(e)
            }
            FreezyLog.log()
            programStateField.updateTag("testPeriodic")
        }

        override fun robotPeriodic() {
            try {
                this@LoggedTimedRobot.robotPeriodic()
            } catch (e: Exception) {
                FreezyLog.logException(e)
            }
            FreezyLog.log()
        }

        override fun autonomousPeriodic() {
            try {
                this@LoggedTimedRobot.autonomousPeriodic()
            } catch (e: Exception) {
                FreezyLog.logException(e)
            }
            FreezyLog.log()
        }

        override fun teleopPeriodic() {
            try {
                this@LoggedTimedRobot.teleopPeriodic()
            } catch (e: Exception) {
                FreezyLog.logException(e)
            }
            FreezyLog.log()
        }

        override fun disabledPeriodic() {
            try {
                this@LoggedTimedRobot.disabledPeriodic()
            } catch (e: Exception) {
                FreezyLog.logException(e)
            }
            FreezyLog.log()
        }
    }

    open fun robotInit() {}
    open fun autonomousInit() {}
    open fun teleopInit() {}
    open fun disabledInit() {}
    open fun testInit() {}

    open fun robotPeriodic() {}
    open fun autonomousPeriodic() {}
    open fun teleopPeriodic() {}
    open fun disabledPeriodic() {}

    fun start() {
        RobotBase.startRobot { timedRobot }
    }
}
