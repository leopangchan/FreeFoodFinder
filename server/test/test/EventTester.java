package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;

import models.Event;
import play.libs.Json;

public class EventTester {
	@Test
	public void testEventSerialization()
	{
		String name = "Free Pizza Knight", desc = "Board games and free pizza";
		float lat = 7f, lng = 0.3f;
		Event e = new Event();
		e.name = name;
		e.lat = 7;
		e.lng = .3;
		e.description = desc;
		JsonNode jn = Json.toJson(e);
		assertEquals(lat, jn.get("lat").floatValue(), 0.00001);
		assertEquals(lng, jn.get("lng").floatValue(), 0.00001);
		assertEquals(name, jn.get("name").textValue());
		assertEquals(desc, jn.get("description").textValue());
	}
	
	@Test
	public void testEventDeserialization()
	{
		String name = "Free Pizza Knight", desc = "Board games and free pizza";
		float lat = 7f, lng = 0.3f;
		Event e = new Event();
		e.name = name;
		e.lat = 7;
		e.lng = .3;
		e.description = desc;
		JsonNode jn = Json.toJson(e);
		Event e2 = Json.fromJson(jn, Event.class);
		assertEquals(lat, e2.lat, 0.00001);
		assertEquals(lng, e2.lng, 0.00001);
		assertEquals(name, e2.name);
		assertEquals(desc, e2.description);
	}
}
