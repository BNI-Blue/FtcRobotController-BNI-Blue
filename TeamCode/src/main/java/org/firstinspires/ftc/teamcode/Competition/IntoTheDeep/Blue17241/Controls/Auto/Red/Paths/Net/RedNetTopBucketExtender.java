package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Red.Paths.Net;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Red.RedAlliance;

@Autonomous(name = "Red:Net:Extender")
public class RedNetTopBucketExtender extends RedAlliance {
    @Override
    public void runOpMode() throws InterruptedException{

        // Global Method for Initializing Auto
        autoStartUp();

        waitForStart();

        ITDBot.retractIntake();

        while(opModeIsActive()){
// Preloaded sample scoring in top bucket
            ITDBot.neutralIntake();
            ITDBot.strafeLeft(0.5, 1.6);
            sleep(100);
            ITDBot.driveBack(0.5, .45);
            bucketDumpTopLevel();
            ITDBot.retractIntake();

            rotateByGyroPinpoint(.5, 5);
            ITDBot.collectIntake();
            ITDBot.sampleIntakeAuto();
            sleep(200);
            ITDBot.extendIntake();
            driveStraightGyroPinpoint(.75, 5, "FORWARD", 0);
            sleep(100);

            ITDBot.intakeStop();
            ITDBot.scoreIntake();
            ITDBot.retractIntake();
            ITDBot.sampleOuttake();
            sleep(800);
            ITDBot.neutralIntake();

            driveStraightGyroPinpoint(.75, 5, "BACK", 0);
            rotateByGyroPinpoint(.5, -5);
            bucketDumpTopLevel();


            rotateByGyroPinpoint(.5, 10);
            ITDBot.collectIntake();
            ITDBot.sampleIntakeAuto();
            sleep(200);
            ITDBot.extendIntake();
            driveStraightGyroPinpoint(.75, 4, "FORWARD", 0);
            sleep(100);

            ITDBot.intakeStop();
            ITDBot.scoreIntake();
            ITDBot.retractIntake();
            ITDBot.sampleOuttake();
            sleep(800);
            ITDBot.neutralIntake();

            driveStraightGyroPinpoint(.75, 5, "BACK", 0);
            rotateByGyroPinpoint(.5, -10);
            bucketDumpTopLevel();

            rotateByGyroPinpoint(.5, 15);
            ITDBot.collectIntake();
            ITDBot.sampleIntakeAuto();
            sleep(200);
            ITDBot.extendIntake();
            driveStraightGyroPinpoint(.75, 5, "FORWARD", 0);
            sleep(100);

            ITDBot.intakeStop();
            ITDBot.scoreIntake();
            ITDBot.retractIntake();
            ITDBot.sampleOuttake();
            sleep(800);
            ITDBot.neutralIntake();

            driveStraightGyroPinpoint(.75, 5, "BACK", 0);
            rotateByGyroPinpoint(.5, -15);
            bucketDumpTopLevel();


            requestOpModeStop();

        }
        idle();
    }
}
