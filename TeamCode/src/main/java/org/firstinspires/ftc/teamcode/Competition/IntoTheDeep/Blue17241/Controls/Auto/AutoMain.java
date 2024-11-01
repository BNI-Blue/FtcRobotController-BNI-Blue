package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Robots.ITDBot;

public abstract class AutoMain extends LinearOpMode {

    public ITDBot ITDBot = new ITDBot();


//    public void dropBasketOne(){
//        ITDBot.raiseArm(1, 5.7);
//    }
//    public void dropBasketTwo(){
//        ITDBot.raiseArm(1, 9.3);
//    }

    public void autoStartUp(){
        ITDBot.initRobot(hardwareMap);
        ITDBot.setLinearOp(this);
        telemetry.addLine("Awaiting Start");
        ITDBot.retractIntake();
        telemetry.update();
    }
}
