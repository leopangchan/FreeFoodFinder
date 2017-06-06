package com.example.yiupang.freefoodfinder;

import android.util.Log;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by yiupang on 6/6/2017.
 *
 */

public class Utility
{
    public static List<Event> parseFromJSONToEventObjs(JsonNode node)
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
        return null;
    }

}
