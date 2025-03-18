package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.pedroPathing.Paths;

import com.pedropathing.follower.Follower;
import com.pedropathing.localization.HeadingTypes;
import com.pedropathing.localization.Pose;
import com.pedropathing.pathgen.PathChain;
import com.pedropathing.pathgen.easy.EasySafePath;
import com.pedropathing.util.Constants;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.pedroPathing.FConstants;
import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.pedroPathing.LConstants;

@Autonomous(name = "Lap Around Field")
public class LapAroundField extends OpMode {

    Follower follower;

    Pose wallOne, wallTwo, wallThree, wallFour, cornerOneTwo, cornerTwoThree, cornerThreeFour, cornerFourOne;

    public CircleStates circleStates = CircleStates.READY;


    @Override
    public void init(){
        Constants.setConstants(FConstants.class, LConstants.class);
        follower = new Follower(hardwareMap);

        wallOne = new Pose(72, 137.5, 0);
        wallTwo = new Pose(6.5, 72, Math.toRadians(-90));
        wallThree = new Pose(72, 6.5, Math.toRadians(-180));
        wallFour = new Pose(137.5, 72, Math.toRadians(-270));

        cornerOneTwo = new Pose(0, 144, Math.toRadians(-45));
        cornerTwoThree = new Pose(0,0, Math.toRadians(-135));
        cornerThreeFour = new Pose(144,0, Math.toRadians(-225));
        cornerFourOne = new Pose(144, 144, Math.toRadians(-315));

        follower.setStartingPose(wallOne);

        buildPaths();
        telemetry();

    }

    @Override
    public void loop(){
        circleStateControl();
        follower.update();
        telemetry.addData("Pose: ", follower.getPose().toString());
        telemetry.update();
    }

    public void start(){
        circleStates = CircleStates.ONETWO;

    }

    PathChain  one, two, three, four;

    public void buildPaths(){
        one = follower.pathBuilder().addPath(new EasySafePath(wallOne, cornerOneTwo, wallTwo).setHeading(HeadingTypes.LINEAR, wallOne, wallTwo)).build();
        two = follower.pathBuilder().addPath(new EasySafePath(wallTwo, cornerTwoThree, wallThree).setHeading(HeadingTypes.LINEAR, wallTwo, wallThree)).build();
        three = follower.pathBuilder().addPath(new EasySafePath(wallThree, cornerThreeFour, wallFour).setHeading(HeadingTypes.LINEAR, wallThree, wallFour)).build();
        four = follower.pathBuilder().addPath(new EasySafePath(wallFour, cornerFourOne, wallOne).setHeading(HeadingTypes.LINEAR, wallFour, wallOne)).build();
    }

    public enum CircleStates{
        ONETWO,
        TWOTHREE,
        THREEFOUR,
        FOURONE,
        READY;
    }
    public void circleStateControl(){
        switch (circleStates){
            case ONETWO:
                follower.followPath(one);
                circleStates = CircleStates.TWOTHREE;
                break;
            case TWOTHREE:
                if(!follower.isBusy()){
                    follower.followPath(two);
                    circleStates = CircleStates.THREEFOUR;
                }
                break;
            case THREEFOUR:
                if(!follower.isBusy()){
                    follower.followPath(three);
                    circleStates = CircleStates.FOURONE;}
                break;
            case FOURONE:
                if(!follower.isBusy()){
                    follower.followPath(four, true);
                    circleStates = CircleStates.READY;}
                break;
            case READY:
                break;
        }
    }

    public void telemetry(){
        telemetry.addData("State: ", circleStates);
        telemetry.update();
    }
}
