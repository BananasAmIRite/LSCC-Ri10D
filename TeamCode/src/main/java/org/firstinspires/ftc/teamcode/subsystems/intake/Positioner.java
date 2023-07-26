package org.firstinspires.ftc.teamcode.subsystems.intake;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorImpl;

public class Positioner {

    // ANGLE
    // NOTE: the angle most be zeroed at the horizontal position
    private static final double ANGLE_DEGREE_PER_TICK = 0.1;
    private static final double ANGLE_ERROR_THRESHOLD_DEGREES = 1; // 1 degree

    // SLIDE
    public static final double SLIDE_INITIAL_POSITION_INCHES = 13.2283; // from gobilda viper kit
    private static final double SLIDE_INCHES_PER_TICK = 0.05;
    private static final double SLIDE_ERROR_THRESHOLD_INCHES = 0.5; // eyeballed

    private final DcMotor angleMotor;
    private final DcMotor slideMotor;



    public Positioner(DcMotor pivotMotor, DcMotor slideMotor) {
        this.angleMotor = pivotMotor;
        this.slideMotor = slideMotor;

        setupMotors();
    }

    public void setupMotors() {
        // angle
        angleMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        angleMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        angleMotor.setPower(1);
//        angleMotor.setTargetPositionTolerance((int) (ANGLE_ERROR_THRESHOLD_DEGREES / ANGLE_DEGREE_PER_TICK));

        // slide
        slideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        slideMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slideMotor.setPower(1);
//        slideMotor.setTargetPositionTolerance((int) (SLIDE_ERROR_THRESHOLD_INCHES / SLIDE_INCHES_PER_TICK));
    }

    // ANGLE

    public double getAngle() {
        System.out.println("angleMotor Angle: " + angleMotor.getCurrentPosition());
        return angleMotor.getCurrentPosition() * ANGLE_DEGREE_PER_TICK;
    }

    public double getTargetAngle() {
        return angleMotor.getTargetPosition() * ANGLE_DEGREE_PER_TICK;
    }

    public boolean angleAtPosition() {
        return Math.abs(angleMotor.getTargetPosition() - angleMotor.getCurrentPosition()) * ANGLE_DEGREE_PER_TICK <= ANGLE_ERROR_THRESHOLD_DEGREES;
    }

    public void setTargetAngle(double degrees) {
        angleMotor.setTargetPosition((int) (degrees / ANGLE_DEGREE_PER_TICK));
    }

    // SLIDE
    public double getSlidePosition() {
        return slideMotor.getCurrentPosition() * SLIDE_INCHES_PER_TICK + SLIDE_INITIAL_POSITION_INCHES;
    }

    public double getMinimumSlidePosition() {
        return SLIDE_INITIAL_POSITION_INCHES;
    }

    public double getTargetSlidePosition() {
        return slideMotor.getTargetPosition() * SLIDE_INCHES_PER_TICK + SLIDE_INITIAL_POSITION_INCHES;
    }

    public boolean slideAtPosition() {
        return Math.abs(slideMotor.getTargetPosition() - slideMotor.getCurrentPosition()) * SLIDE_INCHES_PER_TICK <= SLIDE_ERROR_THRESHOLD_INCHES;
    }

    /**
     * sets slide position in inches
     * */
    public void setSlidePosition(double position) {
        slideMotor.setTargetPosition((int) (Math.max(position - SLIDE_INITIAL_POSITION_INCHES, 0) / SLIDE_INCHES_PER_TICK));
    }

    public double getLSPower() {
        return slideMotor.getPower();
    }

    public double getAnglerMotor() {
        return angleMotor.getPower();
    }
}
