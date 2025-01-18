package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Red;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.AutoMain;

public abstract class RedAlliance extends AutoMain {


    public void redNetSampleOne(){
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
}
