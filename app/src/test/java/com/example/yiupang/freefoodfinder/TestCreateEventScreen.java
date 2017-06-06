package com.example.yiupang.freefoodfinder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Zachary Hatton on 6/6/2017.
 */

public class TestCreateEventScreen {
    @Test
    public void testPlace2Coordinates(){
        CreateEventScreen test = new CreateEventScreen();
        float[] expected = new float[]{35.305005f,-120.662494f};
        float[] result = test.place2Coordinates("unspecific");
        assertEquals(expected[0],result[0],0);
        assertEquals(expected[1],result[1],0);
    }
}
