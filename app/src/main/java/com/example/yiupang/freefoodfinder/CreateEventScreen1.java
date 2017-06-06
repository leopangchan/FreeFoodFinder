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
        //final EditText creatorEdit = (EditText) findViewById(R.id.creatortext);
        final EditText titleEdit = (EditText) findViewById(R.id.titletext);
        //final EditText dateEdit = (EditText) findViewById(R.id.datetext);
        //final EditText timeEdit = (EditText) findViewById(R.id.timetext);
        final EditText placeEdit = (EditText) findViewById(R.id.placetext);
        final EditText foodEdit = (EditText) findViewById(R.id.foodtext);
        final EditText descEdit = (EditText) findViewById(R.id.descriptiontext);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                //String creator = creatorEdit.getText().toString();
                String title = titleEdit.getText().toString();
                //String date = dateEdit.getText().toString();
                //String time = timeEdit.getText().toString();
                String place = placeEdit.getText().toString();
                String food = foodEdit.getText().toString();
                String desc = descEdit.getText().toString();

                newEvent.setName(title);
                newEvent.setPlace(place);
                float[] coordinates = place2Coordinates(place);
                newEvent.setLat(coordinates[0]);
                newEvent.setLng(coordinates[1]);
                //newEvent.setDate(date);
                //newEvent.setTime(time);
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

    public float[] place2Coordinates(String place){
        float[] coords = new float[2];

        if("KennedyLibrary".equals(place) || "35".equals(place)){
            coords[0] = 35.30187f;
            coords[1] = -120.663861f;
        }
        else if("Computer Science Building".equals(place) || "14".equals(place)){
            coords[0] = 35.299895f;
            coords[1] = -120.662144f;
        }
        else if("Engineering East".equals(place) || "20".equals(place)){
            coords[0] = 35.300576f;
            coords[1] = -120.661726f;
        }
        else if("Science".equals(place) || "52".equals(place)){
            coords[0] = 35.300571f;
            coords[1] = -120.660192f;
        }
        else if("Engineering West".equals(place) || "21".equals(place)){
            coords[0] = 35.300066f;
            coords[1] = -120.663209f;
        }
        else{
            coords[0] = 35.305005f;
            coords[1] = -120.662494f;
        }
        return coords;
    }

}
