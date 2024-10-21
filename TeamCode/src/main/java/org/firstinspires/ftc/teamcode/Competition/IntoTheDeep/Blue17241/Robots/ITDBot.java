package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Robots;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Drivetrains.MecanumDrive;

public class ITDBot extends MecanumDrive {

    public HardwareMap hwBot = null;

    public Servo intake = null;

    //Mechanisms Variables

    //Constructor
    public ITDBot(){}

    //Init Method
    public void initRobot(HardwareMap hwMap){
        hwBot = hwMap;

        //Drivetrain Motors HW Mapping
        frontLeftMotor = hwBot.dcMotor.get("front_left_motor)");//Port 0 Control
        frontRightMotor = hwBot.dcMotor.get("front_right_motor");//Port 1 Control
        rearLeftMotor = hwBot.dcMotor.get("rear_left_motor");//Port 2 Control
        rearRightMotor = hwBot.dcMotor.get("rear_right_motor");//Port 3 Control

        frontLeftMotor.setDirection(DcMotor.Direction.FORWARD);
        frontRightMotor.setDirection(DcMotor.Direction.REVERSE);
        rearLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        rearRightMotor.setDirection(DcMotor.Direction.FORWARD);

        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        liftOne = hwBot.dcMotor.get("lift_one");
        liftOne.setDirection(DcMotorSimple.Direction.REVERSE);//Port 0 - Expansion
        liftOne.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        liftRelease = hwBot.servo.get("lift_release");//Port 0 - Expansion
        liftRelease.setDirection(Servo.Direction.FORWARD);

        intake = hwBot.servo.get("intake");//Port 1 - Expansion
        intake.setDirection(Servo.Direction.FORWARD);



        //HW Mapping Ex

        //pixelArm = hwBot.dcMotor.get("pixel_arm");//Port 0 - Expansion
        //pixelArm.setDirection(DcMotor.Direction.FORWARD);
        //pixelArm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //pixelClawLeft = hwBot.servo.get("pixel_claw_left");//Port 0 - Expansion
        //pixelClawLeft.setDirection(Servo.Direction.REVERSE);
    }


    //Lift Methods
    public DcMotor liftOne;

    public Servo liftRelease;


    public void raiseLiftOne(double speed){
        liftOne.setPower(speed);
    }

    public void lowerLiftOne(double speed){
        liftOne.setPower(-speed);
    }

    public void raiseLiftOne(double speed, double rotations){
        double ticks = rotations * TICKS_PER_ROTATION;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while((Math.abs(liftOne.getCurrentPosition())) < ticks && LinearOp.opModeIsActive()){
            raiseLiftOne(speed);
            LinearOp.telemetry.addData("Lift ticks ", liftOne.getCurrentPosition());
        }
    }

    public void lowerLiftOne(double speed, double rotations) {
        double ticks = rotations * TICKS_PER_ROTATION;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while ((Math.abs(liftOne.getCurrentPosition())) < ticks && LinearOp.opModeIsActive()) {
            lowerLiftOne(speed);
            LinearOp.telemetry.addData("Lift ticks ", liftOne.getCurrentPosition());

        }
    }

    //intake methods

    public void extendIntake(){
        intake.setPosition(1);
    }

    public void retractIntake(){
        intake.setPosition(0);
    }



}