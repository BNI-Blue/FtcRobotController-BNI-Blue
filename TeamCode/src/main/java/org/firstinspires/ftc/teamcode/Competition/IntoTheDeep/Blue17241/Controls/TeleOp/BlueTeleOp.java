package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Robots.ITDBot;

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

    public ITDBot ITDBot = new ITDBot();

    @Override
    public void init (){
        ITDBot.initRobot(hardwareMap);
    }

    public void init_loop(){}

    public void start(){}

    @Override
    public void loop(){
        speedControl();
        drive();
        telemetryOutput();
        liftControl();

    }

    public void drive(){

        leftStickYVal = gamepad1.left_stick_y;
        leftStickYVal = Range.clip(leftStickYVal, -1, 1);
        leftStickXVal = gamepad1.left_stick_x;
        leftStickXVal = Range.clip(leftStickYVal, -1, 1);
        rightStickXVal = gamepad1.right_stick_x;
        rightStickXVal = Range.clip(rightStickXVal, -1, 1);

        frontLeftSpeed = leftStickYVal + leftStickXVal + rightStickXVal;
        frontLeftSpeed = Range.clip(frontLeftSpeed, -1, 1);

        frontRightSpeed = leftStickYVal -  leftStickXVal - rightStickXVal;
        frontRightSpeed = Range.clip(frontRightSpeed, -1, 1);

        rearLeftSpeed = leftStickYVal - leftStickXVal + rightStickXVal;
        rearLeftSpeed = Range.clip(rearLeftSpeed, -1, 1);

        rearRightSpeed = leftStickYVal + leftStickXVal - rightStickXVal;
        rearRightSpeed = Range.clip(rearRightSpeed, -1, 1);

        if (frontLeftSpeed <= powerThreshold && frontLeftSpeed >= -powerThreshold) {
            frontLeftSpeed = 0;
            ITDBot.frontLeftMotor.setPower(frontLeftSpeed);
        } else {
            ITDBot.frontLeftMotor.setPower(frontLeftSpeed * speedMultiply);
        }

        if (frontRightSpeed <= powerThreshold && frontRightSpeed >= -powerThreshold) {
            frontRightSpeed = 0;
            ITDBot.frontRightMotor.setPower(frontRightSpeed);
        } else {
            ITDBot.frontRightMotor.setPower(frontRightSpeed * speedMultiply);
        }

        if (rearLeftSpeed <= powerThreshold && rearLeftSpeed >= -powerThreshold) {
            rearLeftSpeed = 0;
            ITDBot.rearLeftMotor.setPower(rearLeftSpeed);
        } else {
            ITDBot.rearLeftMotor.setPower(rearLeftSpeed * speedMultiply);
        }

        if (rearRightSpeed <= powerThreshold && rearRightSpeed >= -powerThreshold) {
            rearRightSpeed = 0;
            ITDBot.rearRightMotor.setPower(rearRightSpeed);
        } else {
            ITDBot.rearRightMotor.setPower(rearRightSpeed * speedMultiply);
        }
    }

    public void telemetryOutput(){
        telemetry.addData("pwr ", "FL motor ", + frontLeftSpeed);
        telemetry.addData("pwr ", "FR motor ", + frontRightSpeed);
        telemetry.addData("pwr ", "RL motor ", + rearLeftSpeed);
        telemetry.addData("pwr ", "RR motor ", + rearRightSpeed);
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

    public void liftControl(){
        if(gamepad1.a){
            ITDBot.raiseLiftOne(1);
        }
        else{
            ITDBot.lowerLiftOne(1);
        }
    }

}