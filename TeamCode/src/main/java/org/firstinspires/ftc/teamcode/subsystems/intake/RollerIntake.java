package org.firstinspires.ftc.teamcode.subsystems.intake;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

public class RollerIntake {

    // pivot

    // intake
    private static final float DEFAULT_INTAKE_POWER = 0.8f;
    public static final long INTAKE_TIME_SECONDS = 1;

    // current for when the motor has something inside
    public static final double STALL_CURRENT_AMPS = 10;


    private final Servo pivotServo;
    private final DcMotor intakeMotor;

    public RollerIntake(Servo pivotServo, DcMotor intakeMotor) {
        this.pivotServo = pivotServo;
        this.intakeMotor = intakeMotor;

        this.configMotors();
    }

    private void configMotors() {
        // NOTE: angle servo must be programmed so that HORIZONTAL is 0 degrees

        // intake
        intakeMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    // ANGLE
    public double getTargetAngle() {
        return (pivotServo.getPosition() - 0.5) * 360;
    }
    public void setTargetAngle(double degrees) {
        pivotServo.setPosition((degrees / 360) + 0.5);
    }

    // INTAKE

    public void intake() {
        intake(DEFAULT_INTAKE_POWER);
    }

    public void intake(float pwr) {
        intakeMotor.setPower(-pwr); // depends on direction
    }

    public void outtake() {
        outtake(DEFAULT_INTAKE_POWER);
    }

    public void outtake(float pwr) {
        intakeMotor.setPower(pwr); // depends on direction
    }

    public void stopIntake() {
        intakeMotor.setPower(0);
    }

    public boolean hasGameElement() {
//        this.intakeMotor.get
//        return this.intakeMotor.getCurrent(org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit.AMPS) <= STALL_CURRENT_AMPS;
        return false;
    }
}
