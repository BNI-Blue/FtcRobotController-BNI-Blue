package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Vision;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Odometry.Pinpoint;

public class Detect {

    public HardwareMap hwBot = null;
    public Limelight3A camera = null;
    public Pinpoint pinpoint = null;
    public Telemetry telemetry = null;

    public boolean captureSnapshots = true;
    public int snapshotLimit = 0;
    public String snapshotPrefix = "pov_";

    public LLResult result = null;
    public Position Position = new Position();

    //Constructor
    public Detect() {
    }

    public void setLinearOp(LinearOpMode LinearOp) {
        telemetry = LinearOp.telemetry;
    }

    public void setOp(OpMode Op) {
        telemetry = Op.telemetry;
    }

    // v is with intent for captureSnapshots to be true
    public void initVision(HardwareMap hwMap, Pinpoint pinpoint, boolean CaptureSnapshots, int snapshotLimit, String snapshotPrefix){
        hwBot = hwMap;
        this.pinpoint = pinpoint;
        this.captureSnapshots = CaptureSnapshots;
        this.snapshotLimit = snapshotLimit;
        this.snapshotPrefix = snapshotPrefix;

        camera = hwBot.get(Limelight3A.class, "limelight");
        camera.setPollRateHz(100);
    }

    //v is with intent for captureSnapshots to be false
    public void initVision(HardwareMap hwMap, boolean CaptureSnapshots){
        hwBot = hwMap;
        this.pinpoint = null;
        this.captureSnapshots = false;
        this.snapshotLimit = 0;
        this.snapshotPrefix = "";

        camera = hwBot.get(Limelight3A.class, "limelight");
        camera.setPollRateHz(100);
    }

    public void start(){
        camera.start();
        camera.pipelineSwitch(3);
        telemetry.addLine("Vision Started");
        telemetry.update();
    }

    public void getResult() {
        result = camera.getLatestResult();
    }

    public boolean lastResultValid() {
        return result != null && result.isValid();
    }

    public class Position{
        public void updateYaw(){
            camera.updateRobotOrientation(pinpoint.getPosition().getHeading(AngleUnit.DEGREES));
        }
    }

    public void doTelemetry(){
        telemetry.addData("Tx: ", result.getTx());
        telemetry.addData("Ta:", result.getTa());
        telemetry.addData("Ty:", result.getTy());
        telemetry.addData("Fiducial Results", result.getFiducialResults());
        telemetry.update();
    }




}
