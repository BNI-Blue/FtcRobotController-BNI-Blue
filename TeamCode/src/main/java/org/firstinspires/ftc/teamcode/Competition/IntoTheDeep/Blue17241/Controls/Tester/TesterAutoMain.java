package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Tester;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Odometry.Pinpoint;
import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Robots.ProgrammerBot;
import org.firstinspires.ftc.teamcode.Competition.Z20232024CenterStage.Blue17241.Drivetrains.MecanumDrive;

public abstract class TesterAutoMain extends LinearOpMode {

    // Constructor for the Competition Robot for the Blue Team
    public ProgrammerBot Bot = new ProgrammerBot();
    public Pinpoint odo = new Pinpoint();

    public DcMotor frontLeftMotor;
    public DcMotor frontRightMotor;
    public DcMotor rearLeftMotor;
    public DcMotor rearRightMotor;

    // Instance Variables for IMU

    public double headingTolerance = 0.5;
    public double currentHeading = 0;

    public LinearOpMode LinearOp = null;

    public enum driveDirections {
        STOP,
        DRIVE_FORWARD, DRIVE_BACK, STRAFE_LEFT, STRAFE_RIGHT
    }
    MecanumDrive.driveDirections driveDirection = MecanumDrive.driveDirections.STOP;

    // Helper Method for Initializing, Setting LinearOp, and Updating Telemetry
    public void autoStartUp(){
        Bot.initRobot(hardwareMap);
        odo.initPinpoint(hardwareMap);
        Bot.setLinearOp(this);
        odo.setLinearOp(this);
        telemetry.addLine("Awaiting Start");
        telemetry.update();

    }



    public void driveForwardPinpoint(double speed, double distance) {
        odo.update();
        Pose2D pos = odo.getPosition();

        while (pos.getX(DistanceUnit.INCH)  < distance && opModeIsActive()) {
            odo.update();
            pos = odo.getPosition();

            Bot.driveForward(speed);
            odo.update();
            pos = odo.getPosition();

//            telemetry.addData("Current X Position", pos.getX(DistanceUnit.INCH));
//            telemetry.addData("Target Distance", distance);
//            telemetry.update();

        }
        Bot.stopMotors();
    }
    public void driveBackPinpoint(double speed, double distance) {

        odo.update();
        Pose2D pos = odo.getPosition();

        while (pos.getX(DistanceUnit.INCH)  < distance && opModeIsActive()) {
            odo.update();
            pos = odo.getPosition();

            Bot.driveBack(speed);
            odo.update();
            pos = odo.getPosition();
        }
        Bot.stopMotors();
    }

    public void strafeLeftPinpoint(double speed, double distance){
        odo.update();
        Pose2D pos = odo.getPosition();
        double initialY = (Math.abs(pos.getY(DistanceUnit.INCH)));

        while(initialY < distance && opModeIsActive()){
            odo.update();
            pos = odo.getPosition();

            Bot.strafeLeft(speed);
            odo.update();
            pos = odo.getPosition();
        }
        Bot.stopMotors();
    }
    public void strafeRightPinpoint(double speed, double distance) {

        odo.update();
        Pose2D pos = odo.getPosition();
        double initialY = (Math.abs(pos.getY(DistanceUnit.INCH)));

        while (initialY < distance && opModeIsActive()) {
            odo.update();
            pos = odo.getPosition();

            Bot.strafeRight(speed);
            odo.update();
            pos = odo.getPosition();

//            telemetry.addData("Current Y Position", pos.getY(DistanceUnit.INCH));
//            telemetry.addData("Target Distance", distance);
//            telemetry.update();
        }
        Bot.stopMotors();
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

    public void  driveStraightGyroPinpoint(double speed, double distance, String direction, double target) throws InterruptedException {

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

                    Bot.frontLeftMotor.setPower(leftSideSpeed);
                    Bot.rearLeftMotor.setPower(leftSideSpeed);

                    Bot.frontRightMotor.setPower(rightSideSpeed);
                    Bot.rearRightMotor.setPower(rightSideSpeed);

                    break;
                case "BACK":
                    leftSideSpeed = speed - (currentHeading - target) / 75;            // they need to be different
                    rightSideSpeed = speed + (currentHeading - target) / 75;

                    leftSideSpeed = Range.clip(leftSideSpeed, -1, 1);        // helps prevent out of bounds error
                    rightSideSpeed = Range.clip(rightSideSpeed, -1, 1);

                    Bot.frontLeftMotor.setPower(-leftSideSpeed);
                    Bot.rearLeftMotor.setPower(-leftSideSpeed);

                    Bot.frontRightMotor.setPower(-rightSideSpeed);
                    Bot.rearRightMotor.setPower(-rightSideSpeed);
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
        Bot.stopMotors();
        idle();
    }

    public void strafeGyroPinpoint(double speed, double distance, String direction, double target) throws InterruptedException {

        resetHeading();
        currentHeading = getHeading();

        odo.update();
        Pose2D pos = odo.getPosition();

        double startPosition = pos.getY(DistanceUnit.INCH);

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

                    Bot.frontLeftMotor.setPower(leftSideSpeed);
                    Bot.rearLeftMotor.setPower(-leftSideSpeed);


                    Bot.frontRightMotor.setPower(-rightSideSpeed);
                    Bot.rearRightMotor.setPower(rightSideSpeed);
                    break;
                case "LEFT":
                    leftSideSpeed = speed - (currentHeading - target) / 100;            // they need to be different
                    rightSideSpeed = speed + (currentHeading - target) / 100;

                    leftSideSpeed = Range.clip(leftSideSpeed, -1, 1);        // helps prevent out of bounds error
                    rightSideSpeed = Range.clip(rightSideSpeed, -1, 1);

                    Bot.frontLeftMotor.setPower(-leftSideSpeed);
                    Bot.rearLeftMotor.setPower(leftSideSpeed);

                    Bot.frontRightMotor.setPower(rightSideSpeed);
                    Bot.rearRightMotor.setPower(-rightSideSpeed);
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

        Bot.stopMotors();

        idle();

    }

    public double distanceToTarget(double currentX, double currentY, double targetX, double targetY) {
        double targgetXError = Math.abs(targetX) - Math.abs(currentX);
        double targetYError = Math.abs(targetY) - Math.abs(currentY);
        return Math.sqrt(Math.pow(targgetXError, 2) + Math.pow(targetYError, 2));
    }

    // PID Version

    // PID constants for movement (distance to target)
    double kP_move = 0.01;
    double kI_move = 0.001;
    double kD_move = 0.001;
    double integralSumMove = 0;   // Accumulated integral for movement
    double previousErrorMove = 0; // Previous distance error for movement


    // PID constants for heading correction
    double kP_heading = 0.09;
    double kI_heading = 0.001;
    double kD_heading = 0.005;
    double integralSumHeading = 0;
    double previousErrorHeading = 0;
    double headingCorrection = 0;

    public void driveToPositionPID(double targetX, double targetY, double targetHeading, double maxSpeed) {
        odo.update();
        Pose2D pos = odo.getPosition();
        double currentPosX = pos.getX(DistanceUnit.INCH);
        double currentPosY = pos.getY(DistanceUnit.INCH);
        double currentHeading = pos.getHeading(AngleUnit.DEGREES);

        double prevPosX = currentPosX;
        double prevPosY = currentPosY;

        while (opModeIsActive()  && distanceToTarget(currentPosX, currentPosY, targetX, targetY) > 3)
        {
            odo.update();
            pos = odo.getPosition();
            currentPosX = pos.getX(DistanceUnit.INCH);
            currentPosY = pos.getY(DistanceUnit.INCH);
            currentHeading = pos.getHeading(AngleUnit.DEGREES);

            // Calculate errors
            double deltaX = Math.abs(targetX) - Math.abs(currentPosX);
            double deltaY = Math.abs(targetY) - Math.abs(currentPosY);
            double distance = distanceToTarget(currentPosX, currentPosY, targetX, targetY);

            // PID for movement
            double errorMove = distance;
            integralSumMove += errorMove;
            double derivativeMove = errorMove - previousErrorMove;
            double movementSpeed = kP_move * errorMove + kI_move * integralSumMove + kD_move * derivativeMove;
            movementSpeed = Math.max(0.15, Math.min(maxSpeed, movementSpeed));
            previousErrorMove = errorMove;

            // PID for heading correction
            double headingError = targetHeading - currentHeading;
            if (headingError > 180) headingError -= 360;
            if (headingError < -180) headingError += 360;

            if (Math.abs(headingError) < 2) { // Heading tolerance
                headingCorrection = 0;
            } else {
                integralSumHeading += headingError;
                double derivativeHeading = headingError - previousErrorHeading;
                headingCorrection = kP_heading * headingError + kI_heading * integralSumHeading + kD_heading * derivativeHeading;
                previousErrorHeading = headingError;
            }

            // Field-centric movement
            double fieldX = deltaX * Math.cos(Math.toRadians(currentHeading)) - deltaY * Math.sin(Math.toRadians(currentHeading));
            double fieldY = deltaX * Math.sin(Math.toRadians(currentHeading)) + deltaY * Math.cos(Math.toRadians(currentHeading));

            // Normalize motor powers
            double denominator = Math.max(Math.abs(fieldY) + Math.abs(fieldX) + Math.abs(headingCorrection), 1);
            double frontLeftPower = (fieldY + fieldX + headingCorrection) / denominator * movementSpeed;
            double backLeftPower = (fieldY - fieldX + headingCorrection) / denominator * movementSpeed;
            double frontRightPower = (fieldY - fieldX - headingCorrection) / denominator * movementSpeed;
            double backRightPower = (fieldY + fieldX - headingCorrection) / denominator * movementSpeed;

            // Set motor powers
            Bot.frontLeftMotor.setPower(frontLeftPower);
            Bot.rearLeftMotor.setPower(backLeftPower);
            Bot.frontRightMotor.setPower(frontRightPower);
            Bot.rearRightMotor.setPower(backRightPower);

            telemetry.addData("Target X", targetX);
            telemetry.addData("Target Y", targetY);
            telemetry.addData("Current X", currentPosX);
            telemetry.addData("Current Y", currentPosY);
            telemetry.addData("Previous X", prevPosX);
            telemetry.addData("Previous Y", prevPosY);
            telemetry.addData("Distance to Target", distance);
            telemetry.addData("Heading Error", headingError);
            telemetry.addData("Heading Correction", headingCorrection);
            telemetry.update();

            // Stop if minimal position change detected
            double xError = Math.abs(currentPosX) - Math.abs(prevPosX);
            double yError = Math.abs(currentPosY) - Math.abs(prevPosY);

//            if ( xError  < 0.05 &&  yError < 0.05) {
//                break;
//            }

            prevPosX = currentPosX;
            prevPosY = currentPosY;
        }

        Bot.stopMotors(); // Stop motors after reaching target
    }



}