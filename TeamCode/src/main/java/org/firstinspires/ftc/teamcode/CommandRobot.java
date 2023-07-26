package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.RunCommand;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorImpl;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoImpl;

import org.firstinspires.ftc.teamcode.subsystems.drivetrain.simulation.SimulableDrivetrain;
import org.firstinspires.ftc.teamcode.subsystems.intake.Positioner;
import org.firstinspires.ftc.teamcode.subsystems.intake.RollerIntake;
import org.firstinspires.ftc.teamcode.subsystems.intake.simulation.SimulableIntake;
import org.firstinspires.ftc.teamcode.subsystems.launcher.simulation.SimulableLauncher;
import org.firstinspires.ftc.teamcode.util.Direction;

public class CommandRobot extends SimulableRobot {

    private SimulableDrivetrain drivetrain;
    private SimulableIntake intake;
    private SimulableLauncher launcher;

    private HardwareMap hwMap;

    public CommandRobot(HardwareMap hwMap) {
        super("http://10.0.2.2:1000/postdata");
        this.hwMap = hwMap;
        init();
        setDefaultCommands();
    }

    public void init() {
        try {
            DcMotorImpl dLeftMotor = (DcMotorImpl) hwMap.dcMotor.get("drivetrainLeftMotor");
            DcMotorImpl dRightMotor =(DcMotorImpl)  hwMap.dcMotor.get("drivetrainLeftMotor");

            DcMotorImpl intakeMotor = (DcMotorImpl) hwMap.dcMotor.get("intakeMotor");
            DcMotorImpl slidePivotMotor = (DcMotorImpl) hwMap.dcMotor.get("slidePivotMotor");
            DcMotorImpl slideMotor = (DcMotorImpl) hwMap.dcMotor.get("slideMotor");
            DcMotorImpl launcherPivotMotor = (DcMotorImpl) hwMap.dcMotor.get("launcherPivotMotor");
            this.drivetrain = new SimulableDrivetrain(
                    dLeftMotor,
                    dRightMotor,
                    "drivetrain");

            this.intake = new SimulableIntake(
                    new RollerIntake(new ServoImpl() // hwMap.servo.get("intakePositioner")
                            , intakeMotor),
                    new Positioner(slidePivotMotor, slideMotor),
                    new String[]{"ls1", "ls2", "ls3", "ls4"}, Direction.Z,
                    "lsPivot", Direction.X,
                    "intake", Direction.X
            );

            this.launcher = new SimulableLauncher(
                    launcherPivotMotor,
                    "launcherPivot", Direction.X
            );

            registerSimulable(intake);
            registerSimulable(drivetrain);
            registerSimulable(launcher);

            registerMotor(dLeftMotor, dRightMotor, intakeMotor, slidePivotMotor, slideMotor, launcherPivotMotor);


        } catch (Exception err) {
            System.out.println(err);
        }
    }

    public void setDefaultCommands() {
        intake.setDefaultCommand(new RunCommand(intake::stow, intake));
    }
}