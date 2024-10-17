package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.ZOutreach.IMBot;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.ZOutreach.GhostBot.GhostBot;

@TeleOp(name = "IMBot")
public class IMBotTeleOp extends OpMode {
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

    public IMBot IMBot = new IMBot();

    @Override
    public void init (){
        IMBot.initRobot(hardwareMap);
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
            IMBot.frontLeftMotor.setPower(frontLeftSpeed);
        } else {
            IMBot.frontLeftMotor.setPower(frontLeftSpeed * speedMultiply);
        }

        if (frontRightSpeed <= powerThreshold && frontRightSpeed >= -powerThreshold) {
            frontRightSpeed = 0;
            IMBot.frontRightMotor.setPower(frontRightSpeed);
        } else {
           IMBot.frontRightMotor.setPower(frontRightSpeed * speedMultiply);
        }

        if (rearLeftSpeed <= powerThreshold && rearLeftSpeed >= -powerThreshold) {
            rearLeftSpeed = 0;
            IMBot.rearLeftMotor.setPower(rearLeftSpeed);
        } else {
            IMBot.rearLeftMotor.setPower(rearLeftSpeed * speedMultiply);
        }

        if (rearRightSpeed <= powerThreshold && rearRightSpeed >= -powerThreshold) {
            rearRightSpeed = 0;
            IMBot.rearRightMotor.setPower(rearRightSpeed);
        } else {
            IMBot.rearRightMotor.setPower(rearRightSpeed * speedMultiply);
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
}
