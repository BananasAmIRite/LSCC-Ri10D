package org.firstinspires.ftc.teamcode.subsystems.launcher.simulation;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.subsystems.launcher.Launcher;
import org.firstinspires.ftc.teamcode.util.Direction;
import org.firstinspires.ftc.teamcode.util.Pose3d;
import org.firstinspires.ftc.teamcode.util.SimOutput;
import org.firstinspires.ftc.teamcode.util.Simulable;

import java.util.Arrays;
import java.util.List;

public class SimulableLauncher extends Launcher implements Simulable {

    private final String pivotName;
    private final Direction pivotRotationDirection;

    public SimulableLauncher(DcMotor launcherAngleMotor, String pivotName, Direction pivotRotationDirection) {
        super(launcherAngleMotor);
        this.pivotName = pivotName;
        this.pivotRotationDirection = pivotRotationDirection;
    }
    @Override
    public List<SimOutput> getOutput() {
        return Arrays.asList(new SimOutput(this.pivotName, new Pose3d().setRot(pivotRotationDirection, Math.toRadians(getAngle()))));
    }
}
