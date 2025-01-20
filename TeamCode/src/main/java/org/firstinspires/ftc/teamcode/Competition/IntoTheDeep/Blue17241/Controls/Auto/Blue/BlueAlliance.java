package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.AutoMain;

public abstract class BlueAlliance extends AutoMain {


    public void blueNetSampleOne(){
        ITDBot.sampleIntakeAuto();
        sleep(200);
        //ITDBot.submersibleIntake();
        ITDBot.collectIntake();
        sleep(1000);

        driveForwardPinpointCumulative(.25, 7.25);
        sleep(700);
        ITDBot.intakeStop();
        sleep(200);
        ITDBot.scoreIntake();
        sleep(400);
        ITDBot.retractIntake();
        sleep(400);
        ITDBot.fillBucket();
        sleep(100);
    }

    public void blueNetSampleTwo(){
        ITDBot.sampleIntakeAuto();
        sleep(300);
        ITDBot.submersibleIntake();
        sleep(150);

        ITDBot.extendIntake();
        sleep(300);
//        ITDBot.driveForward(.45);
//        sleep(400);
//        ITDBot.stopMotors();

        ITDBot.driveForward(1,2);
        sleep(750);
        ITDBot.intakeStop();
        sleep(100);
        ITDBot.scoreIntake();
        sleep(250);
        ITDBot.retractIntake();
        sleep(250);
        ITDBot.fillBucket();

        sleep(250);
        ITDBot.sampleOuttake();
        sleep(750);
        ITDBot.intakeStop();
        sleep(100);
    }

    public void blueNetSampleThree(){
        ITDBot.sampleIntakeAuto();
        sleep(300);
        ITDBot.submersibleIntake();
        sleep(150);

        ITDBot.extendIntake();
        sleep(300);
//        ITDBot.driveForward(.45);
//        sleep(400);
//        ITDBot.stopMotors();

        ITDBot.driveForward(1,2);
        sleep(750);
        ITDBot.intakeStop();
        sleep(100);
        ITDBot.scoreIntake();
        sleep(250);
        ITDBot.retractIntake();
        sleep(250);
        ITDBot.fillBucket();

        sleep(250);
        ITDBot.sampleOuttake();
        sleep(750);
        ITDBot.intakeStop();
        sleep(100);
    }

    public void blueNetPreloadSpikeOne(){
        // score preloaded sample
        strafeLeftPinpointCumulative(.55, 7);
        driveBackPinpointCumulative(.55, 1.5);
        bucketDumpTopLevelTwo();

        //prepare for first field sample
        strafeRightPinpointCumulative(.5, 1);
        rotateByGyroRev(.3, 28);
        sleep(100);
        driveBackPinpointCumulative(.5 ,.5);

        //collect first field sample
        blueNetSampleOne();

        //move to bucket with first sample
        rotateByGyroRev(.25, -28);
        //driveBackPinpointCumulative(.5, .72);
        strafeLeftPinpointCumulative(.5, .25);
        driveBackPinpointCumulative(.5, 2.5);
        ITDBot.sampleOuttake();
        sleep(750);
        ITDBot.intakeStop();

        //score first field sample
        bucketDumpTopLevelOne();
    }

    public void blueNetSpikeTwo(){
        rotateByGyroRev(.25, 40.25);

        //collect second field sample
        blueNetSampleTwo();

        //move to buckets with second field sample
        rotateByGyroRev(.25, -40.25);
        strafeRightPinpointCumulative(.35, 3);
        //strafeRightPinpoint(.35, 3);
        driveBackPinpointCumulative(.5 ,1.5);
        //driveBackPinpoint(.5, 1.5);
        bucketDumpTopLevelOne();
    }

    public void blueNetSpikeThree(){
        driveForwardPinpointCumulative(.5 ,3);
        rotateByGyroRev(.5, 60);

        blueNetSampleThree();

        rotateByGyroRev(.5, -60);
        strafeRightPinpointCumulative(.5, 1);
        driveBackPinpointCumulative(.5, 4);

        bucketDumpTopLevelOne();
    }
}
