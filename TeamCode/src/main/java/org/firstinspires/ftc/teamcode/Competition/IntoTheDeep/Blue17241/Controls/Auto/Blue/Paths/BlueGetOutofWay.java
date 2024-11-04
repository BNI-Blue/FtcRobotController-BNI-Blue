package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue.Paths;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue.BlueAlliance;

@Disabled
@Autonomous(name = "Blue:GetOutofWay")
public class BlueGetOutofWay extends BlueAlliance {
    @Override
    public void runOpMode() throws InterruptedException{

        // Global Method for Initializing Auto
        autoStartUp();

        waitForStart();

        ITDBot.retractIntake();

        //drive methods are pulled from Drivetrain
        while(opModeIsActive()){

            ITDBot.strafeRight(1, 3);
            sleep(25000);
            requestOpModeStop();

        }
        idle();
    }
}
