package com.wen.TwentySeventhFifty;

public class AngleBetweenHandsOfAClock {
    public double angleClock(int hour, int minutes) {
        double perHour=360/12;
        double hourAngle=perHour*(hour%12+(double)minutes/60);
        double minutesAngle=360/60*minutes;
        double betweenAngle=Math.abs(hourAngle-minutesAngle);
        return betweenAngle<180?betweenAngle:360-betweenAngle;
    }
}
