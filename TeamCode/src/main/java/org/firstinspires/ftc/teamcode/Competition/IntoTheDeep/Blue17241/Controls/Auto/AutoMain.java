package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Odometry.Pinpoint;
import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Robots.ITDBot;

public abstract class AutoMain extends LinearOpMode {

    // Constructor for the Competition Robot for the Blue Team
    public ITDBot ITDBot = new ITDBot();

    public Pinpoint odo = new Pinpoint();

    public double headingTolerance = 0.5;

    public double currentHeading = 0;

    // Helper Method for Initializing, Setting LinearOp, and Updating Telemetry
    public void autoStartUp(){
        ITDBot.initRobot(hardwareMap);
        odo.initPinpoint(hardwareMap);
        ITDBot.setLinearOp(this);
        telemetry.addLine("Awaiting Start");
        ITDBot.retractIntake();
        telemetry.update();
        ITDBot.intakeHolderUpAuto();
        ITDBot.fillBucket();



    }

    public void bucketDumpTopLevel(){
        ITDBot.bucketSlideDown(1);
        sleep(1800);
        ITDBot.bucketSlideStop();
        ITDBot.emptyBucket();
        sleep(1500);
      ITDBot.fillBucket();
        ITDBot.bucketSlideUp(0.5 );
        sleep(1000);
        ITDBot.bucketSlideStop();
    }

 // Legacy Code from Olivia

//     public void dropBasketOne(){
//        ITDBot.raiseArm(1, 5.7);
//    }
//    public void dropBasketTwo(){
//        ITDBot.raiseArm(1, 9.3);
//    }

    public void driveForwardPinpoint(double speed, double distance) {

        odo.update();
        Pose2D pos = odo.getPosition();
        double initialX = pos.getX(DistanceUnit.INCH);
        double initialY = pos.getY(DistanceUnit.INCH);


        while (pos.getY(DistanceUnit.INCH)  < distance && opModeIsActive()) {
            odo.update();
            pos = odo.getPosition();

            ITDBot.driveForward(speed);
            odo.update();
            pos = odo.getPosition();

            telemetry.addData("Current X Position", pos.getX(DistanceUnit.INCH));
            telemetry.addData("Target Distance", distance);
            telemetry.update();

        }
        ITDBot.stopMotors();
    }
    public void driveBackPinpoint(double speed, double distance) {

        odo.update();
        Pose2D pos = odo.getPosition();
        while (pos.getX(DistanceUnit.INCH)  < distance && opModeIsActive()) {
            ITDBot.driveBack(speed);
            odo.update();
            pos = odo.getPosition();

        }
        ITDBot.stopMotors();
    }

    public void strafeLeftPinpoint(double speed, double distance){
        odo.update();
        Pose2D pos = odo.getPosition();
        while(pos.getY(DistanceUnit.INCH) < distance && opModeIsActive()){
            ITDBot.strafeLeft(speed);
            odo.update();
            pos = odo.getPosition();
        }
        ITDBot.stopMotors();
    }
    public void strafeRightPinpoint(double speed, double distance) {

        odo.update();
        Pose2D pos = odo.getPosition();
        while (pos.getY(DistanceUnit.INCH)  < distance && opModeIsActive()) {
            ITDBot.strafeRight(speed);
            odo.update();
            pos = odo.getPosition();

            telemetry.addData("Current Y Position", pos.getY(DistanceUnit.INCH));
            telemetry.addData("Target Distance", distance);
            telemetry.update();
        }
        ITDBot.stopMotors();
    }





    public double getHeading() {
        odo.update();
        Pose2D pos = odo.getPosition();
        // YawPitchRollAngles orientation = imu.getRobotYawPitchRollAngles();
        return pos.getHeading(AngleUnit.DEGREES);
    }

    // Helper Method to reset the IMU Yaw Heading
    public void resetHeading() {
        odo.reset();
        Pose2D pos = odo.getPosition();

        pos.getHeading(AngleUnit.DEGREES);
        odo.update();
    }

    public void driveStraightGyroPinpoint(double speed, double distance, String direction, double target) throws InterruptedException {

        odo.update();
        Pose2D pos = odo.getPosition();

        odo.reset();


        resetHeading();
        currentHeading = getHeading();

        double currentPosX = (Math.abs(pos.getX(DistanceUnit.INCH)));
        double leftSideSpeed = 0;
        double rightSideSpeed = 0;


        sleep(100);
        while (currentPosX < distance && opModeIsActive()) {
            currentHeading = getHeading();

            currentPosX = (Math.abs(pos.getX(DistanceUnit.INCH)));
            odo.update();
//VEERING TO LEFT!
            switch (direction) {
                case "FORWARD":

                    leftSideSpeed = speed + (currentHeading - target) / 75;            // they need to be different
                    rightSideSpeed = speed - (currentHeading - target) / 75;   //100


                    leftSideSpeed = Range.clip(leftSideSpeed, -1, 1);        // helps prevent out of bounds error
                    rightSideSpeed = Range.clip(rightSideSpeed, -1, 1);

                    ITDBot.frontLeftMotor.setPower(leftSideSpeed);
                    ITDBot.rearLeftMotor.setPower(leftSideSpeed);

                    ITDBot.frontRightMotor.setPower(rightSideSpeed);
                    ITDBot.rearRightMotor.setPower(rightSideSpeed);

                    break;
                case "BACK":
                    leftSideSpeed = speed - (currentHeading - target) / 75;            // they need to be different
                    rightSideSpeed = speed + (currentHeading - target) / 75;

                    leftSideSpeed = Range.clip(leftSideSpeed, -1, 1);        // helps prevent out of bounds error
                    rightSideSpeed = Range.clip(rightSideSpeed, -1, 1);

                    ITDBot.frontLeftMotor.setPower(-leftSideSpeed);
                    ITDBot.rearLeftMotor.setPower(-leftSideSpeed);

                    ITDBot.frontRightMotor.setPower(-rightSideSpeed);
                    ITDBot.rearRightMotor.setPower(-rightSideSpeed);
                    break;
            }

            odo.update();
            pos = odo.getPosition();

            telemetry.addData("Left Speed: ", leftSideSpeed);
            telemetry.addData("Right Speed: ", rightSideSpeed);
            telemetry.addData("Distance till destination: ", distance - pos.getX(DistanceUnit.INCH));
            telemetry.addData("Current Position: ", currentPosX);
            telemetry.addData("Target Position: ", target);
            telemetry.addData("Current Heading: ", currentHeading);
            telemetry.update();

        }
        ITDBot.stopMotors();
        idle();
    }

    public void strafeGyroPinpoint(double speed, double distance, String direction, double target) throws InterruptedException {

        odo.update();
        Pose2D pos = odo.getPosition();

        double startPosition = pos.getY(DistanceUnit.INCH);


        resetHeading();
        currentHeading = getHeading();

        double currentPosY = (Math.abs(pos.getY(DistanceUnit.INCH)));
        double leftSideSpeed = 0;
        double rightSideSpeed = 0;


        sleep(100);
        while (currentPosY < distance + startPosition && opModeIsActive()) {
            currentHeading = getHeading();

            currentPosY = (Math.abs(pos.getY(DistanceUnit.INCH)));
            odo.update();
//VEERING TO LEFT!
            switch (direction) {
                case "RIGHT":
                    leftSideSpeed = speed - (currentHeading - target) / 100;            // they need to be different
                    rightSideSpeed = speed + (currentHeading - target) / 100;

                    leftSideSpeed = Range.clip(leftSideSpeed, -1, 1);        // helps prevent out of bounds error
                    rightSideSpeed = Range.clip(rightSideSpeed, -1, 1);

                    ITDBot.frontLeftMotor.setPower(leftSideSpeed);
                    ITDBot.rearLeftMotor.setPower(-leftSideSpeed);


                    ITDBot.frontRightMotor.setPower(-rightSideSpeed);
                    ITDBot.rearRightMotor.setPower(rightSideSpeed);
                    break;
                case "LEFT":
                    leftSideSpeed = speed - (currentHeading - target) / 100;            // they need to be different
                    rightSideSpeed = speed + (currentHeading - target) / 100;

                    leftSideSpeed = Range.clip(leftSideSpeed, -1, 1);        // helps prevent out of bounds error
                    rightSideSpeed = Range.clip(rightSideSpeed, -1, 1);

                    ITDBot.frontLeftMotor.setPower(-leftSideSpeed);
                    ITDBot.rearLeftMotor.setPower(leftSideSpeed);

                    ITDBot.frontRightMotor.setPower(rightSideSpeed);
                    ITDBot.rearRightMotor.setPower(-rightSideSpeed);
                    break;


            }

            odo.update();
            pos = odo.getPosition();

            telemetry.addData("Left Speed: ", leftSideSpeed);
            telemetry.addData("Right Speed: ", rightSideSpeed);
            telemetry.addData("Distance till destination: ", distance + startPosition - pos.getX(DistanceUnit.INCH));
            telemetry.addData("Current Position: ", currentPosY);
            telemetry.addData("Current Heading: ", currentHeading);
            telemetry.update();

        }

        ITDBot.stopMotors();

        idle();
    }

}

