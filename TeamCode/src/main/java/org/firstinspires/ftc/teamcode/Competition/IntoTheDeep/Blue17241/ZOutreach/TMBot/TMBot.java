package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.ZOutreach.TMBot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TMBot extends TMBotDrive{
    public HardwareMap hwBot = null;

    public TMBot(){}

    public void initRobot(HardwareMap hwMap){
        hwBot = hwMap;

        leftMotor = hwBot.dcMotor.get("left_motor");
        rightMotor = hwBot.dcMotor.get("right_motor");

        leftMotor.setDirection(DcMotor.Direction.FORWARD);
        rightMotor.setDirection(DcMotor.Direction.REVERSE);

        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        leftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
}
