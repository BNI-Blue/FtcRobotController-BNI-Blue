package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Robots.BlueBot;

public class BlueTeleOp extends OpMode {

    double leftStickYVal;
    double leftStickXVal;
    double rightStickYVal;
    double rightStickXVal;

    double frontLeftSpeed;
    double frontRightSpeed;
    double rearLeftSpeed;
    double rearRightSpeed;

    double powerThreshold;
    double speedMultiply;

    //public double mechanismPower = ___;

    public BlueBot BlueBot = new BlueBot();

    @Override
    public void init (){
        BlueBot.initRobot(hardwareMap);
    }

    public void init_loop(){}

    public void start(){}

    @Override
    public void loop(){

    }
}
