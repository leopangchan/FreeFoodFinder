package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;

import models.Event;
import play.libs.Json;

public class EventTester {
	
	public Event makeEvent(String name, String desc, double lat, double lng)
	{
	    Event e = new Event();
	    e.setName(name);
	    e.setLat(lat);
	    e.setLng(lng);
	    e.setDescription(desc);
	    return e;
	}
	
	@Test
	public void testEventSerialization()
	{
	    String name = "Free Pizza Knight";
	    String desc = "Board games and free pizza";
	    float lat = 7f;
	    float lng = 0.3f;
	    JsonNode jn = Json.toJson(makeEvent(name, desc, lat, lng));
	    assertEquals(lat, jn.get("lat").floatValue(), 0.00001);
	    assertEquals(lng, jn.get("lng").floatValue(), 0.00001);
	    assertEquals(name, jn.get("name").textValue());
	    assertEquals(desc, jn.get("description").textValue());
	}
	
	@Test
	public void testEventDeserialization()
	{
	    String name = "Other Food Event";
	    String desc = "Come get free food!";
	    float lat = 73f;
	    float lng = -120.3f;
	    JsonNode jn = Json.toJson(makeEvent(name, desc, lat, lng));
	    Event e2 = Json.fromJson(jn, Event.class);
	    assertEquals(lat, e2.getLat(), 0.00001);
	    assertEquals(lng, e2.getLng(), 0.00001);
	    assertEquals(name, e2.getName());
	    assertEquals(desc, e2.getDescription());
	}
}
