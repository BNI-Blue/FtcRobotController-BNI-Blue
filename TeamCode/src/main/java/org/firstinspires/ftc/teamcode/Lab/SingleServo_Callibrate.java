package org.firstinspires.ftc.teamcode.Lab;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

//@Disabled
@TeleOp(name = "Single Servo Calibrate", group = "LAB")

public class SingleServo_Callibrate extends OpMode {

    private Servo myServo = null;

    //change back to 0.5 for any other servo, but should be 0.2 for ring_mag
    private double servoPos = 1;

    private double incVal = 0.001;

    @Override
    public void init () {
        //"servo_ring_pusher" = ring pusher
        //"ring_mag" = mag servo
//        myServo = hardwareMap.servo.get("bucket_flip");
//        COLLECT = 0.9
//        SCORE = 0.2

//        myServo = hardwareMap.servo.get("intake_flip");
//        COLLECT = 0.941
//        SCORE = .17
        //START OF AUTO = .37
//        DECREASE TO GET CLOSER TO BUCKET
//        DO NOT GO BELOW .11



                myServo = hardwareMap.servo.get("intake_extender");

//
        myServo.setPosition(servoPos);
    }

    @Override
    public void loop () {
        if (gamepad1.right_bumper) {
            servoPos += incVal;
            servoPos = Range.clip(servoPos,0,1);
            telemetry.addLine("Increase Servo Pos!");
        }

        if (gamepad1.left_bumper){
            servoPos -= incVal;
            servoPos = Range.clip(servoPos, 0,  1);
            telemetry.addLine( "Decrease Servo Pos!");
        }


        if (gamepad1.a) {
            servoPos = 0;
        }
        else if (gamepad1.b) {
            servoPos = 1;
        }

        myServo.setPosition(servoPos);
        updateTelemetry();
    }

    public void updateTelemetry () {
        telemetry.addLine("RB: increase, LB: Decrease");
        telemetry.addLine("x = set to .90, y = set to 0.10");
        telemetry.addData("Test Servo Position: ", myServo.getPosition());
        telemetry.addData("Servo Variable Position: ", servoPos);
        telemetry.update();
    }
}


//mag arm down = 0
// mag up = 0.171