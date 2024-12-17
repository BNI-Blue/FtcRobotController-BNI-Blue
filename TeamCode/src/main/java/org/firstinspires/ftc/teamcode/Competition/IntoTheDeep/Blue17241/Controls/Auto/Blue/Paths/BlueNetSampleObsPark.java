package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue.Paths;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue.BlueAlliance;

@Disabled
@Autonomous(name = "Blue:Net:Sample:ObsPark")
public class BlueNetSampleObsPark extends BlueAlliance {
    //@Override
    public void runOpMode() throws InterruptedException{
            // Global Method for Initializing Auto
            autoStartUp();

            waitForStart();

            ITDBot.retractIntake();

            //drive methods are pulled from Drivetrain
            while (opModeIsActive()) {

                //drive code
                while (opModeIsActive()) {

                    ITDBot.strafeRight(1, .15);
                    ITDBot.driveForward(1, 3.85);
                    ITDBot.sampleOuttakeAuto();
                    sleep(1300);
                    ITDBot.intakeStop();

                    //Code for if partner can move away from wall
                    ITDBot.strafeRight(1, .15);
                    ITDBot.driveBack(1, 8);
                    requestOpModeStop();

                }
                idle();
            }
        }
    }
