package org.firstinspires.ftc.teamcode.Competition.Z20232024CenterStage.Blue17241.Testers;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
@Disabled
@TeleOp(name = "Two Servo Tester")

public class TwoServoTester extends OpMode {

    private Servo grabberArmLeft = null;
    private double grabberLeftArmPos = 0.5;
    private double incVal = 0.001;
    private Servo grabberArmRight = null;
    private double grabberRightArmPos = 0.5;


    @Override
    public void init () {
        grabberArmLeft = hardwareMap.servo.get("pixel_claw_left");
        grabberArmLeft.setPosition(grabberLeftArmPos);
        grabberArmRight = hardwareMap.servo.get("pixel_claw_right");
        grabberArmRight.setPosition((grabberRightArmPos));
    }

    @Override
    public void loop () {
        if (gamepad1.right_bumper) {
            grabberLeftArmPos += incVal;
            grabberLeftArmPos = Range.clip(grabberLeftArmPos,0,1);
            telemetry.addLine("Increase Servo Pos!");
        }

        if (gamepad1.left_bumper){
            grabberLeftArmPos -= incVal;
            grabberLeftArmPos = Range.clip(grabberLeftArmPos, 0,  1);
            telemetry.addLine( "Decrease Servo Pos!");
        }
        if (gamepad1.y) {
            grabberLeftArmPos = .4;
        }
        if (gamepad1.b) {
            grabberLeftArmPos = .35;
        }
        if (gamepad1.a) {
            grabberLeftArmPos = .32;
        }


        grabberArmLeft.setPosition(grabberLeftArmPos);

        if (gamepad2.right_bumper) {
            grabberRightArmPos += incVal;
            grabberRightArmPos = Range.clip(grabberRightArmPos,0,1);
            telemetry.addLine("Increase Servo Pos!");
        }

        if (gamepad2.left_bumper){
            grabberRightArmPos -= incVal;
            grabberRightArmPos = Range.clip(grabberRightArmPos, 0,  1);
            telemetry.addLine( "Decrease Servo Pos!");
        }

        if (gamepad2.y) {
            grabberRightArmPos = .4;
        }
        if (gamepad2.b) {
            grabberRightArmPos = .35;
        }
        if (gamepad2.a) {
            grabberRightArmPos = .32;
        }


        grabberArmRight.setPosition(grabberRightArmPos);
        updateTelemetry();
    }


    public void updateTelemetry () {
        telemetry.addLine("RB: increase, LB: Decrease");
        telemetry.addLine("x = set to .90, y = set to 0.10");
        telemetry.addData("Grabber Left Arm Position:", grabberArmLeft.getPosition());
        telemetry.addData("Grabber Left Arm Position:", grabberLeftArmPos);
        telemetry.addData("Grabber Right Arm Position", grabberArmRight.getPosition());
        telemetry.addData("Grabber Right Arm Position", grabberRightArmPos);
        telemetry.update();
    }
}