package org.firstinspires.ftc.teamcode.Competition.Z20232024CenterStage.Blue17241.Testers;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

//@Disabled
@TeleOp(name = "One Servo Tester")

public class OneServoTester extends OpMode {

    private CRServo intakeRotate = null;
    private double grabberLeftArmPos = 0.3;
    private double incVal = 0.001;
    private Servo grabberArmLeft = null;


    @Override
    public void init () {
        intakeRotate = hardwareMap.get(CRServo.class, "intake_CRServo");//port 0 - expansion
        intakeRotate.setDirection(DcMotorSimple.Direction.FORWARD);

        grabberArmLeft = hardwareMap.servo.get("intake_extender");
        grabberArmLeft.setPosition(grabberLeftArmPos);



//        intakeRotate = hardwareMap.get("intake_flip");
//        intakeRotate.setPosition(grabberLeftArmPos);
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
            //grabberLeftArmPos = .2;
            grabberArmLeft.setPosition(0.1);
        }
        if (gamepad1.b) {
            //grabberLeftArmPos = .9;
            grabberArmLeft.setPosition(0.9);
        }

       // if (gamepad1.a) {
         //   grabberLeftArmPos = .32;
        //}

        //intakeRotate.setPosition(grabberLeftArmPos);
        updateTelemetry();
    }


    public void updateTelemetry () {
        telemetry.addLine("RB: increase, LB: Decrease");
        telemetry.addLine("x = set to .90, y = set to 0.10");
        telemetry.addData("Servo Position: ", + grabberArmLeft.getPosition());
        //telemetry.addData("Grabber Left Arm Position:", intakeRotate.getPosition());
        //telemetry.addData("Grabber Left Arm Position:", grabberLeftArmPos);
        telemetry.update();
    }
}