package org.firstinspires.ftc.teamcode.subsystems.intake.simulation;

import org.firstinspires.ftc.teamcode.subsystems.intake.RollerIntake;
import org.firstinspires.ftc.teamcode.util.Direction;
import org.firstinspires.ftc.teamcode.util.Pose3d;

public class SimulableRollerIntake {
    private final String name;
    private final RollerIntake intake;
    private final Direction rotationAxis;

    public SimulableRollerIntake(RollerIntake intake, String name, Direction rotationAxis) {
        this.name = name;
        this.intake = intake;
        this.rotationAxis = rotationAxis;
    }

    public Pose3d getPose() {
        return new Pose3d().setRot(rotationAxis, this.intake.getTargetAngle());
    }
}
