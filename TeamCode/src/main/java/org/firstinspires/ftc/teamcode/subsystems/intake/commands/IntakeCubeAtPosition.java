package org.firstinspires.ftc.teamcode.subsystems.intake.commands;

import com.arcrobotics.ftclib.command.*;
import org.firstinspires.ftc.teamcode.subsystems.intake.Intake;

public class IntakeCubeAtPosition extends SequentialCommandGroup {
    public IntakeCubeAtPosition(Intake intake, double x, double y) {
        addCommands(
                new IntakeToPosition(intake, x, y),
                new InstantCommand(intake::intake),
                new ParallelRaceGroup(new WaitUntilCommand(intake::intakeHasElement), new WaitCommand(2000)),
                new InstantCommand(intake::stopIntake),
                new IntakeToPosition(intake, 0, 0)
        );
    }
}
