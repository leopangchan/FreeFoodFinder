package com.example.yiupang.freefoodfinder;

import android.os.Bundle;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;

public class EventDetailsScreen extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details_screen);

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

    }
}
