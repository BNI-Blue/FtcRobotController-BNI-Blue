package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue.Paths;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue.BlueAlliance;
@Disabled

@Autonomous(name = "Blue:Observation:Park:Pinpoint")
public class BlueObservationParkPinpoint extends BlueAlliance {
    //@Override
    public void runOpMode() throws InterruptedException{
        // Global Method for Initializing Auto
        autoStartUp();
        resetHeading();
        currentHeading = getHeading();
        odo.update();
        waitForStart();

        ITDBot.retractIntake();

        while (opModeIsActive()){

            strafeLeftPinpoint(1, .2);
            driveForwardPinpoint(1, 2.5);

            requestOpModeStop();

        }
        idle();
    }
}
