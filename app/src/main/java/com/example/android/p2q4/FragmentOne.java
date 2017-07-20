package com.example.android.p2q4;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by USER on 11/6/2017.
 */

public class FragmentOne extends Fragment {

    private EditText point_1_x_field, point_1_y_field, point_2_x_field, point_2_y_field;
    private Button btnCalculate;
    private Point p1, p2;
    private double point_x, point_y;
    private OnMidpointCalculateListener listener;

    @Nullable
    @Override
    //fragment use a layout inflater to create their view
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    //called when the onCreate() in MainActivity is called
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btnCalculate = (Button) getActivity().findViewById(R.id.cal_midpoint);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                point_1_x_field = (EditText) getActivity().findViewById(R.id.point_1_x);
                point_1_y_field = (EditText) getActivity().findViewById(R.id.point_1_y);
                point_2_x_field = (EditText) getActivity().findViewById(R.id.point_2_x);
                point_2_y_field = (EditText) getActivity().findViewById(R.id.point_2_y);

                point_x = Double.parseDouble(point_1_x_field.getText().toString());
                point_y = Double.parseDouble(point_1_y_field.getText().toString());
                p1 = new Point(point_x, point_y);
                point_x = Double.parseDouble(point_2_x_field.getText().toString());
                point_y = Double.parseDouble(point_2_y_field.getText().toString());
                p2 = new Point(point_x, point_y);

                listener.calculateMidpoint(p1,p2);
            }
        });
    }



    public interface OnMidpointCalculateListener{
        void calculateMidpoint(Point pointOne, Point pointTwo);
    }

    //happens when the fragment is associated with an activity
    // This makes sure that the container activity has implemented
    // the callback interface. If not, it throws an exception
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            listener = (OnMidpointCalculateListener) context;
        }
        catch(ClassCastException e){
            throw new ClassCastException(context.toString() + " must implement OnMidpointCalculateListener");
        }
    }

}
