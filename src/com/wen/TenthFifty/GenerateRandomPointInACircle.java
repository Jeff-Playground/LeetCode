package com.wen.TenthFifty;

import java.util.Random;

public class GenerateRandomPointInACircle {
    // Rejection sampling
    private double radius;
    private double x_center;
    private double y_center;

    public GenerateRandomPointInACircle(double radius, double x_center, double y_center) {
        this.radius=radius;
        this.x_center=x_center;
        this.y_center=y_center;
    }

    public double[] randPoint() {
        double[] result=new double[2];
        Random r=new Random();
        double x=2*radius*r.nextDouble(), y=2*radius*r.nextDouble();
        while((x-radius)*(x-radius)+(y-radius)*(y-radius)>radius*radius){
            x=2*radius*r.nextDouble();
            y=2*radius*r.nextDouble();
        }
        return new double[]{x+(x_center-radius), y+(y_center-radius)};
    }
}
