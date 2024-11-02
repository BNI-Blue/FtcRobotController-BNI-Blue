package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Robots.ITDBot;

public abstract class AutoMain extends LinearOpMode {

    // Constructor for the Competition Robot for the Blue Team
    public ITDBot ITDBot = new ITDBot();

    // Helper Method for Initializing, Setting LinearOp, and Updating Telemetry
    public void autoStartUp(){
        ITDBot.initRobot(hardwareMap);
        ITDBot.setLinearOp(this);
        telemetry.addLine("Awaiting Start");
        ITDBot.retractIntake();
        telemetry.update();
    }


 // Legacy Code from Olivia

//     public void dropBasketOne(){
//        ITDBot.raiseArm(1, 5.7);
//    }
//    public void dropBasketTwo(){
//        ITDBot.raiseArm(1, 9.3);
//    }

}
