package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.CommandRobot;

public class TeleOp extends LinearOpMode {
    @Override
    public void runOpMode() {
        CommandRobot robot = new CommandRobot(hardwareMap);

        while(opModeIsActive() && !isStopRequested()) {
            robot.run();
        }
        robot.reset();
    }
}