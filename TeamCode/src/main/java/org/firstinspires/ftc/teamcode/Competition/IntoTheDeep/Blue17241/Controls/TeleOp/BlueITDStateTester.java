package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Odometry.Pinpoint;
import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Robots.ITDBot;

@TeleOp (name = "Blue State Tester", group = "Drive")
public class BlueITDStateTester extends OpMode {

    public ITDBot ITDBot = new ITDBot();
    public Pinpoint odo = new Pinpoint();

    public ExtendStates extendState = ExtendStates.READY;
    public RetractStates retractState = RetractStates.READY;
    public TransferStates transferState = TransferStates.READY;

    ElapsedTime timer = new ElapsedTime();

    @Override
    public void init() {
        ITDBot.initRobot(hardwareMap);
        odo.initPinpoint(hardwareMap);
        ITDBot.imu.resetYaw();
    }


    public void start() {
    }

    @Override
    public void loop() {

       stateControl();

    }

    @Override
    public void stop() {}


    // ********* TeleOp Control Methods **************

    public void stateControl(){

        if(gamepad2.right_bumper) {
            extendState = ExtendStates.EXTEND;
            extendCollectSampleControl();
        }
        if (gamepad2.left_bumper){

            retractState= RetractStates.FLIP_UP;
            retractCollectSampleControl();
        }

        if(gamepad2.dpad_up){
            transferState = TransferStates.BUCKET_START;
            transferSampleControl();
        }
        if (gamepad2.a ) {
            extendState = ExtendStates.READY;
            retractState= RetractStates.READY;
            transferState = TransferStates.READY;

        }

    }



    // ******* Controller Methods using Machine States

    public enum ExtendStates {
        EXTEND,
        DELAY,
        FLIP_DOWN,
        INTAKE_START,
        READY;
    }

    public enum RetractStates {
        FLIP_UP,
        OUTAKE_STOP,
        RETRACT,
        READY;
    }

    public enum TransferStates {
        BUCKET_START,
        OUTAKE_START,
        DELAY,
        OUTAKE_STOP,
        MOVE_NEUTRAL,
        READY;
    }


    public void extendCollectSampleControl() {
        switch (extendState) {
            case EXTEND:
                ITDBot.extendIntake();
                extendState = ExtendStates.FLIP_DOWN;
                timer.reset();
                break;
            case DELAY:
                if (timer.time() > .5) {
                    extendState = ExtendStates.FLIP_DOWN;
                }
                break;
            case FLIP_DOWN:
                ITDBot.collectIntake();
                extendState = ExtendStates.INTAKE_START;
                break;
            case INTAKE_START:
                ITDBot.sampleIntake();
                extendState = ExtendStates.READY;
                break;
            case READY:
                break;
        }
    }


    public void retractCollectSampleControl() {
        switch (retractState) {
            case FLIP_UP:
                ITDBot.scoreIntake();
                retractState = RetractStates.OUTAKE_STOP;
                break;
            case OUTAKE_STOP:
                ITDBot.intakeStop();
                retractState = RetractStates.RETRACT;
                break;
            case RETRACT:
                ITDBot.retractIntake();
                retractState = RetractStates.READY;
                break;
            case READY:
                break;
        }
    }

    public void transferSampleControl() {
        switch (transferState) {
            case BUCKET_START:
                ITDBot.fillBucket();
                transferState = TransferStates.OUTAKE_START;
                break;
            case OUTAKE_START:
                ITDBot.sampleOuttake();
                timer.reset();
                transferState = TransferStates.DELAY;
                break;
            case DELAY:
                if (timer.seconds() > .5) {
                    transferState = TransferStates.OUTAKE_STOP;
                }
                break;
            case OUTAKE_STOP:
                ITDBot.intakeStop();
                transferState = TransferStates.MOVE_NEUTRAL;
                break;
            case MOVE_NEUTRAL:
                ITDBot.neutralIntake();
                transferState = TransferStates.READY;
                break;
            case READY:
                break;
        }
    }
}

