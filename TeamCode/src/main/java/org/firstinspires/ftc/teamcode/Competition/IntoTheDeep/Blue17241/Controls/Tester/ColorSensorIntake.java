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

    double sampleSecuredDistance = 1.3;


    public void init(HardwareMap hwMap) {
        hwBot = hwMap;
        sensor = hwBot.get(RevColorSensorV3.class, "sample_sensor");
        indicator.initIndicatorStrip(hwBot);
    }

    public void calcIntake() {
        NormalizedRGBA colors = sensor.getNormalizedColors();
        double red = colors.red;
        double green = colors.green;
        double blue = colors.blue;

        RevBlinkinLedDriver.BlinkinPattern color;

        double max = Math.max(red, Math.max(green, blue));

        if (max == red) color = RevBlinkinLedDriver.BlinkinPattern.RED;
        else if (max == blue) color = RevBlinkinLedDriver.BlinkinPattern.BLUE;
        //TODO: Add calc for yellow
        else color = RevBlinkinLedDriver.BlinkinPattern.BLACK;

        indicator.capture(color);
    }

    public void colorIntake(){
        double distance = sensor.getDistance(DistanceUnit.INCH);
        NormalizedRGBA colors = sensor.getNormalizedColors();
        double red = colors.red;
        double green = colors.green;
        double blue = colors.blue;
        RevBlinkinLedDriver.BlinkinPattern color;


        double max = Math.max(red, Math.max(green, blue));

        if(distance < sampleSecuredDistance){
            color = RevBlinkinLedDriver.BlinkinPattern.BLACK;
        }

        else if(distance > sampleSecuredDistance){
            if(max == red) color = RevBlinkinLedDriver.BlinkinPattern.RED;
            else if(max == blue) color = RevBlinkinLedDriver.BlinkinPattern.BLUE;
        }
    }
}
