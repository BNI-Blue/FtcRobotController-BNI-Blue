package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Red.Paths;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Red.RedAlliance;

@Disabled
@Autonomous(name = "Red:Net:Sample:ObsPark")
public class RedNetSamplePark extends RedAlliance {
    @Override
    public void runOpMode() throws InterruptedException{

        // Global Method for Initializing Auto
        autoStartUp();

        waitForStart();

        ITDBot.retractIntake();

        while(opModeIsActive()){

            ITDBot.strafeRight(1, .13);
            ITDBot.driveForward(1, 3.7);
            ITDBot.sampleOuttake();
            sleep(1400);

            ITDBot.intakeStop();

            //Code for if partner can move away from wall
            ITDBot.strafeRight(1, .15);
            ITDBot.driveBack(1, 8);

            requestOpModeStop();

        }
        idle();
    }
}