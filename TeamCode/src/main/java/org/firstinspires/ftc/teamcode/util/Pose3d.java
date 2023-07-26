package org.firstinspires.ftc.teamcode.util;

public class Pose3d {
    private double x;
    private double y;
    private double z;
    private double xRot;
    private double yRot;
    private double zRot;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getPos(Direction direction) {
        switch (direction) {
            case X:
            default:
                return this.x;
            case Y:
                return this.y;
            case Z:
                return this.z;
        }
    }

    public Pose3d setPos(Direction direction, double pos) {
        switch (direction) {
            case X:
            default:
                this.x = pos;
                break;
            case Y:
                this.y = pos;
                break;
            case Z:
                this.z = pos;
                break;
        }
        return this;
    }


    public double getXRot() {
        return xRot;
    }

    public void setXRot(double xRot) {
        this.xRot = xRot;
    }

    public double getYRot() {
        return yRot;
    }

    public void setYRot(double yRot) {
        this.yRot = yRot;
    }

    public double getZRot() {
        return zRot;
    }

    public void setZRot(double zRot) {
        this.zRot = zRot;
    }

    public double getRot(Direction direction) {
        switch (direction) {
            case X:
            default:
                return this.xRot;
            case Y:
                return this.yRot;
            case Z:
                return this.zRot;
        }
    }

    public Pose3d setRot(Direction direction, double rot) {
        switch (direction) {
            case X:
            default:
                this.xRot = rot;
                break;
            case Y:
                this.yRot = rot;
                break;
            case Z:
                this.zRot = rot;
                break;
        }
        return this;
    }
}