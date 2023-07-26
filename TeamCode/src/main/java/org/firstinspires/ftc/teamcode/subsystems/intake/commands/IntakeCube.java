package org.firstinspires.ftc.teamcode.subsystems.intake.commands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import org.firstinspires.ftc.teamcode.subsystems.intake.Intake;
import org.firstinspires.ftc.teamcode.subsystems.intake.RollerIntake;

public class IntakeCube extends SequentialCommandGroup {
    public IntakeCube(Intake intake, float power) {
        addCommands(new InstantCommand(() -> intake.intake(power)), new WaitCommand(RollerIntake.INTAKE_TIME_SECONDS), new InstantCommand(intake::stopIntake));
    }

    public IntakeCube(Intake intake) {
        addCommands(new InstantCommand(intake::intake), new WaitCommand(RollerIntake.INTAKE_TIME_SECONDS), new InstantCommand(intake::stopIntake));
    }
}
