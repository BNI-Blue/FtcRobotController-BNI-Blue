package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Vision;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class DetectOpMode extends OpMode {
    private Detect detect = null;
    @Override
    public void init() {
        detect = new Detect();
        detect.setOp(this);
        detect.initVision(hardwareMap, false);
    }

    @Override
    public void start() {
        detect.start();
    }
    @Override
    public void loop() {
        detect.getResult();
        detect.doTelemetry();
    }
}
