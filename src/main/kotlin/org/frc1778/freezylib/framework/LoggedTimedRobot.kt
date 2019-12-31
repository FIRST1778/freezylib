package org.frc1778.freezylib.framework

import edu.wpi.first.wpilibj.DriverStation
import edu.wpi.first.wpilibj.RobotBase
import edu.wpi.first.wpilibj.TimedRobot
import edu.wpi.first.wpilibj.livewindow.LiveWindow
import org.frc1778.freezylib.logging.FreezyLog

abstract class LoggedTimedRobot {

    private val timedRobot = DefaultTimedRobot()

    inner class DefaultTimedRobot : TimedRobot() {

        override fun robotInit() {
            try {
                FreezyLog.populateMatchStructure(DriverStation.getInstance().matchType, DriverStation.getInstance().matchNumber)
                this@LoggedTimedRobot.robotInit()
                LiveWindow.disableAllTelemetry()
            } catch (e: Exception) {
                FreezyLog.logException(e)
            }
        }

        override fun autonomousInit() {
            try {
                this@LoggedTimedRobot.autonomousInit()
            } catch (e: Exception) {
                FreezyLog.logException(e)
            }
        }

        override fun teleopInit() {
            try {
                this@LoggedTimedRobot.teleopInit()
            } catch (e: Exception) {
                FreezyLog.logException(e)
            }
        }

        override fun disabledInit() {
            try {
                this@LoggedTimedRobot.disabledInit()
            } catch (e: Exception) {
                FreezyLog.logException(e)
            }
        }

        override fun testInit() {
            try {
                this@LoggedTimedRobot.testInit()
            } catch (e: Exception) {
                FreezyLog.logException(e)
            }
        }

        override fun robotPeriodic() {
            try {
                this@LoggedTimedRobot.robotPeriodic()
                FreezyLog.log()
            } catch (e: Exception) {
                FreezyLog.logException(e)
            }
        }

        override fun autonomousPeriodic() {
            try {
                this@LoggedTimedRobot.autonomousPeriodic()
            } catch (e: Exception) {
                FreezyLog.logException(e)
            }
        }

        override fun teleopPeriodic() {
            try {
                this@LoggedTimedRobot.teleopPeriodic()
            } catch (e: Exception) {
                FreezyLog.logException(e)
            }
        }

        override fun disabledPeriodic() {
            try {
                this@LoggedTimedRobot.disabledPeriodic()
            } catch (e: Exception) {
                FreezyLog.logException(e)
            }
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
