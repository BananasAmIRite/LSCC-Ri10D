package org.firstinspires.ftc.teamcode.util;

public class PolarCoordinate {
    private final double angle;
    private final double scale;

    public PolarCoordinate(double angle, double scale) {
        this.angle = angle;
        this.scale = scale;
    }

    public double getAngle() {
        return angle;
    }

    public double getScale() {
        return scale;
    }

    /**
     * @param x forward component
     * @param y upward component
     *
     * @return the converted polar coordinates
     * */
    public static PolarCoordinate rectangularToPolar(double x, double y) {
        double angle = Math.atan2(y, x);
        double scale = Math.hypot(x, y);

        return new PolarCoordinate(angle, scale);
    }
}
