package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import controllers.EventsController;
import models.Event;
import play.libs.Json;
import play.test.Helpers;

public class EventControllerTester {
	EventsController controller;
	
	@Before
	public void init()
	{
		controller = new EventsController();
	}
	
	@Test
	public void testNoEvents()
	{
		assertEquals(404, controller.get().status());
	}
	
	@Test
	public void testEventDeserialization()
	{
		String name = "Free Pizza Knight", desc = "Board games and free pizza";
		float lat = 7f, lng = 0.3f;
		Event e = new Event();
		e.name = name;
		e.lat = lat;
		e.lng = lng;
		e.description = desc;
		int status = Helpers.invokeWithContext(
				Helpers.fakeRequest().bodyText(Json.toJson(e).asText()),
				controller::create
			).status();
		assertEquals(201, status);
		assertEquals(200, controller.get().status());
	}

}
