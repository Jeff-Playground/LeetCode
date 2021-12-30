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
        Random r=new Random();
        // Here use 2*radius*(a random double in [0.0,1.0])-radius to find the point in the circle, x and y stands for
        // the distance to center on x-axis and y-axis respectively
        double x=2*radius*r.nextDouble()-radius, y=2*radius*r.nextDouble()-radius;
        while(x*x+y*y>radius*radius){
            x=2*radius*r.nextDouble()-radius;
            y=2*radius*r.nextDouble()-radius;
        }
        return new double[]{x+x_center, y+y_center};
    }
}
