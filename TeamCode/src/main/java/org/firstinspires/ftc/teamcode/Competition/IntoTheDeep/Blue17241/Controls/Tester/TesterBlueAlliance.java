package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Tester;

public abstract class TesterBlueAlliance extends TesterAutoMain {


    public void blueNetSampleOne(){
        Bot.strafeLeft(1, 3.4);
        Bot.driveForward(1, 2);
        Bot.rotateLeft(1, 3.7);
        Bot.driveForward(1, 2.4);
    }

    public void blueNetSampleTwo(){
        Bot.rotateRight(1, 1.8);
        Bot.driveForward(1, 1.2);
        Bot.rotateLeft(1, 1.5);
        Bot.driveForward(1, 2);
    }

    public void blueNetSampleThree(){
        Bot.driveBack(1, 2.8);
        Bot.rotateRight(1, 1.8);
        Bot.driveForward(1, 1.2);
        Bot.rotateLeft(1, 1.5);
        Bot.driveForward(1, 2);
    }

    public void blueNetPark(){

    }
}
