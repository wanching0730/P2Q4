package com.example.android.p2q4;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by USER on 11/6/2017.
 */

public class FragmentOne extends android.app.Fragment {

    private EditText point_1_x_field, point_1_y_field, point_2_x_field, point_2_y_field;
    private FloatingActionButton fab;
    private Point p1, p2;
    private double point_x, point_y;
    private OnMidpointCalculateListener listener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_one, container, false);

        fab = (FloatingActionButton) view.findViewById(R.id.fab_done);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                point_1_x_field = (EditText) view.findViewById(R.id.point_1_x);
                point_1_y_field = (EditText) view.findViewById(R.id.point_1_y);
                point_2_x_field = (EditText) view.findViewById(R.id.point_2_x);
                point_2_y_field = (EditText) view.findViewById(R.id.point_2_y);

                point_x = Double.parseDouble(point_1_x_field.getText().toString());
                point_y = Double.parseDouble(point_1_y_field.getText().toString());
                p1 = new Point(point_x, point_y);
                point_x = Double.parseDouble(point_2_x_field.getText().toString());
                point_y = Double.parseDouble(point_2_y_field.getText().toString());
                p2 = new Point(point_x, point_y);

                listener.calculateMidpoint(p1,p2);
            }
        });

        return view;
    }

    public interface OnMidpointCalculateListener{
        void calculateMidpoint(Point pointOne, Point pointTwo);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try{
            listener = (OnMidpointCalculateListener) activity;
        }catch(Exception e){}
    }
}
