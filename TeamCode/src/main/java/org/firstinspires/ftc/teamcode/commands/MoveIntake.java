package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.subsystems.intake.Intake;

public class MoveIntake extends SequentialCommandGroup {
    public MoveIntake(Intake intake) {
        addCommands(new InstantCommand(intake::stow));
    }
}
