package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Red.Paths;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Red.RedAlliance;

@Disabled
@Autonomous(name = "Red:Net:Sample")
public class RedNetSample extends RedAlliance {
    @Override
    public void runOpMode() throws InterruptedException{

        // Global Method for Initializing Auto
        autoStartUp();

        waitForStart();

        ITDBot.retractIntake();

        while(opModeIsActive()){

            sleep(25000);

            ITDBot.strafeRight(1, .15);
            ITDBot.driveForward(1, 3.85);
            ITDBot.sampleOuttake();
            sleep(1300);
            ITDBot.intakeStop();

            requestOpModeStop();

        }
        idle();
    }
}
