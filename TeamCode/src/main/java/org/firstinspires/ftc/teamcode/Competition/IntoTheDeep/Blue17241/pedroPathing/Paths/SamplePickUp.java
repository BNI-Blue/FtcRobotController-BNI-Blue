package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.pedroPathing.Paths;


import static android.Manifest.permission.DUMP;

import com.pedropathing.follower.Follower;
import com.pedropathing.localization.HeadingTypes;
import com.pedropathing.localization.Pose;
import com.pedropathing.pathgen.PathChain;
import com.pedropathing.pathgen.easy.EasySafePath;
import com.pedropathing.util.Constants;
import com.pedropathing.util.Timer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Robots.ProgrammerBot;
import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.pedroPathing.FConstants;
import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.pedroPathing.LConstants;

@Disabled
@Autonomous (name = "Sample Pick Up")
public class SamplePickUp extends OpMode {
    Follower follower;

    Pose start, specimenHang, sampleOneLineUp, sampleTwoLineUp, obZone, beforeObsZone, obsToStart;

    public SampleStates sampleState = SampleStates.READY;

    public Timer pathTimer;

    public ProgrammerBot programBot = new ProgrammerBot();

    public LinearOpMode LinearOp = null;
    public void setLinearOp(LinearOpMode LinearOp) {this.LinearOp = LinearOp;}
    public Servo mechanism;


    @Override
    public void init(){

        mechanism = hardwareMap.servo.get("mechanism");
        mechanism.setDirection(Servo.Direction.FORWARD);

        Constants.setConstants(FConstants.class, LConstants.class);
        follower = new Follower(hardwareMap);

        pathTimer = new Timer();

        start = new Pose(72, 134, Math.toRadians(180));
        specimenHang = new Pose(72, 106, Math.toRadians(-90));
        sampleOneLineUp = new Pose(36, 115, Math.toRadians(-45));
        sampleTwoLineUp = new Pose(24, 84, Math.toRadians(90));
        obZone = new Pose(24, 126, Math.toRadians(90));
        beforeObsZone = new Pose(24, 120, Math.toRadians(90));

        follower.setStartingPose(start);

        follower.setMaxPower(1);

        buildPaths();
        mechanismMoveOne();
        mechanismMoveTwo();
    }

    @Override
    public void loop(){
        sampleStateControl();
        follower.update();
        telemetry.addData("Pose: ", follower.getPose().toString());
        telemetry.addData("Servo Pos: ", mechanism.getPosition());
        telemetry.update();
    }

    @Override
    public void start(){
        setSampleState(SampleStates.HANG);
    }

    public void mechanismMoveOne(){
        mechanism.setPosition(.5);
    }

    public void mechanismMoveTwo(){
        mechanism.setPosition(0);
    }

    PathChain hangSpecimen, lineUp, obsZone, toStart;

    public void buildPaths(){
        hangSpecimen = follower.pathBuilder().addPath(new EasySafePath(start, specimenHang).setHeading(HeadingTypes.LINEAR, start, specimenHang)).build();
        lineUp = follower.pathBuilder().addPath(new EasySafePath(specimenHang, sampleOneLineUp, sampleTwoLineUp).setHeading(HeadingTypes.LINEAR, specimenHang, sampleTwoLineUp)).build();
        obsZone = follower.pathBuilder().addPath(new EasySafePath(sampleTwoLineUp, obZone).setHeading(HeadingTypes.LINEAR, sampleTwoLineUp, obZone)).build();
        toStart = follower.pathBuilder().addPath(new EasySafePath(obZone, beforeObsZone, start).setHeading(HeadingTypes.LINEAR, obZone, start)).build();
    }

    public enum SampleStates{
        HANG,
        HANGWAIT,
        LINEUP,
        MECHANISMONE,
        DUMP,
        DUMPWAIT,
        TOSTART,
        MECHANISMTWO,
        READY;
    }

    public void sampleStateControl(){
        switch(sampleState){
            case HANG:
                follower.followPath(hangSpecimen);
                setSampleState(SampleStates.HANGWAIT);
                break;
            case HANGWAIT:
                if(canProgress(3000)){
                    setSampleState(SampleStates.LINEUP);
                }
                break;
            case LINEUP:
                if(!follower.isBusy()) {
                    follower.followPath(lineUp);
                    setSampleState(SampleStates.MECHANISMONE);
                }
                break;
            case MECHANISMONE:
                if(!follower.isBusy()) {
                    mechanismMoveOne();
                    setSampleState(SampleStates.DUMP);
                }
                break;
            case DUMP:
                if(!follower.isBusy()) {
                    follower.followPath(obsZone);
                    setSampleState(SampleStates.DUMPWAIT);
                }
                break;
            case DUMPWAIT:
                if(canProgress(3000)){
                    setSampleState(SampleStates.TOSTART);
                }
                break;
            case TOSTART:
                if(!follower.isBusy()) {
                    follower.followPath(toStart, true);
                    setSampleState(SampleStates.MECHANISMTWO);
                }
                break;
            case MECHANISMTWO:
                if(!follower.isBusy()) {
                    mechanismMoveTwo();
                    setSampleState(SampleStates.READY);
                }
                break;
            case READY:
                if(!follower.isBusy()) {
                    break;
                }

        }
    }

    public void setSampleState(SampleStates state){
        if(sampleState != state){
            sampleState = state;
            pathTimer.resetTimer();
            sampleStateControl();
        }
    }

    public boolean canProgress(int tVal) {
        return !follower.isBusy() && pathTimer.getElapsedTime() > tVal;
    }
}
