package org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.Controls.Tester;


import android.graphics.ColorSpace;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Competition.IntoTheDeep.Blue17241.LEDGold.IndicatorStrip;

public class ColorSensorIntake {

    HardwareMap hwBot = null;
    public RevColorSensorV3 sensor = null;
    IndicatorStrip indicator = new IndicatorStrip();

    //sets threshold for detecting objects using the color sensor's disrance measurement in inches
    double sampleSecuredDistance = 1.3;


    public void init(HardwareMap hwMap) {
        hwBot = hwMap;
        sensor = hwBot.get(RevColorSensorV3.class, "sample_sensor");
        indicator.initIndicatorStrip(hwBot);
    }

    //calcIntake method which processes color and distance data to control LEDs
    public void calcIntake() {
        NormalizedRGBA colors = sensor.getNormalizedColors();
        double red = colors.red;//dont need this
        double green = colors.green;
        double blue = colors.blue;//dont need this
        double distance = sensor.getDistance(DistanceUnit.INCH);

        RevBlinkinLedDriver.BlinkinPattern color;

        double max = Math.max(red, Math.max(green, blue));// compares green and blue first, then compares the result to red to find the overall max

        //Checks which color is dominant
        if(max == green) color = RevBlinkinLedDriver.BlinkinPattern.GREEN;
        else color = RevBlinkinLedDriver.BlinkinPattern.BLACK;

        indicator.capture(color);

        if(distance > sampleSecuredDistance){
            color = RevBlinkinLedDriver.BlinkinPattern.GREEN;
        }
        else{
            color = RevBlinkinLedDriver.BlinkinPattern.BLACK;
        }
    }
}
