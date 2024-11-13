package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Tester;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Robots.ITDBot;
import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Robots.ProgrammerBot;

public abstract class TesterAutoMain extends LinearOpMode {

    // Constructor for the Competition Robot for the Blue Team
    public ProgrammerBot Bot = new ProgrammerBot();

    // Helper Method for Initializing, Setting LinearOp, and Updating Telemetry
    public void autoStartUp(){
        Bot.initRobot(hardwareMap);
        Bot.setLinearOp(this);
        telemetry.addLine("Awaiting Start");
        telemetry.update();

    }

}
