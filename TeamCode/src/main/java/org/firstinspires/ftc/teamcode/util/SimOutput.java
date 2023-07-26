package org.firstinspires.ftc.teamcode.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class SimOutput {
    public static final ObjectMapper mapper = new ObjectMapper();
    private final String name;
    private final Pose3d pose;
    public SimOutput(String name, Pose3d pose) {
        this.name = name;
        this.pose = pose;
    }

    public ObjectNode toObjectNode() {
        final ObjectNode position = mapper.createObjectNode()
                .put("x", pose.getX())
                .put("y", pose.getY())
                .put("z", pose.getZ());

        final ObjectNode rotation = mapper.createObjectNode()
                .put("x", pose.getXRot())
                .put("y", pose.getYRot())
                .put("z", pose.getZRot());

        ObjectNode state = mapper.createObjectNode();
        state.put("name", name);
        state.set("position", position);
        state.set("rotation", rotation);

        return state;
    }

    @Override
    public String toString() {
        return "SimOutput{" +
                "name='" + name + '\'' +
                ", pose=" + pose +
                '}';
    }
}
