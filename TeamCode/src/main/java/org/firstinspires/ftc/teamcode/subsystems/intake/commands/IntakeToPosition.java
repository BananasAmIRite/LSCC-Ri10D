package org.firstinspires.ftc.teamcode.subsystems.intake.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.subsystems.intake.Intake;
import org.firstinspires.ftc.teamcode.util.PolarCoordinate;

public class IntakeToPosition extends CommandBase {
    private final Intake intake;
    private final PolarCoordinate polarCoordinate;

    public IntakeToPosition(Intake intake, double x, double y) {
        this(intake, PolarCoordinate.rectangularToPolar(x, y));
    }

    public IntakeToPosition(Intake intake, PolarCoordinate coords) {
        this.intake = intake;
        this.polarCoordinate = coords;

        addRequirements(intake);
    }

    @Override
    public void initialize() {
        this.intake.toPosition(polarCoordinate);
    }

    @Override
    public boolean isFinished() {
        return this.intake.atPosition();
    }
}
