package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Robots;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Drivetrains.MecanumDrive;

public class ITDBot extends MecanumDrive {

    public HardwareMap hwBot = null;

    //Mechanisms Variables have all been moved to Mecanum Drive Class

    //Constructor
    public ITDBot(){}

    public double servoPos = 0.6;

    public double incVal = 0.005;


    String intakeState = null;

    private boolean moving = false;  // State variable to track if servo is moving


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

        //Intake Linear Slide Extension
        intakeExtender = hwBot.servo.get("intake_extender");//Port 1 - Expansion
        intakeExtender.setDirection(Servo.Direction.FORWARD);

        //Intake FlyWheels
        sampleIntakeServo = hwBot.get(CRServo.class, "intake_CRServo");//port 0 - expansion
        sampleIntakeServo.setDirection(CRServo.Direction.FORWARD);
        // sampleIntakeServo.setDirection(DcMotorSimple.Direction.FORWARD);

        //Intake Flip Mechanism
        intakeHolderFlip = hwBot.servo.get("intake_flip"); //Port _ -Expansion
        intakeHolderFlip. setDirection(Servo.Direction.FORWARD);

        //Bucket Flip Mechanism
        bucketFlip = hwBot.servo.get("bucket_flip"); //Port - Expansion
        bucketFlip.setDirection(Servo.Direction.FORWARD);

        //Bucket Linear Slide Extension
        bucketLinearSlide = hwBot.dcMotor.get("bucket_linear_slide");
        bucketLinearSlide.setDirection(DcMotorSimple.Direction.FORWARD);
        bucketLinearSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //IMU for Rev Robotics Control Hub
        RevHubOrientationOnRobot.LogoFacingDirection logoDirection = RevHubOrientationOnRobot.LogoFacingDirection.UP;
        RevHubOrientationOnRobot.UsbFacingDirection  usbDirection  = RevHubOrientationOnRobot.UsbFacingDirection.BACKWARD;
        RevHubOrientationOnRobot orientationOnRobot = new RevHubOrientationOnRobot(logoDirection, usbDirection);

        imu = hwMap.get(IMU.class, "imu");
        // Adjust the orientation parameters to match your robot
        imu.initialize(new IMU.Parameters(orientationOnRobot));

    }


    // *******  Helper Methods for Intake FlyWheels *********
    public void sampleIntakeAuto() {
        sampleIntakeServo.setPower(-0.75);           //correct as of 1/6/25
    }

    public void sampleIntake(){
        sampleIntakeServo.setPower(-0.4);
    }



    public void sampleOuttake() {
        sampleIntakeServo.setPower(0.75);            //correct as of 1/6/25
    }

    public void intakeStop() {
        sampleIntakeServo.setPower(0);
    }

    public void sampleOuttakeAuto() {
        sampleIntakeServo.setPower(-0.4);
    }


    // *******  Helper Methods for Intake Flip Mechanism *******
    public void scoreIntake() {
        intakeHolderFlip.setPosition(.05);   //.1       //correct as of 1/6/25
        intakeState = "score";
    }

    public void scoreIntakeSlow() {
        intakeHolderFlip.setPosition(.1);          //correct as of 1/6/25
        intakeState = "score";
    }

    public void collectIntake(){
        intakeHolderFlip.setPosition(.595);   //.54       //correct as of 1/6/25
        intakeState = "collect";
    }

    public void collectIntakeSlow(){
        if (intakeState.equals("score")) {
            moving = true;
            slowServo(.54);          //correct as of 1/6/25
        }
        else {
            intakeHolderFlip.setPosition(.54);          //correct as of 1/6/25
        }

        intakeState = "collect";
    }

    public void submersibleIntake(){
        intakeHolderFlip.setPosition(0.555);
        intakeState = "submersible";
    }         //0.59 correct as of 1/8/25


    public void intakeHolderUpAuto(){               //not tested
        intakeHolderFlip.setPosition(.22);
        intakeState = "auto";
    }


    public void slowServo(double targetPosition){
        double currentPosition = intakeHolderFlip.getPosition();
        if (moving) {
            // Gradually move the servo to the target position in small increments
            if (Math.abs(currentPosition - targetPosition) > incVal) {
                if (currentPosition < targetPosition) {
                    currentPosition += incVal;
                } else {
                    currentPosition -= incVal;
                }
                intakeHolderFlip.setPosition(currentPosition);  // Set the servo's position
            } else {
                // Once we're close to the target, stop     and set the servo position exactly
                currentPosition = targetPosition;
                intakeHolderFlip.setPosition(currentPosition);
                moving = false;  // Stop the movement
            }
        }

        // For example, you can trigger the servo movement when the 'A' button is pressed
//        if (gamepad2.y) {
//            // Start the movement towards the target position
//            moving = true;
//        }

        // You can use telemetry to visualize the current servo position
//        linetelemetry.addData("Servo Position", currentPosition);
//        telemetry.addData("Moving", moving ? "Yes" : "No");
//        telemetry.update();
    }



    // *******  Helper Methods for Intake Extension *******
    public void extendIntake() {
        intakeExtender.setPosition(0.95);       //correct as of 1/6/25
    }
    public void retractIntake() {
        intakeExtender.setPosition(0.5);        // correct as of 1/6/25
    }

    public void neutralIntake(){
        intakeExtender.setPosition(0.7);}       //correct as of 1/6/25

    public void extendIntakeManual(){
        servoPos += incVal;
        servoPos = Range.clip(servoPos, 0.6,  0.95);
        intakeExtender.setPosition(servoPos);
    }
    public void retractIntakeManual(){
        servoPos -= incVal;
        servoPos = Range.clip(servoPos,0.6,0.95);
        intakeExtender.setPosition(servoPos);
    }



    // ******* Helper Method for Bucket mechanism *******
    public void fillBucket(){
        bucketFlip.setPosition(0.9);            //correct as of 1/7/25
    }

    public void emptyBucket(){
        bucketFlip.setPosition(.2);             //correct as of 1/7/25
    }


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

    // *******  Helper Methods for Human / Manual Control of Extension and Retraction of Intake
    // Currently Not Used as of 1/6/25

    public void scoreIntakeManual(){
        intakeHolderFlip.setDirection(Servo.Direction.FORWARD);
        //intakeHolderFlip = Range.clip(intakeExtender, 0, 1);
    }
    public void collectIntakeManual(){
        intakeHolderFlip.setDirection(Servo.Direction.REVERSE);
        //intakeHolderFlip = Range.clip(intakeExtender, 0, 1);
    }

    // ******* Controller Methods written by Olivia (combine various helper methods)

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
