package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Robots;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Drivetrains.MecanumDrive;

public class BlueBot extends MecanumDrive {

    public HardwareMap hwBot = null;

    //Mechanisms Variables

    //Constructor
    public BlueBot(){}

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

        //HW Mapping Ex

        //pixelArm = hwBot.dcMotor.get("pixel_arm");//Port 0 - Expansion
        //pixelArm.setDirection(DcMotor.Direction.FORWARD);
        //pixelArm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //pixelClawLeft = hwBot.servo.get("pixel_claw_left");//Port 0 - Expansion
        //pixelClawLeft.setDirection(Servo.Direction.REVERSE);
    }

    //Mechanism Methods
}
