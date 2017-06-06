package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import models.Event;
import play.libs.Json;
import play.mvc.Http.RequestBuilder;
import play.mvc.Result;
import play.test.Helpers;
import play.test.WithApplication;

public class EventControllerTester extends WithApplication {
	
	@Test
	public void testNoEvents()
	{
       Helpers.running(Helpers.fakeApplication(Helpers.inMemoryDatabase()), () -> {
    	   int status = Helpers.route(Helpers.fakeRequest("GET", "/events")).status();
    	   assertEquals(404, status);
       });
	}
	
	@Test
	public void testEventDeserialization()
	{ 
       Helpers.running(Helpers.fakeApplication(Helpers.inMemoryDatabase()), () -> {
    	    RequestBuilder rb = Helpers.fakeRequest("PUT", "/events");
			String name = "Free Pizza Knight", desc = "Board games and free pizza";
			float lat = 7f, lng = 0.3f;
			Event e = new Event();
			e.name = name;
			e.lat = lat;
			e.lng = lng;
			e.description = desc;
    	    rb.bodyJson(Json.toJson(e));
    	   	Result res = Helpers.route(rb);
			assertEquals(201, res.status());
		});
	}

}
