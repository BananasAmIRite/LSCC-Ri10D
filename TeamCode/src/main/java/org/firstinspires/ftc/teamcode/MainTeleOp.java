package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="Main Teleop", group="TeleOp")
public class MainTeleOp extends OpMode {
    private CommandRobot robot;

    @Override
    public void init() {
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder()
//                .url("http://meowfacts.herokuapp.com/")
//                .header("Content-Type", "application/json")
//                .build();
//        try (Response response = client.newCall(request).execute()) {
//            System.out.println(response.body().string());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        robot = new CommandRobot(hardwareMap);
    }

    @Override
    public void loop() {
        try {
            robot.run();
        } catch (Exception err) {
            System.out.println(err);
        }
    }

}
