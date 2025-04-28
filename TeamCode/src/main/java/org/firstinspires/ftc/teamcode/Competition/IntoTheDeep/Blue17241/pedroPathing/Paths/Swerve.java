package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.pedroPathing.Paths;

import com.pedropathing.follower.Follower;
import com.pedropathing.localization.HeadingTypes;
import com.pedropathing.localization.Pose;
import com.pedropathing.pathgen.Path;
import com.pedropathing.pathgen.PathChain;
import com.pedropathing.pathgen.easy.EasySafePath;
import com.pedropathing.util.Constants;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.pedroPathing.FConstants;
import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.pedroPathing.LConstants;

@Autonomous(name = "swerve")
public class Swerve extends OpMode {

    Follower follower;

    Pose start, sr, red, ro, orange, oy, yellow, yg, green, gb, blue, bp, purple;

    public SwerveStates swerveState = SwerveStates.READY;

    public LinearOpMode LinearOp = null;
    public void setLinearOp(LinearOpMode LinearOp) {this.LinearOp = LinearOp;}
    public Servo mechanism;

    @Override
    public void init(){
        mechanism = hardwareMap.servo.get("mechanism");
        mechanism.setDirection(Servo.Direction.FORWARD);

        Constants.setConstants(FConstants.class, LConstants.class);
        follower = new Follower(hardwareMap);

        start = new Pose(24, 137, Math.toRadians(-90));
        sr = new Pose(0, 140, Math.toRadians(-90));
        red = new Pose(8, 87,  Math.toRadians(-90));
        ro = new Pose(46, 60,  Math.toRadians(-90));
        orange = new Pose(36, 56,  Math.toRadians(-90));
        oy = new Pose(48, 8, (Math.toRadians(-45)));
        yellow = new Pose(72, 12, Math.toRadians(0));
        yg = new Pose(96, 24, Math.toRadians(45));
        green = new Pose(108, 63, Math.toRadians(90));
        gb = new Pose(140, 80, Math.toRadians(90));
        blue = new Pose(132, 96, Math.toRadians(90));
        bp = new Pose(132, 130, Math.toRadians(90) );
        purple = new Pose(82, 120, Math.toRadians(90));

        follower.setStartingPose(start);

        buildPaths();
    }

    @Override
    public void loop(){
        swerveStateControl();
        hit();
        og();
        follower.update();
        telemetry.addData("Pose: ", follower.getPose().toString());
        telemetry.addData("Servo Pos: ", mechanism.getPosition());
        telemetry.update();
    }

    @Override
    public void start(){
        setSwerveState(SwerveStates.RED);
    }

    public void hit(){
        mechanism.setPosition(.5);
    }

    public void og(){
        mechanism.setPosition(0);
    }

    PathChain redPath, orangePath, yellowPath, greenPath, bluePath, purplePath;

    public void buildPaths(){
        redPath = follower.pathBuilder().addPath(new EasySafePath(start, red).setHeading(HeadingTypes.LINEAR, start, red)).build();
        orangePath = follower.pathBuilder().addPath(new EasySafePath(red, ro, orange).setHeading(HeadingTypes.LINEAR,red, orange)).build();
        yellowPath = follower.pathBuilder().addPath(new EasySafePath(orange, oy, yellow).setHeading(HeadingTypes.LINEAR, orange, yellow)).build();
        greenPath = follower.pathBuilder().addPath(new EasySafePath(yellow, yg, green).setHeading(HeadingTypes.LINEAR, yellow, green)).build();
        bluePath = follower.pathBuilder().addPath(new EasySafePath(green, gb, blue).setHeading(HeadingTypes.LINEAR, green, blue)).build();
        purplePath = follower.pathBuilder().addPath(new EasySafePath(blue, bp, purple).setHeading(HeadingTypes.LINEAR, blue, purple)).build();
    }

    public enum SwerveStates{
        RED,
        ORANGE,
        YELLOW,
        GREEN,
        BLUE,
        PURPLE,
        READY;
    }

    public void swerveStateControl(){
        switch(swerveState){
            case RED:
                follower.followPath(redPath);
                setSwerveState(SwerveStates.ORANGE);
                break;
            case ORANGE:
                if(!follower.isBusy()){
                    follower.followPath(orangePath);
                    setSwerveState(SwerveStates.YELLOW);
                }
                break;
            case YELLOW:
                if(!follower.isBusy()){
                    follower.followPath(yellowPath);
                    setSwerveState(SwerveStates.GREEN);
                }
                break;
            case GREEN:
                if(!follower.isBusy()){
                    follower.followPath(greenPath);
                    setSwerveState(SwerveStates.BLUE);
                }
                break;
            case BLUE:
                if(!follower.isBusy()){
                    follower.followPath(bluePath);
                    setSwerveState(SwerveStates.PURPLE);
                }
                break;
            case PURPLE:
                if(!follower.isBusy()){
                    follower.followPath(purplePath, true);
                    hit();
                    setSwerveState(SwerveStates.READY);
                }
                break;
            case READY:
                if(!follower.isBusy()){
                    break;
                }
        }
    }

    public void setSwerveState(SwerveStates state){
        if(swerveState != state){
            swerveState = state;
            swerveStateControl();
        }
    }
}
