package com.example.yiupang.freefoodfinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class CreateEventScreen extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event_screen);
        final Event newEvent = new Event();

        Button button = (Button) findViewById(R.id.button_create);

        final List<EditText> edits = new ArrayList<>();
        final EditText titleEdit = (EditText) findViewById(R.id.creatortext);
        final EditText dateEdit = (EditText) findViewById(R.id.datetext);
        final EditText timeEdit = (EditText) findViewById(R.id.timetext);
        final EditText placeEdit = (EditText) findViewById(R.id.placetext);
        final EditText foodEdit = (EditText) findViewById(R.id.foodtext);
        final EditText descEdit = (EditText) findViewById(R.id.descriptiontext);
        edits.add(titleEdit);
        edits.add(dateEdit);
        edits.add(timeEdit);
        edits.add(placeEdit);
        edits.add(foodEdit);
        edits.add(descEdit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                makeEdits(newEvent,edits);

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

    public void makeEdits(Event e,List<EditText> edits){
        String title = edits.get(0).getText().toString();
        String date = edits.get(1).getText().toString();
        String time = edits.get(2).getText().toString();
        String place = edits.get(3).getText().toString();
        String food = edits.get(4).getText().toString();
        String desc = edits.get(5).getText().toString();

        e.setName(title);
        e.setPlace(place);
        float[] coordinates = place2Coordinates(place);
        e.setLat(coordinates[0]);
        e.setLng(coordinates[1]);
        e.setDate(date);
        e.setTime(time);
        e.setFoodType(food);
        e.setDescription(desc);
    }
    public float[] place2Coordinates(String place){
        float[] coords;

        switch(place){
            case "KennedyLibrary":
            case "35": coords = new float[]{35.30187f, -120.663861f};
                break;
            case "Computer Science Building":
            case "14": coords = new float[]{35.299895f,-120.662144f};
                break;
            case "Engineering East":
            case "20": coords = new float[]{35.300576f, -120.661726f};
                break;
            case "Science":
            case "52": coords = new float[]{35.300571f, -120.660192f};
                break;
            case "Engineering West":
            case "21": coords = new float[]{35.300066f, -120.663209f};
                break;
            default: coords = new float[]{35.305005f,-120.662494f};
        }
        return coords;
    }

}
