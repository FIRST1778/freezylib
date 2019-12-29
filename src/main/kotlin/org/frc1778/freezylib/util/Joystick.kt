package org.frc1778.freezylib.util

import edu.wpi.first.wpilibj.DriverStation

/**
 * Contains constants for The parent class of all joysticks, allowing for driver input to be easily altered for
 * different devices.
 *
 * @author FRC 1778 Chill Out
 */
object Joystick {

    fun isConnected(name: String, port: Int): Boolean {
        return if (DriverStation.getInstance().isDSAttached)
            name == DriverStation.getInstance().getJoystickName(port) &&
            (DriverStation.getInstance().getStickAxisCount(port) > 0 ||
            DriverStation.getInstance().getStickButtonCount(port) > 0 ||
            DriverStation.getInstance().getStickPOVCount(port) > 0) else false
    }

    interface Base {
        val id: Int
        val type: Byte
    }

    enum class LogitechF310(override val id: Int, override val type: Byte) : Base {
        DPAD(0, 2),

        A(1, 0),
        B(2, 0),
        X(3, 0),
        Y(4, 0),
        LEFT_BUMPER(5, 0),
        RIGHT_BUMPER(6, 0),
        BACK(7, 0),
        START(8, 0),
        LEFT_JOYSTICK_BUTTON(9, 0),
        RIGHT_JOYSTICK_BUTTON(10, 0),

        AXIS_LEFT_X(0, 1),
        AXIS_LEFT_TRIGGER(2, 1),
        AXIS_RIGHT_TRIGGER(3, 1),
        AXIS_RIGHT_X(4, 1),
        AXIS_RIGHT_Y(5, 1)
    }

    enum class InterLinkElite(override val id: Int, override val type: Byte) : Base {
        LEFT_SWITCH(1, 0),
        LEFT_SHOULDER_SWITCH(5, 0),
        RIGHT_SHOULDER_SWITCH(2, 0),
        RESET_BUTTON(3, 0),

        AXIS_LEFT_X(2, 1),
        AXIS_LEFT_Y(5, 1),
        AXIS_RIGHT_X(1, 1),
        AXIS_RIGHT_Y(0, 1),
        AXIS_TUNER(6, 1)
    }

    enum class FreezyController(override val id: Int, override val type: Byte) : Base {
        RIGHT_SHOULDER_SWITCH(1, 0),
        LEFT_SHOULDER_SWITCH(2, 0),

        AXIS_LEFT_X(0, 1),
        AXIS_LEFT_Y(1, 1),
        AXIS_RIGHT_X(2, 1),
        AXIS_RIGHT_Y(3, 1)
    }
}
