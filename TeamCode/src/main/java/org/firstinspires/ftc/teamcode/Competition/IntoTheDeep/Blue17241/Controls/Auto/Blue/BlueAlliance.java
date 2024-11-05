package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.Blue;

import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Auto.AutoMain;

public abstract class BlueAlliance extends AutoMain {

    // Helper Method to Drop Sample in Net Area



    // Helper Method to Park in Observation Area



    // Helper Method to Touch Bar




    // Olivia Legacy Untested Code...

//
//    public void blueObsSampleOne(){
//        ITDBot.strafeRight(1, 3.4);
//        ITDBot.driveForward(1, 2);
//        ITDBot.rotateRight(1, 3.7);
//        ITDBot.driveForward(1, 2.4);
//        ITDBot.rotateLeft(1, 5.6);
//        ITDBot.driveForward(1, 6);
//    }
//
//    public void blueObsSampleTwo(){
//        ITDBot.driveBack(1, 6);
//        ITDBot.rotateRight(1, 1.8);
//        ITDBot.driveForward(1, 1.2);
//        ITDBot.rotateLeft(1, 1.5);
//        ITDBot.driveForward(1, 6.5);
//    }
//
//    public void blueObsSampleThree(){
//        ITDBot.driveBack(1, 2.8);
//        ITDBot.rotateRight(1, 1.8);
//        ITDBot.driveForward(1, 1.2);
//        ITDBot.rotateLeft(1, 1.5);
//        ITDBot.driveForward(1, 6.5);
//    }
//
//    public void blueObsPark(){
//
//    }



    public void blueNetSampleOne(){
        ITDBot.strafeLeft(1, 3.4);
        ITDBot.driveForward(1, 2);
        ITDBot.rotateLeft(1, 3.7);
        ITDBot.driveForward(1, 2.4);
    }

    public void blueNetSampleTwo(){
        ITDBot.rotateRight(1, 1.8);
        ITDBot.driveForward(1, 1.2);
        ITDBot.rotateLeft(1, 1.5);
        ITDBot.driveForward(1, 2);
    }

    public void blueNetSampleThree(){
        ITDBot.driveBack(1, 2.8);
        ITDBot.rotateRight(1, 1.8);
        ITDBot.driveForward(1, 1.2);
        ITDBot.rotateLeft(1, 1.5);
        ITDBot.driveForward(1, 2);
    }

    public void blueNetPark(){

    }
}
