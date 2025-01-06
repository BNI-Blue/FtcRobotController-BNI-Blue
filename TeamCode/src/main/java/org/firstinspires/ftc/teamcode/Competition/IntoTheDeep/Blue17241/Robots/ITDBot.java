package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Robots;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Drivetrains.MecanumDrive;

public class ITDBot extends MecanumDrive {

    public HardwareMap hwBot = null;

    //Mechanisms Variables

    //Constructor
    public ITDBot(){}



    //Init Method
    public void initRobot(HardwareMap hwMap) {
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

        //Climbing Mechanism
        climbingLift = hwBot.dcMotor.get("climbing_lift");
        climbingLift.setDirection(DcMotorSimple.Direction.REVERSE);//Port 0 - Expansion
        climbingLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        climbingRelease = hwBot.servo.get("climbing_release");//Port 2 - Expansion
        climbingRelease.setDirection(Servo.Direction.FORWARD);

        //Intake and extention
        intakeExtender = hwBot.servo.get("intake_extender");//Port 1 - Expansion
        intakeExtender.setDirection(Servo.Direction.FORWARD);

        //CRServos HW Mapping
        sampleIntakeServo = hwBot.get(CRServo.class, "intake_CRServo");//port 0 - expansion
        sampleIntakeServo.setDirection(CRServo.Direction.FORWARD);
        // sampleIntakeServo.setDirection(DcMotorSimple.Direction.FORWARD);

        //Bucket flip
        bucketFlip = hwBot.servo.get("bucket_flip"); //Port - Expansion
        bucketFlip.setDirection(Servo.Direction.FORWARD);

        //Intake Flip
        intakeHolderFlip = hwBot.servo.get("intake_flip"); //Port _ -Expansion
        intakeHolderFlip. setDirection(Servo.Direction.FORWARD);

        //Bucket Linear Slide Extension
        bucketLinearSlide = hwBot.dcMotor.get("bucket_linear_slide");
        bucketLinearSlide.setDirection(DcMotorSimple.Direction.FORWARD);
        bucketLinearSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        RevHubOrientationOnRobot.LogoFacingDirection logoDirection = RevHubOrientationOnRobot.LogoFacingDirection.UP;
        RevHubOrientationOnRobot.UsbFacingDirection  usbDirection  = RevHubOrientationOnRobot.UsbFacingDirection.FORWARD;
        RevHubOrientationOnRobot orientationOnRobot = new RevHubOrientationOnRobot(logoDirection, usbDirection);

        imu = hwMap.get(IMU.class, "imu");
        // Adjust the orientation parameters to match your robot
        imu.initialize(new IMU.Parameters(orientationOnRobot));

    }


    //intake samples mech
    public void sampleIntake() {
        sampleIntakeServo.setPower(-0.4);
    }

    public void sampleOuttake() {
        sampleIntakeServo.setPower(0.6);
    }
    public void sampleOuttakeAuto() {
        sampleIntakeServo.setPower(-0.4);
    }


    public void intakeStop() {

        sampleIntakeServo.setPower(0);
    }

    public void scoreIntake() {
        intakeHolderFlip.setPosition(.03);
    }
    public void collectIntake(){
        intakeHolderFlip.setPosition(.54);
    }


    public void scoreIntakeManual(){
        intakeHolderFlip.setDirection(Servo.Direction.FORWARD);
        //intakeHolderFlip = Range.clip(intakeExtender, 0, 1);
    }
    public void collectIntakeManual(){
        intakeHolderFlip.setDirection(Servo.Direction.REVERSE);
        //intakeHolderFlip = Range.clip(intakeExtender, 0, 1);
    }

    public void submersibleIntake(){intakeHolderFlip.setPosition(0.5);}//not tested

    public void intakeHolderUpAuto(){
        intakeHolderFlip.setPosition(.22);
    }



    //hanging arm
//    public void climbingLiftUp(double power){
//        climbingLift.setPower(Math.abs(power));
//    }
//    public void climbingLiftDown(double power){climbingLift.setPower(-Math.abs(power));}
//    public void climbingLiftStop(){climbingLift.setPower(0);}
//
//    public void climbing_release(double power){
//        climbingLift.setPower(-Math.abs(power));
//    }



    //extending/retracting arm
    public void extendIntake() {
        intakeExtender.setPosition(0.95);//correct as of 1/6/25
    }
    public void retractIntake() {
        intakeExtender.setPosition(0.6);// correct as of 1/6/25
    }

    public void neutralIntake(){intakeExtender.setPosition(0.7);} //correct as of 1/6/25

    public void extendIntakeManual(){
        intakeExtender.setDirection(Servo.Direction.FORWARD);
        //intakeExtender = Range.clip(intakeExtender, 0, 1);
    }
    public void retractIntakeManual(){
        intakeExtender.setDirection(Servo.Direction.REVERSE);
        //intakeExtender = Range.clip(intakeExtender, 0, 1);
    }




    // bucket mechanism
    public void fillBucket(){
        bucketFlip.setPosition(0.2);
    }
    public void emptyBucket(){
        bucketFlip.setPosition(.9);
    }



    // bucket linear extention
    public void bucketSlideDown(double power) {
        bucketLinearSlide.setPower(Math.abs(power));
    }

    public void bucketSlideUp(double power) {
        bucketLinearSlide.setPower(-Math.abs(power));
    }
    public void bucketSlideStop() {
        bucketLinearSlide.setPower(0);
    }

    public void bucketSlideDown(double speed, double rotations){
        double ticks = rotations * TICKS_PER_ROTATION;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while((Math.abs(frontLeftMotor.getCurrentPosition() ) < ticks && LinearOp.opModeIsActive()) ){
            bucketSlideDown(speed);
        }
    }

    public void SampleIntakeToBucket () {
        intakeStop();
        scoreIntake();
        retractIntake();
//        sampleOuttake();
    }

    public void scoringTransferStart(){
        fillBucket();
        scoreIntake();
        retractIntake();
        sampleOuttake();
        intakeStop();
        neutralIntake();
    }


}
