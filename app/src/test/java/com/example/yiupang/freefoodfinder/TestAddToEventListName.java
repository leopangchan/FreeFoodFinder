package com.example.yiupang.freefoodfinder;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by barlebino on 6/6/17.
 */

public class TestAddToEventListName {
    @Test
    public void addToEventListNameTest() {
        ArrayList<Event> myEventsArray = new ArrayList<Event>();

        Event google = new Event("Google Networking Session", "A Pizza",
                "We're hiring");
        google.setPlace("14");
        google.setDate("2017-06-21");

        myEventsArray.add(google);

        String expected = "Google Networking Session";
        String actual = myEventsArray.get(0).getName();

        assertEquals(expected, actual);
    }
}
