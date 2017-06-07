package com.example.yiupang.freefoodfinder;

/**
 * Created by Fernando on 6/6/17.
 */

import org.junit.Test;
import static junit.framework.Assert.assertEquals;

import java.util.ArrayList;


public class TestMapScreenForLoop
{
    @Test
    public void pinLocationTest()
    {
        ArrayList<Event> testEvents = new ArrayList<Event>();

        Event event1 = new Event();
        event1.setName("Event1");
        event1.setPlace("Kennedy Library");
        event1.setDescription("This is event1");
        event1.setLat(35.30187);
        event1.setLng(-120.663861);
        testEvents.add(event1);

        Event event2 = new Event();
        event1.setName("Event2");
        event1.setDescription("This is event2");
        event2.setPlace("Computer Science Building");
        event2.setLat(35.299895);
        event2.setLng(-120.662144);
        testEvents.add(event2);

        Event event3 = new Event();
        event1.setName("Event3");
        event1.setDescription("This is event3");
        event3.setPlace("Engineering East");
        event3.setLat(35.300576);
        event3.setLng(-120.661726);
        testEvents.add(event3);

        MapScreen ms = new MapScreen();

        ms.dropPin(testEvents);
        ArrayList<Double> lats = ms.lats;
        ArrayList<Double> lngs = ms.lngs;


        assertEquals(35.30187, lats.get(0));
        assertEquals(-120.663861, lngs.get(0));

        assertEquals(35.299895, lats.get(1));
        assertEquals(-120.662144, lngs.get(1));

        assertEquals(35.300576, lats.get(2));
        assertEquals(-120.661726, lngs.get(2));


    }

}
