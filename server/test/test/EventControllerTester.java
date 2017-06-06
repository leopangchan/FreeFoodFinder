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
	    String name = "Free Pizza Knight";
	    String desc = "Board games and free pizza";
	    float lat = 7f;
	    float lng = 0.3f;
	    Event e = new Event();
	    e.setName(name);
	    e.setLat(lat);
	    e.setLng(lng);
	    e.setDescription(desc);
    	    rb.bodyJson(Json.toJson(e));
	    Result res = Helpers.route(rb);
	    assertEquals(201, res.status());
	   });
	}

}
