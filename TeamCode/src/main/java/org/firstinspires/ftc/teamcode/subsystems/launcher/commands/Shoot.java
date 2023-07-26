package org.firstinspires.ftc.teamcode.subsystems.launcher.commands;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.subsystems.launcher.Launcher;

public class Shoot extends InstantCommand {
    public Shoot(Launcher launcher) {
        super(launcher::shoot);
    }
}
