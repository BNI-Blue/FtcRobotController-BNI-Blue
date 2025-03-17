package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.pedroPathing.Paths;

import com.pedropathing.follower.Follower;
import com.pedropathing.localization.HeadingTypes;
import com.pedropathing.localization.Pose;
import com.pedropathing.pathgen.PathChain;
import com.pedropathing.pathgen.easy.EasySafePath;
import com.pedropathing.util.Constants;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.pedroPathing.FConstants;
import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.pedroPathing.LConstants;


@Autonomous(name = "Basic Curve")
public class BasicCurve extends OpMode {

    Follower follower;

    Pose startPose, middlePose, endPose;

    public PathStates pathState = PathStates.READY;

    @Override
    public void init() {
        Constants.setConstants(FConstants.class, LConstants.class);
        follower = new Follower(hardwareMap);
//        Pose.setAngleUnit(AngleUnit.DEGREES);
//        Pose.angleUnit = AngleUnit.DEGREES;
        startPose = new Pose(0,0, 0);
        middlePose = new Pose(25, 25, Math.toRadians(45));
        endPose = new Pose(50, 50, Math.toRadians(90));
        follower.setStartingPose(startPose);
        buildPaths();
    }

    @Override
    public void loop(){
        pathStateControl();
        follower.update();
        telemetry.addData("State: ", pathState);
        telemetry.addData("Pose: ", follower.getPose().toString());
        telemetry.update();
    }

    public void start(){
        pathState = PathStates.START;
    }

    PathChain curve;

    public void buildPaths(){
        curve = follower.pathBuilder().addPath(new EasySafePath(startPose, middlePose, endPose).setHeading(HeadingTypes.LINEAR, startPose, endPose)).build();
    }

    public enum PathStates{
        START,
        MIDDLE,
        END,
        READY;
    }
    public void pathStateControl(){
        switch(pathState){
            case START:
                follower.followPath(curve, true);
                pathState = PathStates.READY;
                break;
//            case MIDDLE:
//                if(!follower.isBusy()){
//                }
//                break;
            case READY:
                break;
        }

    }
}
