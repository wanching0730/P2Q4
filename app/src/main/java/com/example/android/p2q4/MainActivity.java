package com.example.android.p2q4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity implements FragmentOne.OnMidpointCalculateListener {

    private double midpoint_x, midpoint_y;
    private Point midpoint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public void calculateMidpoint(Point pointOne, Point pointTwo) {
        midpoint_x = (pointOne.returnX() + pointTwo.returnX())/2;
        midpoint_y = (pointOne.returnY() + pointTwo.returnY())/2;
        midpoint = new Point(midpoint_x, midpoint_y);
        FragmentTwo fragmentTwo = (FragmentTwo) getFragmentManager().findFragmentById(R.id.fragment2);
        fragmentTwo.retrieveResult(midpoint);

    }
}
