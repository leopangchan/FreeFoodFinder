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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Button;
import android.support.v4.app.Fragment;


import java.util.ArrayList;
import java.util.List;

public class CreateEventScreen extends Fragment{


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.create_event, container, false);
        final Event newEvent = new Event();

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

        Button button = (Button) view.findViewById(R.id.button_create);
        final EditText titleEdit = (EditText)view.findViewById(R.id.titletext);
        final EditText dateEdit = (EditText)view.findViewById(R.id.datetext);
        final EditText timeEdit = (EditText)view.findViewById(R.id.timetext);
        final EditText placeEdit = (EditText)view.findViewById(R.id.placetext);
        final EditText foodEdit = (EditText)view.findViewById(R.id.foodtext);
        final EditText descEdit = (EditText)view.findViewById(R.id.descriptiontext);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String title = titleEdit.getText().toString();
                String date = dateEdit.getText().toString();
                String time = timeEdit.getText().toString();
                String place = placeEdit.getText().toString();
                String food = foodEdit.getText().toString();
                String desc = descEdit.getText().toString();

                newEvent.setName(title);
                //newEvent.setTime(null);
                newEvent.setPlace(place);
                //newEvent.setLatitude(0);
                //newEvent.setLongitude(0);
                newEvent.setDate(date);
                newEvent.setTime(time);
                newEvent.setFoodType(food);
                newEvent.setDescription(desc);

                HttpCall httpr = new HttpCall();
                httpr.setMethodType(HttpCall.PUT);
                httpr.setBody(newEvent);
                httpr.setUrl("https://free-food-finder.herokuapp.com/events");
                new HttpRequest(){
                    @Override
                    public void onResponse(List<Event> response)
                    {
                        Intent details = new Intent(getContext(), EventsScreen.class);
                        startActivity(details);
                    }
                }.execute(httpr);

            }
        });

        return view;
    }
}
