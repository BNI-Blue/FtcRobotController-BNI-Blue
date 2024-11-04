package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue.Paths;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue.BlueAlliance;

//@Disabled
@Autonomous(name = "Blue:Observation:Auto")
public class BlueObservationPark extends BlueAlliance {
    @Override
    public void runOpMode() throws InterruptedException{

        // Global Method for Initializing Auto
        autoStartUp();

        waitForStart();

        ITDBot.retractIntake();

        while (opModeIsActive()){

            ITDBot.strafeLeft(1, .2);
            ITDBot.driveForward(1, 2.5);

            requestOpModeStop();

        }
        idle();
    }
}