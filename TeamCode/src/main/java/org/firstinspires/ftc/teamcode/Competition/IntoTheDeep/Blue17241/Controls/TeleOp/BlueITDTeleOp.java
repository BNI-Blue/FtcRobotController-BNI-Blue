package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Robots.ITDBot;

import java.util.function.IntToDoubleFunction;

@TeleOp (name = "ITD Bot TeleOp", group = "Drive")
public class BlueITDTeleOp extends OpMode {

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

    private static final int PROFILE_1 = 1;  //Charlie
    private static final int PROFILE_2 = 2;  // Evan
    private int currentProfile = PROFILE_2;
    //public double mechanismPower = ___;

    public ITDBot ITDBot = new ITDBot();

    // Declare a Servo object
    public Servo intakeHolderFlip = null;

    // Variables for tracking servo position and movement
    public double currentPosition = 0.0;
    public double targetPosition = 0.17;  // Target position (1.0 is fully extended)
    public double increment = 0.005;  // How much to increment the servo position each loop
    public ElapsedTime runtime = new ElapsedTime();
    public boolean moving = false;  // State variable to track if servo is moving

    @Override
    public void init() {
        ITDBot.initRobot(hardwareMap);
    }


    public void start() {
    }

    @Override
    public void loop() {
        speedControl();
        drive();
        telemetryOutput();
        //liftControl();
        intakeControl();
        preventClawOnStart();
        // changeDriverProfile();
        intakeFlipControl();
        bucketFlipControl();
        bucketLinearControl();
        slowIntake();

        IntakeAssistControl(); //        This combines multiple movements into one button.
        //combinedControl();
    }

    public void changeDriverProfile() {
        if (gamepad1.left_bumper) {
            currentProfile = PROFILE_1;
        } else if (gamepad1.right_bumper) {
            currentProfile = PROFILE_2;
        }

    }



    public void drive() {

        // Joystick values
        leftStickYVal = -gamepad1.left_stick_y;
        leftStickYVal = Range.clip(leftStickYVal, -1, 1);
        //double rightStickYVal = gamepad1.right_stick_y;
        //rightStickYVal = Range.clip(rightStickYVal, -1, 1);

        leftStickXVal = gamepad1.left_stick_x;
        leftStickXVal = Range.clip(leftStickXVal, -1, 1);
        rightStickXVal = gamepad1.right_stick_x;
        rightStickXVal = Range.clip(rightStickXVal, -1, 1);

        switch (currentProfile) {

            // Name of Driver using Profile 1
            case PROFILE_1:
                // leftStickXVal controls rotation, and rightStickXVal controls strafing.
                frontLeftSpeed = leftStickYVal + rightStickXVal + leftStickXVal;    // Vertical + Rotation + Staffing
                frontRightSpeed = leftStickYVal - rightStickXVal - leftStickXVal;   // Vertical - Rotation - Strafing(sign in front is the way the motor is turning in relation to the others)
                rearLeftSpeed = leftStickYVal - rightStickXVal + leftStickXVal;
                rearRightSpeed = leftStickYVal + rightStickXVal - leftStickXVal;
                break;
            // Name of Driver using Profile 2
            case PROFILE_2:
                //leftStickXVal controls strafing, and rightStickXVal controls rotation.
                frontLeftSpeed = leftStickYVal + leftStickXVal + rightStickXVal;
                frontRightSpeed = leftStickYVal - leftStickXVal - rightStickXVal;
                rearLeftSpeed = leftStickYVal - leftStickXVal + rightStickXVal;
                rearRightSpeed = leftStickYVal + leftStickXVal - rightStickXVal;
                break;

            // Default Driver Profile
            default:
                frontLeftSpeed = 0;
                frontRightSpeed = 0;
                rearLeftSpeed = 0;
                rearRightSpeed = 0;
                break;
        }

        // Clipping motor speeds to [-1, 1]
        frontLeftSpeed = Range.clip(frontLeftSpeed, -1, 1);
        frontRightSpeed = Range.clip(frontRightSpeed, -1, 1);
        rearLeftSpeed = Range.clip(rearLeftSpeed, -1, 1);
        rearRightSpeed = Range.clip(rearRightSpeed, -1, 1);

        // Setting motor powers (with threshold check)
        setMotorPower(ITDBot.frontLeftMotor, frontLeftSpeed, powerThreshold, speedMultiply);
        setMotorPower(ITDBot.frontRightMotor, frontRightSpeed, powerThreshold, speedMultiply);
        setMotorPower(ITDBot.rearLeftMotor, rearLeftSpeed, powerThreshold, speedMultiply);
        setMotorPower(ITDBot.rearRightMotor, rearRightSpeed, powerThreshold, speedMultiply);
    }

    public void setMotorPower(DcMotor motor, double speed, double threshold, double multiplier) {
        if (speed <= threshold && speed >= -threshold) {
            motor.setPower(0);
        } else {
            motor.setPower(speed * multiplier);
        }
    }

    public void telemetryOutput() {
        telemetry.addData("pwr ", "FL motor ", +frontLeftSpeed);
        telemetry.addData("pwr ", "FR motor ", +frontRightSpeed);
        telemetry.addData("pwr ", "RL motor ", +rearLeftSpeed);
        telemetry.addData("pwr ", "RR motor ", +rearRightSpeed);
        telemetry.update();
    }

    public void speedControl() {
        if (gamepad1.dpad_up) {
            speedMultiply = 0.5;
        } else if (gamepad1.dpad_right) {
            speedMultiply = 0.75;
        } else if (gamepad1.dpad_down) {
            speedMultiply = 0.25;
        } else if (gamepad1.dpad_left) {
            speedMultiply = 1;
        } else {
            speedMultiply = 1;
        }
    }

    public void preventClawOnStart() {
        if (gamepad1.a) {
            ITDBot.stopMotors();
        }
    }

    public void bucketFlipControl() {
        if (gamepad2.a) {
            ITDBot.fillBucket();
        }
        if (gamepad2.b) {
            ITDBot.emptyBucket();
        }
    }

//    public void combinedControl(){
//        if(gamepad2.options){
//            ITDBot.bucketSlideUp(1, 4.5);
//            ITDBot.emptyBucket();
//            ITDBot.fillBucket();
//            ITDBot.bucketSlideDown(1, 4.3);
//        }
//    }

    public void intakeFlipControl(){
//        if(gamepad2.y){
//            ITDBot.intakeHolderUp();
//        }

        if(gamepad2.x && ITDBot.intakeExtender.getPosition() <= 0.65) {
            ITDBot.intakeHolderDown();
        }
    }


//    public void liftControl() {
//        if (gamepad2.a) {
//            ITDBot.climbingLiftUp(1);
//        } else if (gamepad2.b) {
//            ITDBot.climbingLiftDown(1);
//        } else{
//            ITDBot.climbingLiftStop();
//        }
//    }



    public void intakeControl() {


//        ITDBot.intakeHolderFlip.getPosition() <= 0.6
        if (gamepad2.left_bumper) {
            ITDBot.sampleOuttake();
//            telemetry.addLine("left bumper");
        } else if (gamepad2.right_bumper || ITDBot.intakeHolderFlip.getPosition() >= 0.6) {
            ITDBot.sampleIntake();
//            telemetry.addLine("right bumper");
        }
        else{
            ITDBot.intakeStop();
        }
//*********************************\\
        if(gamepad2.dpad_up){
            ITDBot.extendIntake();
        }

        if (gamepad2.dpad_down && ITDBot.intakeHolderFlip.getPosition() <= 0.6) {
            ITDBot.retractIntake();
        }


    }

    public void bucketLinearControl(){

        if (gamepad2.right_stick_y > 0.1) {
            ITDBot.bucketSlideUp(1);

        } else if (gamepad2.right_stick_y < -0.1) {
            ITDBot.bucketSlideDown(1);
        }
        else {
            ITDBot.bucketSlideStop();
        }
    }

    public void IntakeAssistControl () {
//        Take out this conditional and leave just "gamepad2.left_trigger > 0.5 " if D2 wants to be able to retract no matter waht.
//         && ITDBot.intakeHolderFlip.getPosition() >= 0.6
        if (gamepad2.left_trigger > 0.5 && ITDBot.intakeHolderFlip.getPosition() >= 0.6) {
            telemetry.addLine("SAMPLE INTAKE TO BUCKET CONTROL");
            ITDBot.SampleIntakeToBucket();
        }
    }

    public void slowIntake(){
        currentPosition = ITDBot.intakeHolderFlip.getPosition();
            if (moving) {
                // Gradually move the servo to the target position in small increments
                if (Math.abs(currentPosition - targetPosition) > increment) {
                    if (currentPosition < targetPosition) {
                        currentPosition += increment;
                    } else {
                        currentPosition -= increment;
                    }
                    ITDBot.intakeHolderFlip.setPosition(currentPosition);  // Set the servo's position
                } else {
                    // Once we're close to the target, stop     and set the servo position exactly
                    currentPosition = targetPosition;
                    ITDBot.intakeHolderFlip.setPosition(currentPosition);
                    moving = false;  // Stop the movement
                }
            }

            // For example, you can trigger the servo movement when the 'A' button is pressed
            if (gamepad2.y) {
                // Start the movement towards the target position
                moving = true;
            }

            // You can use telemetry to visualize the current servo position
            telemetry.addData("Servo Position", currentPosition);
            telemetry.addData("Moving", moving ? "Yes" : "No");
            telemetry.update();
        }

        @Override
        public void stop() {
            // Make sure to stop the servo or reset it if needed
            ITDBot.intakeHolderFlip.setPosition(0.37);  // Reset the servo to its starting position
        }
    }

