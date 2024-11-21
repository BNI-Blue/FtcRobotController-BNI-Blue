package org.firstinspires.ftc.teamcode.Lab;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;


@TeleOp(name = "Single Servo Calibrate - CR", group = "LAB")
public class SingleServo_CR extends OpMode {

    public HardwareMap hwBot = null;
    private CRServo myServo = null;


    public void rotateForward() {
        myServo.setDirection(CRServo.Direction.FORWARD);
        myServo.setPower(1);
    }
    public void rotateBackward() {
        myServo.setDirection(CRServo.Direction.FORWARD);
        myServo.setPower(-1);
    }

    public void stopRotation(){
        myServo.setDirection(CRServo.Direction.FORWARD);
        myServo.setPower(0);
    }
    @Override
    public void init () {
        myServo =hwBot.get(CRServo.class, "intake_CRServo");//port 0 - expansion
        myServo.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    @Override
    public void loop () {
        if(gamepad1.right_bumper){
            rotateBackward();
        }
        else if(gamepad1.left_bumper){
            rotateForward();
        }
        else{
            stopRotation();
        }
    }

    public void updateTelemetry () {
        telemetry.addLine("RB: backward, LB: forward");
        telemetry.update();
    }
}
