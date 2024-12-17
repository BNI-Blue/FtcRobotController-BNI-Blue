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
        sampleIntakeServo.setDirection(DcMotorSimple.Direction.FORWARD);

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
        sampleIntakeServo.setPower(0.6);
    }

    public void sampleOuttake() {
        sampleIntakeServo.setDirection(CRServo.Direction.FORWARD);
        sampleIntakeServo.setPower(-0.2);
    }
    public void sampleOuttakeAuto() {
        sampleIntakeServo.setDirection(CRServo.Direction.FORWARD);
        sampleIntakeServo.setPower(-0.4);
    }


    public void intakeStop() {
        sampleIntakeServo.setPower(0);
    }

    public void intakeHolderUp() {
        intakeHolderFlip.setPosition(.17);
    }
    public void intakeHolderUpAuto(){
        intakeHolderFlip.setPosition(.37);
    }

    public void intakeHolderDown(){
        intakeHolderFlip.setPosition(.941);
    }


    //hanging arm
    public void climbingLiftUp(double power){
        climbingLift.setPower(Math.abs(power));
    }
    public void climbingLiftDown(double power){climbingLift.setPower(-Math.abs(power));}
    public void climbingLiftStop(){climbingLift.setPower(0);}

    public void climbing_release(double power){
        climbingLift.setPower(-Math.abs(power));
    }

    //extending/retracting arm
    public void extendIntake() {
        intakeExtender.setPosition(0.451);
    }
    public void retractIntake() {
        intakeExtender.setPosition(0.983);
    }

    // bucket mechanism
    public void emptyBucket(){
        bucketFlip.setPosition(0.2);
    }
    public void fillBucket(){
        bucketFlip.setPosition(.9);
    }

    // bucket linear extention
    public void bucketSlideUp(double power) {
        bucketLinearSlide.setPower(Math.abs(power));
    }

    public void bucketSlideDown(double power) {
        bucketLinearSlide.setPower(-Math.abs(power));
    }
    public void bucketSlideStop() {
        bucketLinearSlide.setPower(0);
    }

    public void bucketSlideUp(double speed, double rotations){
        double ticks = rotations * TICKS_PER_ROTATION;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while((Math.abs(frontLeftMotor.getCurrentPosition() ) < ticks && LinearOp.opModeIsActive()) ){
            bucketSlideUp(speed);
        }
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
        intakeHolderUp();
        retractIntake();
//        sampleOuttake();
    }

}
