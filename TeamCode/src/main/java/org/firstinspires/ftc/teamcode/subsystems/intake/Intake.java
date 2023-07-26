package org.firstinspires.ftc.teamcode.subsystems.intake;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.ServoImpl;

import org.firstinspires.ftc.teamcode.util.PolarCoordinate;

public class Intake extends SubsystemBase {
    public final RollerIntake intake;
    public final Positioner positioner;

    public Intake(RollerIntake intake, Positioner positioner) {
        this.intake = intake;
        this.positioner = positioner;
    }

    public void toPosition(double x, double y) {
        toPosition(PolarCoordinate.rectangularToPolar(x, y));
    }

    public void toPosition(PolarCoordinate coords) {
        intake.setTargetAngle(-coords.getAngle());
        positioner.setTargetAngle(coords.getAngle());
        positioner.setSlidePosition(coords.getScale());
    }

    public void stow() {
        System.out.println("stowing...");
        intake.setTargetAngle(-180);
        positioner.setTargetAngle(90);
        positioner.setSlidePosition(positioner.getMinimumSlidePosition());
    }

    public double getSlidePosition() {
        return positioner.getSlidePosition();
    }

    public double getAngle() {
        return positioner.getAngle();
    }

    public double getIntakeAngle() {
        return intake.getTargetAngle();
    }

    public void intake() {
        intake.intake();
    }

    public void intake(float pwr) {
        intake.intake(pwr);
    }

    public void outtake() {
        intake.outtake();
    }

    public void outtake(float pwr) {
        intake.outtake(pwr);
    }

    public void stopIntake() {
        intake.stopIntake();
    }

    public boolean intakeHasElement() {
        return intake.hasGameElement();
    }

    public boolean atPosition() {
        return positioner.angleAtPosition() && positioner.slideAtPosition();
    }
}
