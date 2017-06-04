package com.example.yiupang.freefoodfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.support.v4.app.Fragment;

import java.security.AccessController;
import java.util.List;

public class CreateEventScreen1 extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event_screen1);
        // View view = inflater.inflate(R.layout.create_event, container, false);
        // View view = inflater.inflate(R.layout.activity_create_event_screen1, container, false);
        final Event newEvent = new Event();

        Button button = (Button) findViewById(R.id.button_create);
        final EditText titleEdit = (EditText) findViewById(R.id.titletext);
        final EditText dateEdit = (EditText) findViewById(R.id.datetext);
        final EditText timeEdit = (EditText) findViewById(R.id.timetext);
        final EditText placeEdit = (EditText) findViewById(R.id.placetext);
        final EditText foodEdit = (EditText) findViewById(R.id.foodtext);
        final EditText descEdit = (EditText) findViewById(R.id.descriptiontext);

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
                    public void onResponse(Object response, int code)
                    {
                        finishActivity(0);
                    }
                }.execute(httpr);

            }
        });
    }

}
