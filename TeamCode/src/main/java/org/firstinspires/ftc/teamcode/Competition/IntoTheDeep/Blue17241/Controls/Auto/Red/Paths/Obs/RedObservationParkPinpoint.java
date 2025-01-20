package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Red.Paths.Obs;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Red.RedAlliance;

//@Disabled
@Autonomous(name = "Red:Observation:Park:Pinpoint")
public class RedObservationParkPinpoint extends RedAlliance {
    //@Override
    public void runOpMode() throws InterruptedException{
        // Global Method for Initializing Auto
        autoStartUp();
        resetHeadingPinpoint();
        currentHeading = getHeadingPinpoint();
        odo.update();
        waitForStart();

        ITDBot.retractIntake();

        while (opModeIsActive()){

            strafeRightPinpoint(1, .2);
            driveBackPinpointCumulative(1, 7);

            requestOpModeStop();

        }
        idle();
    }
}
