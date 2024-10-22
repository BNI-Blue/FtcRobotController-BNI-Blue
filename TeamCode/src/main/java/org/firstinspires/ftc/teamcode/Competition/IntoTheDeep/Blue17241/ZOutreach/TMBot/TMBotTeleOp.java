package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.ZOutreach.TMBot;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.ZOutreach.IMBot.IMBot;

public class TMBotTeleOp extends OpMode {
    double leftStickYVal;
    double leftStickXVal;
    double rightStickYVal;
    double rightStickXVal;

    double leftSpeed;
    double rightSpeed;

    double powerThreshold;
    double speedMultiply;

    //public double mechanismPower = ___;

    public TMBot TMBot = new TMBot();

    @Override
    public void init (){
        TMBot.initRobot(hardwareMap);
    }

    public void init_loop(){}

    public void start(){}

    @Override
    public void loop(){
        speedControl();
        drive();
        telemetryOutput();
    }

    public void drive(){

        leftStickYVal = gamepad1.left_stick_y;
        leftStickYVal = Range.clip(leftStickYVal, -1, 1);
        leftStickXVal = gamepad1.left_stick_x;
        leftStickXVal = Range.clip(leftStickYVal, -1, 1);
        rightStickXVal = gamepad1.right_stick_x;
        rightStickXVal = Range.clip(rightStickXVal, -1, 1);

        leftSpeed = leftStickYVal + leftStickXVal + rightStickXVal;
        leftSpeed = Range.clip(leftSpeed, -1, 1);

        rightSpeed = leftStickYVal -  leftStickXVal - rightStickXVal;
        rightSpeed = Range.clip(rightSpeed, -1, 1);


        if (leftSpeed <= powerThreshold && leftSpeed >= -powerThreshold) {
            leftSpeed = 0;
            TMBot.leftMotor.setPower(leftSpeed);
        } else {
            TMBot.leftMotor.setPower(leftSpeed * speedMultiply);
        }

        if (rightSpeed <= powerThreshold && rightSpeed >= -powerThreshold) {
            rightSpeed = 0;
            TMBot.rightMotor.setPower(rightSpeed);
        } else {
            TMBot.rightMotor.setPower(rightSpeed * speedMultiply);
        }

    }

    public void telemetryOutput(){
        telemetry.addData("pwr ", "L motor ", + leftSpeed);
        telemetry.addData("pwr ", "R motor ", + rightSpeed);
        telemetry.update();
    }

    public void speedControl(){
        if(gamepad1.dpad_up){
            speedMultiply = 0.5;
        }
        else if (gamepad1.dpad_right){
            speedMultiply = 0.75;
        }
        else if (gamepad1.dpad_down){
            speedMultiply = 0.25;
        }
        else{
            speedMultiply = 1;
        }
    }
}
