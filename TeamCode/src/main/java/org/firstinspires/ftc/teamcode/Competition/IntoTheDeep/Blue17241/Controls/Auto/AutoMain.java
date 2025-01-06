package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
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
        ITDBot.intakeHolderUp();

    }



    public void bucketDumpTopLevel(){
        ITDBot.extendIntake();
        ITDBot.bucketSlideDown(1);
        sleep(1100);
        ITDBot.bucketSlideStop();
        ITDBot.emptyBucket();
        sleep(1100);
        ITDBot.fillBucket();
        ITDBot.bucketSlideUp(0.5);
        sleep(1450);
        ITDBot.bucketSlideStop();
        ITDBot.retractIntake();
    }

    public void extenderExtended(){
        ITDBot.intakeExtender.setPosition(0.451);//In teleop - position is 0.451
    }

    public void extenderRetracted(){
        ITDBot.intakeExtender.setPosition(0.03);//This is the number Duval said in the email, in TeleOp - position is 0.983
    }

    public void extenderNeutral(){
        ITDBot.intakeExtender.setPosition();
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
        while (pos.getY(DistanceUnit.INCH)  < distance && opModeIsActive()) {
            ITDBot.strafeRight(speed);
            odo.update();
            pos = odo.getPosition();

            telemetry.addData("Target Distance", distance);
            telemetry.addData("Current Y Position", pos.getY(DistanceUnit.INCH));
            telemetry.update();
        }
        ITDBot.stopMotors();
    }



    public double getHeading() {
        odo.update();
        Pose2D pos = odo.getPosition();
        // YawPitchRollAngles \orientation = imu.getRobotYawPitchRollAngles();
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

        //odo.reset();

        double startPosition = pos.getX(DistanceUnit.INCH);

        resetHeading();
        currentHeading = getHeading();

//        telemetry.addData("Left Speed: ", leftSideSpeed);
//        telemetry.addData("Right Speed: ", rightSideSpeed);
        telemetry.addLine("ODO BEFORE MOVE!!!!");
        telemetry.addData("Distance till destination: ", distance - pos.getX(DistanceUnit.INCH));
        telemetry.addData("Target Position: ", target);
        telemetry.addData("Current Heading: ", currentHeading);
        telemetry.addData("Current Position: ", (Math.abs(pos.getX(DistanceUnit.INCH))));
        telemetry.update();
        //sleep(3000);

        double currentPosX = (Math.abs(pos.getX(DistanceUnit.INCH)));
        double leftSideSpeed = 0;
        double rightSideSpeed = 0;

        sleep(100);
        while (currentPosX < distance + startPosition && opModeIsActive()) {
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
            telemetry.addData("Distance till destination: ", distance + startPosition - pos.getX(DistanceUnit.INCH));
            telemetry.addData("Target Position: ", target);
            telemetry.addData("Current Heading: ", currentHeading);
            telemetry.addData("Current Position: ", currentPosX);
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
            telemetry.addData("Current Heading: ", currentHeading);
            telemetry.addData("Current Position: ", currentPosY);
            telemetry.update();
        }

        ITDBot.stopMotors();

        idle();
    }



    public void rotateByGyro(double speed, double targetAngle) {
        resetHeading();
        currentHeading = getHeading();
        if (currentHeading >= targetAngle + headingTolerance && opModeIsActive()) {
            while (currentHeading >= targetAngle + headingTolerance && opModeIsActive()) {
                ITDBot.rotateRight(speed);

                currentHeading = getHeading();
                telemetry.addData("Current Angle: ", currentHeading);
                telemetry.addData("Target Angle: ", targetAngle);
                telemetry.update();
            }
        } else if (currentHeading <= targetAngle - headingTolerance && opModeIsActive()) ;
        {
            while (currentHeading <= targetAngle - headingTolerance && opModeIsActive()) {
                ITDBot.rotateLeft(speed);

                currentHeading = getHeading();
                telemetry.addData("Current Angle: ", currentHeading);
                telemetry.addData("Target Angle: ", targetAngle);
                telemetry.update();
            }
        }
        ITDBot.stopMotors();
        currentHeading = getHeading();
    }



    public void gyroCorrection(double speed, double targetAngle) {
        currentHeading = getHeading();
        if (currentHeading >= targetAngle + headingTolerance && opModeIsActive()) {
            while (currentHeading >= targetAngle + headingTolerance && opModeIsActive()) {
                ITDBot.rotateRight(speed);

                currentHeading = getHeading();
                telemetry.addData("Current Angle: ", currentHeading);
                telemetry.addData("Target Angle: ", targetAngle);
                telemetry.update();
            }
        } else if (currentHeading <= targetAngle - headingTolerance && opModeIsActive()) ;
        {
            while (currentHeading <= targetAngle - headingTolerance && opModeIsActive()) {
                ITDBot.rotateLeft(speed);

                currentHeading = getHeading();
                telemetry.addData("Current Angle: ", currentHeading);
                telemetry.addData("Target Angle: ", targetAngle);
                telemetry.update();
            }
        }
        ITDBot.stopMotors();
        currentHeading = getHeading();
    }
}