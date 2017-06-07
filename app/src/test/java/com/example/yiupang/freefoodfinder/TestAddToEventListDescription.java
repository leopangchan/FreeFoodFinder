package com.example.yiupang.freefoodfinder;

/**
 * Created by Fernando on 6/6/17.
 */

import junit.framework.Assert;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class TestAddToEventListDescription
{

    @Test
    public void addToEventListDescriptionTest() {
        ArrayList<Event> myEventsArray = new ArrayList<Event>();

        Event google = new Event("Google Networking Session", "A Pizza",
                "We're hiring");
        google.setPlace("14");
        google.setDate("2017-06-21");
        google.setDescription("Come find out how to be a googler!");

        myEventsArray.add(google);

        String expected = "Come find out how to be a googler!";
        String actual = myEventsArray.get(0).getDescription();

        Assert.assertEquals(expected, actual);
    }


}
