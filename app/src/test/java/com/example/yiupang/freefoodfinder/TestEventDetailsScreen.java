package com.example.yiupang.freefoodfinder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by bryanmcguffin on 6/6/17.
 */

public class TestEventDetailsScreen
{
    @Test
    public void testName()
    {
        EventDetailsScreen test = new EventDetailsScreen();
        test.selectedEventName = "hello";
        assertEquals(test.selectedEventName,test.selectedEventName);
    }

    @Test
    public void testMath()
    {
        EventDetailsScreen test = new EventDetailsScreen();
        assertEquals(0,test.success);
    }
}
