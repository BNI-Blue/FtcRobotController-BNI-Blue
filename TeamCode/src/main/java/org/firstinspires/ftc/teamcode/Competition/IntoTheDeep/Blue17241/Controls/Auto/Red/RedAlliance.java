package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Red;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.AutoMain;

public abstract class RedAlliance extends AutoMain {


    public void redNetSampleOne(){
        ITDBot.sampleIntakeAuto();
        sleep(200);
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

    public void redNetSampleTwo(){
        ITDBot.sampleIntakeAuto();
        sleep(300);
        ITDBot.collectIntake();
        sleep(1000);

        ITDBot.extendIntake();
        sleep(300);

        driveForwardPinpointCumulative(.25, 5);
        sleep(700);
        ITDBot.intakeStop();
        sleep(100);
        ITDBot.scoreIntake();
        sleep(250);
        ITDBot.retractIntake();
        sleep(250);
        ITDBot.fillBucket();
        sleep(250);
    }

    public void redNetSampleThree(){
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

    public void redNetPreloadSpikeOne(){
        // score preloaded sample
        strafeLeftPinpointCumulative(.55, 6.35);//6
        driveBackPinpointCumulative(.55, 1);
        bucketDumpTopLevelTwo();

        //prepare for first field sample
        strafeRightPinpointCumulative(.5, 1);
        rotateByGyroRev(.3, 31);
        sleep(100);
        driveBackPinpointCumulative(.5 ,.5);

        //collect first field sample
        redNetSampleOne();

        //move to bucket with first sample
        rotateByGyroRev(.25, -31);
        //driveBackPinpointCumulative(.5, .72);
        strafeRightPinpointCumulative(.5, .25);//1.5
        driveBackPinpointCumulative(.5, 2.5);//2.75
        sleep(100);
        ITDBot.sampleOuttake();
        sleep(750);
        ITDBot.intakeStop();
        //rotateByGyroRev(.5, 2.5);

        //score first field sample
        bucketDumpTopLevelOne();
    }


    public void redNetSpikeTwo(){
        rotateByGyroRev(.25, 51.5);

        //collect second field sample
        redNetSampleTwo();

        //move to buckets with second field sample
        rotateByGyroRev(.25, -51.5);
        strafeRightPinpointCumulative(.35, 5.75);
        driveBackPinpointCumulative(.5 ,3.75);

        ITDBot.sampleOuttake();
        sleep(750);
        ITDBot.intakeStop();
        sleep(100);

        rotateByGyroRev(.25, 6);
        //driveBackPinpoint(.5, 1.5);
        bucketDumpTopLevelOne();
    }

    public void redNetSpikeThree(){
        driveForwardPinpointCumulative(.5 ,3);
        rotateByGyroRev(.5, 60);

        redNetSampleThree();

        rotateByGyroRev(.5, -60);
        strafeRightPinpointCumulative(.5, 1);
        driveBackPinpointCumulative(.5, 4);

        bucketDumpTopLevelOne();
    }
}
