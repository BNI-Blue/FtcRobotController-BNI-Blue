package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Odometry.Pinpoint;
import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Robots.ITDBot;
import org.firstinspires.ftc.teamcode.Competition.Z20232024CenterStage.Blue17241.Drivetrains.MecanumDrive;

public abstract class AutoMain extends LinearOpMode {

    // Constructor for the Competition Robot for the Blue Team
    public ITDBot ITDBot = new ITDBot();

    public Pinpoint odo = new Pinpoint();

    public double headingTolerance = 0.5;

    public double currentHeading = 0;

    public double turnSpeed = 0.65;
    public double correctSpeed = 0.3;

    public enum driveDirections {
        STOP,
        DRIVE_FORWARD, DRIVE_BACK, STRAFE_LEFT, STRAFE_RIGHT
    }
    MecanumDrive.driveDirections driveDirection = MecanumDrive.driveDirections.STOP;



    // Helper Method for Initializing, Setting LinearOp, and Updating Telemetry
    public void autoStartUp(){
        ITDBot.initRobot(hardwareMap);
        odo.initPinpoint(hardwareMap);
        ITDBot.setLinearOp(this);
        odo.setLinearOp(this);
        telemetry.addLine("Awaiting Start");
        ITDBot.retractIntake();
        telemetry.update();
        ITDBot.scoreIntake();

    }



    public void bucketDumpTopLevel(){
        ITDBot.extendIntake();
        ITDBot.bucketSlideUp(1);
        sleep(1300);
        ITDBot.bucketSlideStop();
        ITDBot.emptyBucket();
        sleep(1100);
        ITDBot.fillBucket();
        ITDBot.bucketSlideDown(0.5);
        sleep(1450);
        ITDBot.bucketSlideStop();
        ITDBot.retractIntakeManual();
        sleep(150);
        ITDBot.intakeStop();
    }

    public void bucketDumpTopLevelTwo(){
        ITDBot.extendIntake();
        ITDBot.bucketSlideUp(1);
        sleep(1100);
        ITDBot.bucketSlideStop();
        ITDBot.emptyBucket();
        sleep(1100);
        ITDBot.fillBucket();
        ITDBot.bucketSlideDown(0.5);
        sleep(1450);
        ITDBot.bucketSlideStop();
    }

    public void pickUpSampleOne() throws InterruptedException {
        ITDBot.sampleIntakeAuto();
        sleep(300);
        ITDBot.collectIntake();
        sleep(150);

        ITDBot.extendIntake();
        sleep(300);
//        ITDBot.driveForward(.45);
//        sleep(400);
//        ITDBot.stopMotors();

        ITDBot.driveForward(1,2);
        sleep(750);
        ITDBot.intakeStop();
        sleep(100);
        ITDBot.scoreIntake();
        sleep(250);
        ITDBot.retractIntake();
        sleep(250);
        ITDBot.fillBucket();

        sleep(250);
        ITDBot.sampleOuttake();
        sleep(750);
        ITDBot.intakeStop();
        sleep(100);
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

        odo.reset();

        double startPosition = pos.getX(DistanceUnit.INCH);

        resetHeadingPinpoint();
        currentHeading = getHeadingPinpoint();

        while (Math.abs(pos.getX(DistanceUnit.INCH))  < distance && opModeIsActive()) {
            ITDBot.driveForward(speed);
            odo.update();
            pos = odo.getPosition();

            telemetry.addData("Target Distance", distance);
            telemetry.addData("Current X Position", pos.getX(DistanceUnit.INCH));
            telemetry.update();
        }
        ITDBot.stopMotors();
    }



    public void driveBackPinpoint(double speed, double distance) {

        odo.update();
        Pose2D pos = odo.getPosition();
        while (Math.abs(pos.getX(DistanceUnit.INCH))  < distance && opModeIsActive()) {
            ITDBot.driveBack(speed);
            odo.update();
            pos = odo.getPosition();

            telemetry.addData("Target Distance", distance);
            telemetry.addData("Current X Position", pos.getX(DistanceUnit.INCH));
            telemetry.update();
        }
        ITDBot.stopMotors();
    }



    public void strafeLeftPinpoint(double speed, double distance){
        odo.update();
        Pose2D pos = odo.getPosition();
        while (pos.getY(DistanceUnit.INCH)  < distance && opModeIsActive()) {
            ITDBot.strafeLeft(speed);
            odo.update();
            pos = odo.getPosition();

            telemetry.addData("Target Distance", distance);
            telemetry.addData("Current Y Position", pos.getY(DistanceUnit.INCH));
            telemetry.update();
        }
        ITDBot.stopMotors();
    }



    public void strafeRightPinpoint(double speed, double distance) {

        odo.update();
        Pose2D pos = odo.getPosition();
        //double startPosition = (Math.abs(pos.getY(DistanceUnit.INCH)));
        while (Math.abs(pos.getY(DistanceUnit.INCH)) < distance && opModeIsActive()) {
            ITDBot.strafeRight(speed);
            odo.update();
            pos = odo.getPosition();

            telemetry.addData("Target Distance", distance);
            telemetry.addData("Current Y Position", pos.getY(DistanceUnit.INCH));
            telemetry.update();
        }
        ITDBot.stopMotors();
    }



    public double getHeadingPinpoint() {
        odo.update();
        Pose2D pos = odo.getPosition();
        // YawPitchRollAngles \orientation = imu.getRobotYawPitchRollAngles();
        return pos.getHeading(AngleUnit.DEGREES);
    }


    public double getHeadingRev(){
        YawPitchRollAngles orientation = ITDBot.imu.getRobotYawPitchRollAngles();
        return orientation.getYaw(AngleUnit.DEGREES);
    }

    public void resetHeadingRev(){
        ITDBot.imu.resetYaw();
    }



    // Helper Method to reset the IMU Yaw Heading
    public void resetHeadingPinpoint() {
        odo.reset();
        Pose2D pos = odo.getPosition();
        pos.getHeading(AngleUnit.DEGREES);
        odo.update();
    }



    public void driveStraightGyroPinpoint(double speed, double distance, String direction, double target) throws InterruptedException {

        odo.update();
        Pose2D pos = odo.getPosition();

        odo.reset();

        double startPosition = pos.getX(DistanceUnit.INCH);

        resetHeadingPinpoint();
        currentHeading = getHeadingPinpoint();

//        telemetry.addData("Left Speed: ", leftSideSpeed);
//        telemetry.addData("Right Speed: ", rightSideSpeed);
        telemetry.addLine("ODO BEFORE MOVE!!!!");
        telemetry.addData("Distance till destination: ", distance - pos.getX(DistanceUnit.INCH));
        telemetry.addData("Target Position: ", target);
        telemetry.addData("Current Heading: ", currentHeading);
        telemetry.update();
        //sleep(3000);

        double currentPosX = (Math.abs(pos.getX(DistanceUnit.INCH)));
        double currentPosY = (Math.abs(pos.getY(DistanceUnit.INCH)));
        double leftSideSpeed = 0;
        double rightSideSpeed = 0;

        sleep(100);
        while (currentPosX < distance + startPosition && opModeIsActive()) {
            currentHeading = getHeadingPinpoint();

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
            telemetry.addData("Distance till destination: ", distance + startPosition - pos.getX(DistanceUnit.INCH));
            telemetry.addData("Target Position: ", target);
            telemetry.addData("Current Heading: ", currentHeading);
            telemetry.addData("Current Position X: ", currentPosX);
            telemetry.addData("Current Position Y: ", currentPosY);
            telemetry.update();

        }
        ITDBot.stopMotors();
        idle();
    }

    public void strafeGyroPinpoint(double speed, double distance, String direction, double target) throws InterruptedException {

        odo.update();
        Pose2D pos = odo.getPosition();

        odo.reset();

        double startPosition = pos.getY(DistanceUnit.INCH);

        resetHeadingPinpoint();
        currentHeading = getHeadingPinpoint();

        double currentPosX = (Math.abs(pos.getX(DistanceUnit.INCH)));
        double currentPosY = (Math.abs(pos.getY(DistanceUnit.INCH)));
        double leftSideSpeed = 0;
        double rightSideSpeed = 0;

        sleep(100);
        while (currentPosY < distance + startPosition && opModeIsActive()) {
            currentHeading = getHeadingPinpoint();

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
            telemetry.addData("Current Heading: ", currentHeading);
            telemetry.addData("Current Position: X ", currentPosX);
            telemetry.addData("Current Position: Y ", currentPosY);
            telemetry.update();
        }

        ITDBot.stopMotors();

        idle();
    }



    public void rotateByGyroPinpoint(double speed, double targetAngle) {
        resetHeadingPinpoint();
        currentHeading = getHeadingPinpoint();
        if (currentHeading >= targetAngle + headingTolerance && opModeIsActive()) {
            while (currentHeading >= targetAngle + headingTolerance && opModeIsActive()) {
                ITDBot.rotateRight(speed);

                currentHeading = getHeadingPinpoint();
                telemetry.addData("Current Angle: ", currentHeading);
                telemetry.addData("Target Angle: ", targetAngle);
                telemetry.update();
            }
        } else if (currentHeading <= targetAngle - headingTolerance && opModeIsActive()) {
            while (currentHeading <= targetAngle - headingTolerance && opModeIsActive()) {
                ITDBot.rotateLeft(speed);

                currentHeading = getHeadingPinpoint();
                telemetry.addData("Current Angle: ", currentHeading);
                telemetry.addData("Target Angle: ", targetAngle);
                telemetry.update();
            }
        }
        ITDBot.stopMotors();
        currentHeading = getHeadingPinpoint();
    }
    public void rotateByGyroRev(double speed, double targetAngle) {
        resetHeadingRev();
        currentHeading = getHeadingRev();
        if (currentHeading >= targetAngle + headingTolerance && opModeIsActive()) {
            while (currentHeading >= targetAngle + headingTolerance && opModeIsActive()) {
                ITDBot.rotateRight(speed);

                currentHeading = getHeadingRev();
                telemetry.addData("Current Angle: ", currentHeading);
                telemetry.addData("Target Angle: ", targetAngle);
                telemetry.update();
            }
        } else if (currentHeading <= targetAngle - headingTolerance && opModeIsActive()) {
            while (currentHeading <= targetAngle - headingTolerance && opModeIsActive()) {
                ITDBot.rotateLeft(speed);

                currentHeading = getHeadingRev();
                telemetry.addData("Current Angle: ", currentHeading);
                telemetry.addData("Target Angle: ", targetAngle);
                telemetry.update();
            }
        }
        ITDBot.stopMotors();
        currentHeading = getHeadingRev();
    }


    public void gyroCorrection(double speed, double targetAngle) {
        resetHeadingPinpoint();
        currentHeading = getHeadingPinpoint();
        if (currentHeading >= targetAngle + headingTolerance && opModeIsActive()) {
            while (currentHeading >= targetAngle + headingTolerance && opModeIsActive()) {
                ITDBot.rotateRight(speed);

                currentHeading = getHeadingPinpoint();
                telemetry.addData("Current Angle: ", currentHeading);
                telemetry.addData("Target Angle: ", targetAngle);
                telemetry.update();
            }
        } else if (currentHeading <= targetAngle - headingTolerance && opModeIsActive()) ;
        {
            while (currentHeading <= targetAngle - headingTolerance && opModeIsActive()) {
                ITDBot.rotateLeft(speed);

                currentHeading = getHeadingPinpoint();
                telemetry.addData("Current Angle: ", currentHeading);
                telemetry.addData("Target Angle: ", targetAngle);
                telemetry.update();
            }
        }
        ITDBot.stopMotors();
        currentHeading = getHeadingPinpoint();
    }
}