package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue.Paths.Net;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue.BlueAlliance;

@Disabled
@Autonomous(name = "Blue:Net:Extender")
public class BlueNetTopBucketExtender extends BlueAlliance {
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
            bucketDumpTopLevelOne();
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
            bucketDumpTopLevelOne();


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
            bucketDumpTopLevelOne();

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
            bucketDumpTopLevelOne();


            requestOpModeStop();

        }
        idle();
    }
}
