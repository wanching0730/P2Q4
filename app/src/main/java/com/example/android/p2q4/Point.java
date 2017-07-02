package com.example.android.p2q4;

/**
 * Created by USER on 11/6/2017.
 */

import java.io.Serializable;

public class Point implements Serializable {

    private double x;
    private double y;

    public Point(double x, double y){
        this.x=x;
        this.y=y;
    }

    public double returnX(){
        return x;
    }

    public double returnY(){
        return y;
    }
}
