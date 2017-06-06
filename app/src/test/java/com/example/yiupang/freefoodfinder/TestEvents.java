package com.example.yiupang.freefoodfinder;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
/*
 * Written by Zachary Hatton
 */
public class TestEvents {
	@Test 
	public void testSetName(){
		Event test = new Event();
		boolean expected = false;
		boolean result = test.setName("?!?");
		assertEquals(expected,result);
	}
	
	@Test
	public void testSetFoodType(){
		Event test = new Event();
		boolean expected = true;
		boolean result = test.setName("Fruit");
		assertEquals(expected,result);
	}
}
