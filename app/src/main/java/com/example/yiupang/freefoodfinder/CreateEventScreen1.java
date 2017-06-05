package com.example.yiupang.freefoodfinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateEventScreen1 extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event_screen1);
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
                newEvent.setPlace(place);
                newEvent.setDate(date);
                newEvent.setTime(time);
                newEvent.setFoodType(food);
                newEvent.setDescription(desc);

                HttpCall httpr = new HttpCall();
                httpr.setMethodType(HttpCall.PUT);
                httpr.setBody(newEvent);
                httpr.setUrl("http://free-food-finder.herokuapp.com/events");
                new HttpRequest(){
                    @Override
                    public void onResponse(Object response, int code)
                    {
                        finish();
                    }
                }.execute(httpr);

            }
        });
    }

}
