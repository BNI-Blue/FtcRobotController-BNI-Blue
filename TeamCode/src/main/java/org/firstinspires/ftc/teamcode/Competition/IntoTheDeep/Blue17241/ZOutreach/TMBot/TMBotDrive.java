package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.ZOutreach.TMBot;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class TMBotDrive {
    public DcMotor leftMotor;
    public DcMotor rightMotor;

    public LinearOpMode LinearOp = null;

    public TMBotDrive(){
    }

    public void setLinearOp(LinearOpMode LinearOp){
        this.LinearOp = LinearOp;
    }

    public void setMotorRunModes (DcMotor.RunMode mode){
        leftMotor.setMode(mode);
        rightMotor.setMode(mode);
    }

    public void stopMotors(){
        leftMotor.setPower(0);
        rightMotor.setPower(0);
    }

    public void driveForward(double speed){
        leftMotor.setPower(speed);
        rightMotor.setPower(speed);
    }

    public void driveBack(double speed){
        leftMotor.setPower(-speed);
        rightMotor.setPower(-speed);
    }

    public void rotateLeft(double speed){
        leftMotor.setPower(-speed);
        rightMotor.setPower(speed);
    }

    public void rotateRight(double speed){
        leftMotor.setPower(speed);
        rightMotor.setPower(-speed);
    }

}
