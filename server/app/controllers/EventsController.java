package controllers;

import play.db.jpa.Transactional;
import play.db.jpa.JPA;
import play.mvc.*;
import play.libs.Json;

import java.util.List;
import java.util.LinkedList;
import java.util.Date;

import models.Event;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class EventsController extends Controller {

    public Result get()
    {
	List<Event> res = new LinkedList<>();
	Event tmp = new Event();
	tmp.eventId = 1;
	tmp.userId = 1;
	tmp.name = "Hello World!";
	tmp.time = new Date();
	tmp.foodType = "BBQ";
	tmp.description = "Free BBQ here!";
	tmp.lat = 0;
	tmp.lng = 0;
	res.add(tmp);
	tmp = new Event();
	tmp.eventId = 2;
	tmp.userId = 1;
	tmp.name = "Free Pizza Knight";
	tmp.time = new Date();
	tmp.foodType = "Pizza";
	tmp.description = "Board games and Pizza!";
	tmp.lat = 0;
	tmp.lng = 0;
	res.add(tmp);
	tmp = new Event();
	tmp.eventId = 3;
	tmp.userId = 2;
	tmp.name = "Some other Event";
	tmp.time = new Date();
	tmp.foodType = "Other";
	tmp.description = "Really long\nDescription\nWith\nLots\nof\nnew\nlines. " +
	    "ThisIsAReallyUnrrealisticallyLongWordThatIAmUsingAsATestCase.";
	tmp.lat = 0;
	tmp.lng = 0;
	res.add(tmp);
	return ok(Json.toJson(res));
    }

    @Transactional
    public Result create()
    {
    	Event e = Json.fromJson(request().body().asJson(), Event.class);
    	e.eventId = 0;
		JPA.em().persist(e);
		return created(Json.toJson(e));
    }

    @Transactional
    public Result update(long id)
    {
    	Event e = Json.fromJson(request().body().asJson(), Event.class);
    	e.eventId = id;
    	if (!JPA.em().contains(e))
    	{
    		return notFound("No event with id "+id);
    	}
		JPA.em().merge(e);
		return ok(Json.toJson(e));
    }

    @Transactional
    public Result delete(long id)
    {
    	Event e = JPA.em().find(Event.class, id);
    	if (e == null)
    	{
    		return notFound("No event with id "+id);
    	}
		JPA.em().remove(e);
		return ok(Json.toJson(e));
    }

}
