package com.example.yiupang.freefoodfinder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;

import android.support.v7.app.AppCompatActivity;


public class EventDetailsScreen1 extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details_screen1);

       // Event selectedEvent = (Event)getIntent().getSerializableExtra("selectedEvent");

        String selectedEventName = (String)getIntent().getExtras().getSerializable("selectedEventName");
        String selectedEventTime = (String)getIntent().getExtras().getSerializable("selectedEventTime");
        String selectedEventPlace = (String)getIntent().getExtras().getSerializable("selectedEventPlace");
        String selectedEventDesc = (String)getIntent().getExtras().getSerializable("selectedEventDesc");
        String selectedEventFoodType = (String)getIntent().getExtras().getSerializable("selectedEventFoodType");


        TextView nameText = (TextView) findViewById(R.id.nameText);
        nameText.setText(selectedEventName);

        TextView timeText = (TextView) findViewById(R.id.timeText);
        timeText.setText(selectedEventTime);

        TextView placeText = (TextView) findViewById(R.id.placeText);
        placeText.setText(selectedEventPlace);

        TextView foodText = (TextView) findViewById(R.id.foodText);
        foodText.setText(selectedEventFoodType);

        TextView descText = (TextView) findViewById( R.id.descText);
        descText.setText(selectedEventDesc);



       /* Log.d("NAME", selectedEventName);
        Log.d("DESCRIPTION", selectedEventDesc);
        Log.d("FOODTYPE", selectedEventFoodType); */

    }
}
