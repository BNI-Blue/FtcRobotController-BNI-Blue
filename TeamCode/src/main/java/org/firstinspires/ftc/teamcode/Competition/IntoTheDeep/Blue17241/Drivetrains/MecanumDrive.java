package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Drivetrains;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class MecanumDrive {

    public DcMotor frontLeftMotor;
    public DcMotor frontRightMotor;
    public DcMotor rearLeftMotor;
    public DcMotor rearRightMotor;

    public DcMotor liftOne;

    public Servo liftRelease;

    public static final double TICKS_PER_ROTATIONS = 386.3;

    public LinearOpMode LinearOp = null;

    //Default Constructor
    public MecanumDrive(){
    }

    public void setLinearOp(LinearOpMode LinearOp) {this.LinearOp = LinearOp;}

    public void setMotorRunModes(DcMotor.RunMode mode){
        frontLeftMotor.setMode(mode);
        frontRightMotor.setMode(mode);
        rearLeftMotor.setMode(mode);
        rearRightMotor.setMode(mode);
    }

    //Basic Drive Methods

    public void stopMotors(){
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        rearLeftMotor.setPower(0);
        rearRightMotor.setPower(0);
    }

    public void driveForward(double speed){
        frontLeftMotor.setPower(speed);
        frontRightMotor.setPower(speed);
        rearLeftMotor.setPower(speed);
        rearRightMotor.setPower(speed);
    }

    public void driveBack(double speed){
        frontLeftMotor.setPower(-speed);
        frontRightMotor.setPower(-speed);
        rearLeftMotor.setPower(-speed);
        rearRightMotor.setPower(-speed);
    }

    public void rotateLeft(double speed){
        frontLeftMotor.setPower(-speed);
        frontRightMotor.setPower(speed);
        rearLeftMotor.setPower(-speed);
        rearRightMotor.setPower(speed);
    }

    public void rotateRight(double speed){
        frontLeftMotor.setPower(speed);
        frontRightMotor.setPower(-speed);
        rearLeftMotor.setPower(speed);
        rearRightMotor.setPower(-speed);
    }

    public void strafeLeft(double speed){
        frontLeftMotor.setPower(-speed);
        frontRightMotor.setPower(speed);
        rearLeftMotor.setPower(speed);
        rearRightMotor.setPower(-speed);
    }

    public void strafeRight(double speed){
        frontLeftMotor.setPower(speed);
        frontRightMotor.setPower(-speed);
        rearLeftMotor.setPower(-speed);
        rearRightMotor.setPower(speed);
    }

    public void raiseLiftOne(double speed){
        liftOne.setPower(speed);
    }

    public void lowerLiftOne(double speed){
        liftOne.setPower(-speed);
    }

    public void raiseLiftOne(double speed, double rotations){
        double ticks = rotations * TICKS_PER_ROTATIONS;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while((Math.abs(liftOne.getCurrentPosition())) < ticks && LinearOp.opModeIsActive()){
            raiseLiftOne(speed);
            LinearOp.telemetry.addData("Lift ticks ", liftOne.getCurrentPosition());
        }
    }

    public void lowerLiftOne(double speed, double rotations){
        double ticks = rotations * TICKS_PER_ROTATIONS;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while((Math.abs(liftOne.getCurrentPosition())) < ticks && LinearOp.opModeIsActive()){
            lowerLiftOne(speed);
            LinearOp.telemetry.addData("Lift ticks ", liftOne.getCurrentPosition());

        }
    }


    //Drive Methods w/ Encoders

    public void driveForward(double speed, double rotations) {
        double ticks = rotations * TICKS_PER_ROTATIONS;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while ((Math.abs(frontLeftMotor.getCurrentPosition()) < ticks && LinearOp.opModeIsActive())) {
            driveForward(speed);
            LinearOp.telemetry.addData("FL ticks ", frontLeftMotor.getCurrentPosition());
            LinearOp.telemetry.addData("FR ticks ", frontRightMotor.getCurrentPosition());
            LinearOp.telemetry.addData("RL ticks ", rearLeftMotor.getCurrentPosition());
            LinearOp.telemetry.addData("RR ticks ", rearRightMotor.getCurrentPosition());
            LinearOp.telemetry.update();
        }
    }



    public void driveBack(double speed, double rotations){
        double ticks = rotations * TICKS_PER_ROTATIONS;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while ((Math.abs(frontLeftMotor.getCurrentPosition()) < ticks && LinearOp.opModeIsActive())){
            driveBack(speed);
            LinearOp.telemetry.addData("FL ticks ", frontLeftMotor.getCurrentPosition());
            LinearOp.telemetry.addData("FR ticks ", frontRightMotor.getCurrentPosition());
            LinearOp.telemetry.addData("RL ticks ", rearLeftMotor.getCurrentPosition());
            LinearOp.telemetry.addData("RR ticks ", rearRightMotor.getCurrentPosition());
            LinearOp.telemetry.update();
        }
    }

    public void rotateLeft(double speed, double rotations){
        double ticks = rotations * TICKS_PER_ROTATIONS;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while ((Math.abs(frontLeftMotor.getCurrentPosition()) < ticks && LinearOp.opModeIsActive())){
            rotateLeft(speed);
            LinearOp.telemetry.addData("FL ticks ", frontLeftMotor.getCurrentPosition());
            LinearOp.telemetry.addData("FR ticks ", frontRightMotor.getCurrentPosition());
            LinearOp.telemetry.addData("RL ticks ", rearLeftMotor.getCurrentPosition());
            LinearOp.telemetry.addData("RR ticks ", rearRightMotor.getCurrentPosition());
            LinearOp.telemetry.update();
        }
    }

    public void rotateRight(double speed, double rotations){
        double ticks = rotations * TICKS_PER_ROTATIONS;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while ((Math.abs(frontLeftMotor.getCurrentPosition()) < ticks && LinearOp.opModeIsActive())){
            rotateRight(speed);
            LinearOp.telemetry.addData("FL ticks ", frontLeftMotor.getCurrentPosition());
            LinearOp.telemetry.addData("FR ticks ", frontRightMotor.getCurrentPosition());
            LinearOp.telemetry.addData("RL ticks ", rearLeftMotor.getCurrentPosition());
            LinearOp.telemetry.addData("RR ticks ", rearRightMotor.getCurrentPosition());
            LinearOp.telemetry.update();
        }
    }

    public void strafeLeft(double speed, double rotations){
        double ticks = rotations * TICKS_PER_ROTATIONS;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while ((Math.abs(frontLeftMotor.getCurrentPosition()) < ticks && LinearOp.opModeIsActive())){
            strafeLeft(speed);
            LinearOp.telemetry.addData("FL ticks ", frontLeftMotor.getCurrentPosition());
            LinearOp.telemetry.addData("FR ticks ", frontRightMotor.getCurrentPosition());
            LinearOp.telemetry.addData("RL ticks ", rearLeftMotor.getCurrentPosition());
            LinearOp.telemetry.addData("RR ticks ", rearRightMotor.getCurrentPosition());
            LinearOp.telemetry.update();
        }
    }

    public void strafeRight(double speed, double rotations){
        double ticks = rotations * TICKS_PER_ROTATIONS;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while ((Math.abs(frontLeftMotor.getCurrentPosition()) < ticks && LinearOp.opModeIsActive())){
            strafeRight(speed);
            LinearOp.telemetry.addData("FL ticks ", frontLeftMotor.getCurrentPosition());
            LinearOp.telemetry.addData("FR ticks ", frontRightMotor.getCurrentPosition());
            LinearOp.telemetry.addData("RL ticks ", rearLeftMotor.getCurrentPosition());
            LinearOp.telemetry.addData("RR ticks ", rearRightMotor.getCurrentPosition());
            LinearOp.telemetry.update();
        }
    }

    // Helper Method to get Motor Telemetry
    public void getMotorTelemetry() {
        LinearOp.telemetry.addData("FLM", frontLeftMotor.getCurrentPosition());
        LinearOp.telemetry.addData("FRM", frontRightMotor.getCurrentPosition());
        LinearOp.telemetry.addData("RLM", rearLeftMotor.getCurrentPosition());
        LinearOp.telemetry.addData("RRM", rearRightMotor.getCurrentPosition());
        LinearOp.telemetry.update();

    }

}
