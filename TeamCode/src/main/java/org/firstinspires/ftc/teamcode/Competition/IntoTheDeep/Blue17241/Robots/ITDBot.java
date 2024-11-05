package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Robots;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Drivetrains.MecanumDrive;

public class ITDBot extends MecanumDrive {

    public HardwareMap hwBot = null;

    //Mechanisms Variables

    //Constructor
    public ITDBot(){}

    //Init Method
    public void initRobot(HardwareMap hwMap){
        hwBot = hwMap;

        //Drivetrain Motors HW Mapping
        frontLeftMotor = hwBot.dcMotor.get("front_left_motor");//Port 0 Control
        frontRightMotor = hwBot.dcMotor.get("front_right_motor");//Port 1 Control
        rearLeftMotor = hwBot.dcMotor.get("rear_left_motor");//Port 2 Control
        rearRightMotor = hwBot.dcMotor.get("rear_right_motor");//Port 3 Control

        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        frontRightMotor.setDirection(DcMotor.Direction.FORWARD);
        rearLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        rearRightMotor.setDirection(DcMotor.Direction.FORWARD);

        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

//        fourBar = hwBot.dcMotor.get("four_bar"); //Port 0 - Expansion
//        fourBar.setDirection(DcMotorSimple.Direction.FORWARD);
//        fourBar.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        //chamber lift
        liftOne = hwBot.dcMotor.get("lift_one");
        liftOne.setDirection(DcMotorSimple.Direction.REVERSE);//Port _ - Expansion
        liftOne.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        liftRelease = hwBot.servo.get("lift_release");//Port _ - Expansion
        liftRelease.setDirection(Servo.Direction.FORWARD);

        //claw extension
        extender = hwBot.servo.get("extender");//Port 1 - Expansion
        extender.setDirection(Servo.Direction.FORWARD);

        //CRServos HW Mapping
        sampleIntakeServo = hwBot.get(CRServo.class, "intake_CRServo");//port 0 - expansion
        sampleIntakeServo.setDirection(DcMotorSimple.Direction.FORWARD);

        //bucket flip
        bucketFlip = hwBot.servo.get("bucket_flip");//Port _ - Expansion
        bucketFlip.setDirection(Servo.Direction.FORWARD);

        //intake flip
        intakeHolderFlip = hwBot.servo.get("intake_flip");//Port _ - Expansion
        intakeHolderFlip.setDirection(Servo.Direction.FORWARD);

        //HW Mapping Ex

        //pixelArm = hwBot.dcMotor.get("pixel_arm");//Port 0 - Expansion
        //pixelArm.setDirection(DcMotor.Direction.FORWARD);
        //pixelArm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //pixelClawLeft = hwBot.servo.get("pixel_claw_left");//Port 0 - Expansion
        //pixelClawLeft.setDirection(Servo.Direction.REVERSE);
    }


    //intake samples mech
    public void sampleIntake() {
        sampleIntakeServo.setDirection(CRServo.Direction.FORWARD);
        sampleIntakeServo.setPower(1);

    }

    public void sampleOuttake() {
        sampleIntakeServo.setDirection(CRServo.Direction.FORWARD);
        sampleIntakeServo.setPower(-1);
    }

    public void intakeStop() {
        sampleIntakeServo.setPower(0);
    }

    public void intakeHolderUp(){
        intakeHolderFlip.setPosition(1);
    }

    public void intakeHolderDown(){
        intakeHolderFlip.setPosition(.5);
    }

    //bucket mech
    public void emptyBucket(){
        bucketFlip.setPosition(1);
    }
    public void fillBucket(){
        bucketFlip.setPosition(.5);
    }


    //hanging arm
    public void raiseLiftOne(double power){
        liftOne.setPower(Math.abs(power));
    }

    public void lowerLiftOne(double power){
        liftOne.setPower(-Math.abs(power));
    }


    //extending/retracting arm
    public void extendIntake() {
        extender.setPosition(0.451);
    }

    public void retractIntake() {
        extender.setPosition(0.983);
    }



//    public void raiseArm(){
//        fourBar.setPower(1);
//    }
//    public void raiseArm(double speed, double rotations){
//        double ticks = rotations * TICKS_PER_ROTATION;
//        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//
//        while((Math.abs(frontLeftMotor.getCurrentPosition() ) < ticks && LinearOp.opModeIsActive()) ){
//            raiseArm();
//        }
//    }


}
