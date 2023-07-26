package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.Robot;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorImpl;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import org.firstinspires.ftc.teamcode.util.SimOutput;
import org.firstinspires.ftc.teamcode.util.Simulable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class SimulableRobot extends Robot {

    private OkHttpClient client = new OkHttpClient();

    private long lastTimeMillis = -1;

    private final String simOutputURL;
    private final List<Simulable> simulables = new ArrayList<>();
    private final List<DcMotorImpl> motors = new ArrayList<>();

    private boolean isInit = false;

    public SimulableRobot(String simOutputURL) {
        this.simOutputURL = simOutputURL;
    }


    public void registerSimulable(Simulable simulable) {
        this.simulables.add(simulable);
    }

    public void registerMotor(DcMotorImpl... mtr) {
        motors.addAll(Arrays.asList(mtr));
    }

    public void updateSim() {
        if (!isInit) {
            isInit = true;
            lastTimeMillis = System.currentTimeMillis();
        }

        updateMotors();

            final ObjectMapper mapper = new ObjectMapper();

            ObjectNode body = mapper.createObjectNode();

            ArrayNode data = body.putArray("data");
            try {
                for (Simulable sim : simulables) {
                    for (SimOutput output : sim.getOutput()) {
                        data.add(output.toObjectNode());
                    }
                }
            } catch (Exception err) {
                System.out.println(err);
            }


//            Unirest.post(simOutputURL)
//                    .header("Content-Type", "application/json")
//                    .body(body.toPrettyString());
        Request request = new Request.Builder()
                .url(simOutputURL)
                .post(RequestBody.create(body.toPrettyString(), MediaType.get("application/json")))
                .build();
        try (Response response = client.newCall(request).execute()) {
//            System.out.println(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateMotors() {
        for (DcMotorImpl motor : motors) {
            motor.update(System.currentTimeMillis() - lastTimeMillis);
        }
        lastTimeMillis = System.currentTimeMillis();
    }

    @Override
    public void run() {
        super.run();
        updateSim();
    }
}
