package org.firstinspires.ftc.teamcode.subsystems.launcher.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.launcher.Launcher;

public class LauncherToAngle extends CommandBase {
    private final Launcher launcher;
    private final double angleDegrees;
    public LauncherToAngle(Launcher launcher, double angleDegrees) {
        this.launcher = launcher;
        this.angleDegrees = angleDegrees;
        addRequirements(launcher);
    }

    @Override
    public void initialize() {
        this.launcher.motorToAngle(angleDegrees);
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean isFinished() {
        return launcher.motorAtAngle();
    }
}
