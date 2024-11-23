package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Tester;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Odometry.Pinpoint;
import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Robots.ITDBot;
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
    public IMU imu = null;
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
            Bot.driveForward(speed);
            odo.update();
            pos = odo.getPosition();

        }
        Bot.stopMotors();
    }
    public void driveBackPinpoint(double speed, double distance) {

        odo.update();
        Pose2D pos = odo.getPosition();
        while (pos.getX(DistanceUnit.INCH)  < distance && opModeIsActive()) {
            Bot.driveBack(speed);
            odo.update();
            pos = odo.getPosition();

        }
        Bot.stopMotors();
    }

    public void strafeLeftPinpoint(double speed, double distance){
        odo.update();
        Pose2D pos = odo.getPosition();
        while(pos.getY(DistanceUnit.INCH) < distance && opModeIsActive()){
            Bot.strafeLeft(speed);
            odo.update();
            pos = odo.getPosition();
        }
        Bot.stopMotors();
    }
    public void strafeRightPinpoint(double speed, double distance) {

        odo.update();
        Pose2D pos = odo.getPosition();
        while (pos.getY(DistanceUnit.INCH)  < distance && opModeIsActive()) {
            Bot.strafeRight(speed);
            odo.update();
            pos = odo.getPosition();

        }
        Bot.stopMotors();
    }

    public void rotateLeftPinpoint(double speed, double distance) {

        odo.update();
        Pose2D pos = odo.getPosition();
        while (pos.getX(DistanceUnit.INCH)  < distance && opModeIsActive()) {
            Bot.rotateLeft(speed);
            odo.update();
            pos = odo.getPosition();

        }
        Bot.stopMotors();
    }
    public void rotateRightPinpoint(double speed, double distance) {

        odo.update();
        Pose2D pos = odo.getPosition();
        while (pos.getX(DistanceUnit.INCH)  < distance && opModeIsActive()) {
            Bot.rotateRight(speed);
            odo.update();
            pos = odo.getPosition();

        }
        Bot.stopMotors();
    }



    public double getHeading() {
        YawPitchRollAngles orientation = imu.getRobotYawPitchRollAngles();
        return orientation.getYaw(AngleUnit.DEGREES);
    }

    // Helper Method to reset the IMU Yaw Heading
    public void resetHeading() {
        imu.resetYaw();
    }

    public void driveStraightGyroPinpoint(double speed, double distance, String direction) throws InterruptedException {

        odo.update();
        Pose2D pos = odo.getPosition();

        imu.resetYaw();
        currentHeading = getHeading();

        double target = getHeading();
        double currentPos = 0;
        double leftSideSpeed = 0;
        double rightSideSpeed = 0;

        double startPosition = pos.getX(DistanceUnit.INCH);
        LinearOp.sleep(100);
        while (currentPos < distance + startPosition && LinearOp.opModeIsActive()) {
            currentHeading = getHeading();
            currentPos = pos.getX(DistanceUnit.INCH);
//VEERING TO LEFT!
            switch (direction) {
                case "FORWARD":
                    leftSideSpeed = speed + (currentHeading - target) / 75;            // they need to be different
                    rightSideSpeed = speed - (currentHeading - target) / 75;   //100


                    leftSideSpeed = Range.clip(leftSideSpeed, -1, 1);        // helps prevent out of bounds error
                    rightSideSpeed = Range.clip(rightSideSpeed, -1, 1);

                    frontLeftMotor.setPower(leftSideSpeed);
                    rearLeftMotor.setPower(leftSideSpeed);

                    frontRightMotor.setPower(rightSideSpeed);
                    rearRightMotor.setPower(rightSideSpeed);

                    break;
                case "BACK":
                    leftSideSpeed = speed - (currentHeading - target) / 75;            // they need to be different
                    rightSideSpeed = speed + (currentHeading - target) / 75;

                    leftSideSpeed = Range.clip(leftSideSpeed, -1, 1);        // helps prevent out of bounds error
                    rightSideSpeed = Range.clip(rightSideSpeed, -1, 1);

                    frontLeftMotor.setPower(-leftSideSpeed);
                    rearLeftMotor.setPower(-leftSideSpeed);


                    frontRightMotor.setPower(-rightSideSpeed);
                    rearRightMotor.setPower(-rightSideSpeed);
                    break;
                case "LEFT":
                    leftSideSpeed = speed - (currentHeading - target) / 100;            // they need to be different
                    rightSideSpeed = speed + (currentHeading - target) / 100;

                    leftSideSpeed = Range.clip(leftSideSpeed, -1, 1);        // helps prevent out of bounds error
                    rightSideSpeed = Range.clip(rightSideSpeed, -1, 1);

                    frontLeftMotor.setPower(leftSideSpeed);
                    rearLeftMotor.setPower(-leftSideSpeed);


                    frontRightMotor.setPower(-rightSideSpeed);
                    rearRightMotor.setPower(rightSideSpeed);
                    break;
                case "RIGHT":
                    leftSideSpeed = speed - (currentHeading - target) / 100;            // they need to be different
                    rightSideSpeed = speed + (currentHeading - target) / 100;

                    leftSideSpeed = Range.clip(leftSideSpeed, -1, 1);        // helps prevent out of bounds error
                    rightSideSpeed = Range.clip(rightSideSpeed, -1, 1);

                    frontLeftMotor.setPower(-leftSideSpeed);
                    rearLeftMotor.setPower(leftSideSpeed);

                    frontRightMotor.setPower(rightSideSpeed);
                    rearRightMotor.setPower(-rightSideSpeed);
                    break;
            }

            LinearOp.telemetry.addData("Left Speed: ", leftSideSpeed);
            LinearOp.telemetry.addData("Right Speed: ", rightSideSpeed);
            LinearOp.telemetry.addData("Distance till destination: ", distance + startPosition - pos.getX(DistanceUnit.INCH));
            LinearOp.telemetry.addData("Current Position: ", currentPos);
            LinearOp.telemetry.addData("Target Position: ", target);
            LinearOp.telemetry.addData("Current Heading: ", currentHeading);
            LinearOp.telemetry.update();

            LinearOp.idle();
        }

        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        rearLeftMotor.setPower(0);
        rearRightMotor.setPower(0);

        LinearOp.idle();

    }

}
