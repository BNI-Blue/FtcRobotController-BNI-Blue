package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue.Paths.Net;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue.BlueAlliance;

@Disabled
@Autonomous(name = "Blue:Net:Sample:ObsPark:Pinpoint")
public class BlueNetSampleObsParkPinpoint extends BlueAlliance {
    //@Override
    public void runOpMode() throws InterruptedException{
        // Global Method for Initializing Auto
        autoStartUp();
        resetHeadingPinpoint();
        currentHeading = getHeadingPinpoint();
        odo.update();
        waitForStart();

        //drive methods are pulled from Drivetrain
        while (opModeIsActive()) {

            strafeRightPinpoint(1, .15);
            driveForwardPinpoint(1, 3.85);
            ITDBot.sampleOuttakeAuto();
            sleep(1300);
            ITDBot.intakeStop();

                //Code for if partner can move away from wall
            strafeRightPinpoint(1, .15);
            driveBackPinpoint(1, 8);
            requestOpModeStop();

            }
            idle();
        }
    }
