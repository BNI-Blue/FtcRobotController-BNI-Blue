package org.firstinspires.ftc.teamcode.Lab;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

//Class is used for testing a single motor, using trigger for variable power.
//WITHOUT
@TeleOp(name = "motor launcher test - NO ENCODERS", group="Labs")
@Disabled
public class Motor_ButtonToggle extends OpMode {
    private DcMotor motor = null;
    double r_trigger;
    double l_trigger;

    boolean forward = true;

    boolean toggleLaunch = false;

    double speed = 0.6;

    @Override
    public void init() {
        motor = hardwareMap.dcMotor.get("launcher_motor");
        motor.setDirection(DcMotorSimple.Direction.REVERSE);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);




        forward = true;

        telemetry.addLine("Press 'a' to engage motor.");
        telemetry.addLine("Press 'b' to stop motor.");
        telemetry.addLine("Press d-pad up for motor to go forward");
        telemetry.addLine("Press d-down up for motor to go reverse");
        telemetry.update();
    }


    @Override
    public void loop() {
        if (toggleLaunch && forward == true) {
            motor.setPower(speed);
        }
// 1)
//        Make motor go reverse? Valid values of motors are [-1, +1]
        if(toggleLaunch && forward == false){
            motor.setPower(-speed);
        }

        if (gamepad1.a == true) {
            toggleLaunch = true;
        }

        if(gamepad1.b == true){
            motor.setPower(0);
        }


        //2) Stop motor if press b






        if (gamepad1.dpad_up == true) {
            forward = true;
        }

        if (gamepad1.dpad_down == true) {
            forward = false;
        }

        update_telemetry();
    }

    public void update_telemetry () {
        telemetry.addData("Forward mode? ", forward);
        telemetry.addData("A being pressed? ", gamepad1.a);
        telemetry.addData("motor power: ", motor.getPower());
    }
}
