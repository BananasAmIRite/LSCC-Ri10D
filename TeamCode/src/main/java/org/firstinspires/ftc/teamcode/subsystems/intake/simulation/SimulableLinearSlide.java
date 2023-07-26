package org.firstinspires.ftc.teamcode.subsystems.intake.simulation;

import org.firstinspires.ftc.teamcode.util.Direction;
import org.firstinspires.ftc.teamcode.util.Pose3d;

import java.util.HashMap;
import java.util.Map;

public class SimulableLinearSlide {
    private final String[] stageNames;
    private final double stageLength;
    private final Direction direction;
    public SimulableLinearSlide(double stageLength, String[] stageNames, Direction translationDirection) {
        this.stageLength = stageLength;
        this.stageNames = stageNames;
        this.direction = translationDirection;
    }

    public Map<String, Pose3d> getStagePoses(double slidePosition) {
        Map<String, Pose3d> poses = new HashMap<>();

        double translation = (slidePosition - stageLength) / stageNames.length; // translation of each slide

        for (String name : stageNames) {
            Pose3d p = new Pose3d();
            p.setPos(direction, translation);
            poses.put(name, p);
        }
        return poses;
    }
}
