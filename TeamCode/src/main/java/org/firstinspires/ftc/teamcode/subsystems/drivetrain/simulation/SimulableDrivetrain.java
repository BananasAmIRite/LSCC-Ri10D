package org.firstinspires.ftc.teamcode.subsystems.drivetrain.simulation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import org.firstinspires.ftc.teamcode.subsystems.drivetrain.Drivetrain;
import org.firstinspires.ftc.teamcode.util.Pose3d;
import org.firstinspires.ftc.teamcode.util.SimOutput;
import org.firstinspires.ftc.teamcode.util.Simulable;

import java.util.Collections;
import java.util.List;

// will just simulate the chassis; treads are too hard to simulate as they are not fully symmetric
public class SimulableDrivetrain extends Drivetrain implements Simulable {
    private final String name;
    public SimulableDrivetrain(DcMotor leftMotor, DcMotor rightMotor, String name) {
        super(leftMotor, rightMotor);
        this.name = name;
    }

    @Override
    public List<SimOutput> getOutput() {
        return Collections.singletonList(new SimOutput(this.name, new Pose3d()));
    }
}
