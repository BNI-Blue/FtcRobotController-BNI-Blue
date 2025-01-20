package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Red;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.AutoMain;

public abstract class RedAlliance extends AutoMain {


    public void redNetSampleOne(){
        ITDBot.sampleIntakeAuto();
        sleep(300);
        ITDBot.collectIntake();
        sleep(150);


        driveForwardPinpointCumulative(1, 2);
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

    public void redNetSampleTwo(){
        ITDBot.sampleIntakeAuto();
        sleep(300);
        ITDBot.collectIntake();
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

    public void redNetSampleThree(){
        ITDBot.sampleIntakeAuto();
        sleep(300);
        ITDBot.collectIntake();
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
        strafeLeftPinpointCumulative(.55, 7.5);
        driveBackPinpointCumulative(.55, 1.5);
        //strafeGyroPinpoint(0.55, 7.5, "LEFT", 0);
        //driveStraightGyroPinpoint(.55, 1.5, "BACK", 0);
        bucketDumpTopLevelTwo();


        //prepare for first field sample
        strafeRightPinpointCumulative(.5, .7);
        //strafeGyroPinpoint(0.5,0.7, "RIGHT",0);
        rotateByGyroRev(.3, 27.5);
        sleep(100);

        //collect first field sample
        redNetSampleOne();

        //move to bucket with first sample
        rotateByGyroRev(.25, -27.5);
        driveBackPinpointCumulative(.5, 6);
        //driveBackPinpoint(.5, 6);
        strafeRightPinpointCumulative(.5 ,2);
        //strafeGyroPinpoint(.5,2,"RIGHT",0);

        //score first field sample
        bucketDumpTopLevelOne();
    }


    public void redNetSpikeTwo(){
        rotateByGyroRev(.25, 40.25);
        //collect second field sample
        redNetSampleTwo();

        //move to buckets with second field sample
        rotateByGyroRev(.25, -40.25);
        strafeRightPinpointCumulative(.35, 3);
        //strafeRightPinpoint(.35, 3);
        driveBackPinpointCumulative(.5 ,1.5);
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
