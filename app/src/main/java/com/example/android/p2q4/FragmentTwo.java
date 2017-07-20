package com.example.android.p2q4;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by USER on 11/6/2017.
 */

public class FragmentTwo extends Fragment {

    private EditText x_field, y_field;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle bundle = getArguments();
        Point midpoint = (Point) bundle.getSerializable(MainActivity.BUNDLE_MIDPOINT);

        x_field = (EditText) getView().findViewById(R.id.x_midpoint);
        y_field = (EditText) getView().findViewById(R.id.y_midpoint);
        x_field.setText(""+midpoint.returnX());
        y_field.setText(""+midpoint.returnY());

    }
}
