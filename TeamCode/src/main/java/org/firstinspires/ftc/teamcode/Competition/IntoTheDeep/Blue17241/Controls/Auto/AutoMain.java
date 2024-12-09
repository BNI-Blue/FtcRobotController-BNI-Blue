package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Odometry.Pinpoint;
import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Robots.ITDBot;

public abstract class AutoMain extends LinearOpMode {

    // Constructor for the Competition Robot for the Blue Team
    public ITDBot ITDBot = new ITDBot();

    public Pinpoint odo = new Pinpoint();

    // Helper Method for Initializing, Setting LinearOp, and Updating Telemetry
    public void autoStartUp(){
        ITDBot.initRobot(hardwareMap);
        odo.initPinpoint(hardwareMap);
        ITDBot.setLinearOp(this);
        telemetry.addLine("Awaiting Start");
        ITDBot.retractIntake();
        telemetry.update();
        ITDBot.intakeHolderUpAuto();
        ITDBot.fillBucket();



    }

    public void bucketDumpTopLevel(){
        ITDBot.bucketSlideDown(1);
        sleep(1800);
        ITDBot.bucketSlideStop();
        ITDBot.emptyBucket();
        sleep(1500);
      ITDBot.fillBucket();
        ITDBot.bucketSlideUp(0.5 );
        sleep(1000);
        ITDBot.bucketSlideStop();
    }

 // Legacy Code from Olivia

//     public void dropBasketOne(){
//        ITDBot.raiseArm(1, 5.7);
//    }
//    public void dropBasketTwo(){
//        ITDBot.raiseArm(1, 9.3);
//    }

}
