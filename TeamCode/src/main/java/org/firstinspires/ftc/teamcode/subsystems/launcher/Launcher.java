package org.firstinspires.ftc.teamcode.subsystems.launcher;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class Launcher extends SubsystemBase {

    // ANGLE
    // NOTE: the angle most be zeroed at the horizontal position
    private static final double ANGLE_DEGREE_PER_TICK = 0.1;
    private static final double ANGLE_ERROR_THRESHOLD_DEGREES = 1; // 1 degree

    // LAUNCHER
    public static final double LAUNCH_SPEED_INCHES_PER_SECOND = 10;

    private final DcMotor launcherAngleMotor;

    public Launcher(DcMotor launcherAngleMotor) {
        this.launcherAngleMotor = launcherAngleMotor;
        setupMotors();
    }

    public void setupMotors() {
        // angle
        launcherAngleMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        launcherAngleMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        launcherAngleMotor.setTargetPositionTolerance((int) (ANGLE_ERROR_THRESHOLD_DEGREES / ANGLE_DEGREE_PER_TICK));
    }

    public void motorToAngle(double degrees) {
        launcherAngleMotor.setTargetPosition((int) (degrees / ANGLE_DEGREE_PER_TICK));
    }

    public boolean motorAtAngle() {
        return Math.abs(launcherAngleMotor.getTargetPosition() - launcherAngleMotor.getCurrentPosition()) * ANGLE_DEGREE_PER_TICK <= ANGLE_ERROR_THRESHOLD_DEGREES;
    }

    public double getAngle() {
        return launcherAngleMotor.getCurrentPosition() * ANGLE_DEGREE_PER_TICK;
    }

    public void shoot() {
        // TODO: TO BE IMPLEMENTED
    }
}
