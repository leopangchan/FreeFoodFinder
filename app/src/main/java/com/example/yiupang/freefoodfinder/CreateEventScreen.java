package com.example.yiupang.freefoodfinder;

/**
 * Created by Zachary Hatton on 5/26/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.support.v4.app.Fragment;


import java.util.ArrayList;

public class CreateEventScreen extends Fragment{


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.create_event, container, false);
        //Event newEvent = new Event();

        /* EditText editText = (EditText) view.findViewById(R.id.box1);
        editText.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                int i = 0;
                handled = true;
                return handled;
            }
        }); */

        //Button button = (Button) view.findViewById(R.id.button_create);
        //onClickListener(view);

        return view;
    }
}
