package com.example.yiupang.freefoodfinder;

import org.junit.Test;
import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * Created by barlebino on 6/6/17.
 */

public class TestAddToEventListFoodType {
    @Test
    public void addToEventListFoodTypeTest() {
        ArrayList<Event> myEventsArray = new ArrayList<Event>();

        Event google = new Event("Google Networking Session", "A Pizza",
                "We're hiring");
        google.setPlace("14");
        google.setDate("2017-06-21");

        myEventsArray.add(google);

        String expected = "A pizza";
        String actual = myEventsArray.get(0).getFoodType();

        assertEquals(expected, actual);
    }
}
