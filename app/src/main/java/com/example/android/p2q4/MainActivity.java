package com.example.android.p2q4;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends FragmentActivity implements FragmentOne.OnMidpointCalculateListener {

    private double midpoint_x, midpoint_y;
    private Point midpoint;
    public final static String BUNDLE_MIDPOINT = "com.example.android.p2q4.Midpoint";

    //set up MainActivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_layout);

        android.widget.Toolbar toolbar = (android.widget.Toolbar) findViewById(R.id.tool_bar);
        setActionBar(toolbar);


        if(findViewById(R.id.fragment_container) != null){

            if(savedInstanceState != null){
                return;
            }

            FragmentOne fragmentOne = new FragmentOne();
            fragmentOne.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragmentOne).commit();
        }
    }

    @Override
    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount() == 0){
            super.onBackPressed();
        }
        else{
            getFragmentManager().popBackStack();
        }
    }

    @Override
    public void calculateMidpoint(Point pointOne, Point pointTwo) {
        midpoint_x = (pointOne.returnX() + pointTwo.returnX())/2;
        midpoint_y = (pointOne.returnY() + pointTwo.returnY())/2;
        midpoint = new Point(midpoint_x, midpoint_y);

        FragmentTwo fragmentTwo = new FragmentTwo();
        Bundle args = new Bundle();
        args.putSerializable(BUNDLE_MIDPOINT, midpoint);
        //setArgument(Bundle)
        fragmentTwo.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragmentTwo);
        transaction.addToBackStack(null);

        transaction.commit();


    }
}
