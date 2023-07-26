package org.firstinspires.ftc.teamcode.subsystems.intake.commands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import org.firstinspires.ftc.teamcode.subsystems.intake.Intake;
import org.firstinspires.ftc.teamcode.subsystems.intake.RollerIntake;

public class OuttakeCube extends SequentialCommandGroup {
    public OuttakeCube(Intake intake, float power) {
        addCommands(new InstantCommand(() -> intake.outtake(power)), new WaitCommand(RollerIntake.INTAKE_TIME_SECONDS), new InstantCommand(intake::stopIntake));
    }

    public OuttakeCube(Intake intake) {
        addCommands(new InstantCommand(intake::outtake), new WaitCommand(RollerIntake.INTAKE_TIME_SECONDS), new InstantCommand(intake::stopIntake));
    }
}
