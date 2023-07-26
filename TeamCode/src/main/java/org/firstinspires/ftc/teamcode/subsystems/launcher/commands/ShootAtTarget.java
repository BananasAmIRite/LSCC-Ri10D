package org.firstinspires.ftc.teamcode.subsystems.launcher.commands;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.subsystems.launcher.Launcher;
import org.firstinspires.ftc.teamcode.util.LaunchTrajectoryCalculator;

public class ShootAtTarget extends SequentialCommandGroup {
    public ShootAtTarget(Launcher launcher, double xInches, double yInches) {
        final double angleDegrees = Math.toDegrees(LaunchTrajectoryCalculator.calculateLaunchTrajectory(
                xInches, yInches,
                Launcher.LAUNCH_SPEED_INCHES_PER_SECOND,
                true
        ));

        addCommands(
                new LauncherToAngle(launcher, angleDegrees),
                new Shoot(launcher)
        );

    }
}
