package com.example.yiupang.freefoodfinder;

/**
 * Created by Fernando on 6/6/17.
 */

import junit.framework.Assert;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class TestAddToEventListPlace
{
    @Test
    public void addToEventListPlaceTest() {
        ArrayList<Event> myEventsArray = new ArrayList<Event>();

        Event google = new Event("Google Networking Session", "A Pizza",
                "We're hiring");
        google.setPlace("14");
        google.setDate("2017-06-21");

        myEventsArray.add(google);

        String expected = "14";
        String actual = myEventsArray.get(0).getPlace();

        Assert.assertEquals(expected, actual);
    }
}
