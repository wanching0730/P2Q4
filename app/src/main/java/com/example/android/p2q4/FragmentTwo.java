package com.example.android.p2q4;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by USER on 11/6/2017.
 */

public class FragmentTwo extends android.app.Fragment {

    private EditText x_field, y_field;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_two, container, false);

        return view;
    }

    public void retrieveResult(Point midpoint){
        x_field = (EditText) getView().findViewById(R.id.x_midpoint);
        y_field = (EditText) getView().findViewById(R.id.y_midpoint);
        x_field.setText(""+midpoint.returnX());
        y_field.setText(""+midpoint.returnY());

    }
}
