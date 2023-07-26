package org.firstinspires.ftc.teamcode.util;

public class LaunchTrajectoryCalculator {

    public static final double g = 386.08858; // - inches/s^2;  9.8; - meters/s^2

    /**
     * @param x the distance of the target in front
     * @param y the vertical distance of the target
     * @param launchSpeed the launch speed
     * @param useHigh use the mode that launches the projectile high up before hitting target
     *
     * @return the angle in radians to launch the projectile
     *
     * */
    public static Double calculateLaunchTrajectory(double x, double y, double launchSpeed, boolean useHigh) {
        // simulation of trajectory: https://www.desmos.com/calculator/ndqdv8yxyq
        return Math.atan((launchSpeed * launchSpeed + (useHigh ? 1 : -1) *  Math.sqrt(Math.pow(launchSpeed, 4) - 2 * g * y * launchSpeed * launchSpeed - g * g * x * x))/(g * x));
    }
}
