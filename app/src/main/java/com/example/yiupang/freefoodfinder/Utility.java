package com.example.yiupang.freefoodfinder;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yiupang on 6/6/2017.
 *
 */

class Utility
{
    private Utility(){}
    static List<Event> parseFromJSONToEventObjs(JsonNode node)
    {
        ObjectMapper mapper = new ObjectMapper();
        TypeFactory typeFactory = mapper.getTypeFactory();
        try
        {
            return mapper.reader(
                    typeFactory.constructCollectionType(List.class, Event.class)
            ).readValue((JsonNode) node);
        }
        catch (IOException e)
        {
            Log.d("size:  ", e + "");
        }
        return new LinkedList<>();
    }

    static Intent getDetail(Event selectedEvent, Context context)
    {
        Intent details = new Intent(context, EventDetailsScreen.class);

        details.putExtra("selectedEventName", selectedEvent.getName());
        details.putExtra("selectedEventTime", selectedEvent.getTime());
        details.putExtra("selectedEventPlace", selectedEvent.getPlace());
        details.putExtra("selectedEventDesc", selectedEvent.getDescription());
        details.putExtra("selectedEventFoodType", selectedEvent.getFoodType());

        return details;
    }
}
