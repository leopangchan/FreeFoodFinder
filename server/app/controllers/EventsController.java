package controllers;

import play.mvc.*;
import play.libs.Json;

import views.html.*;

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

    public Result create()
    {
	return notFound();
    }

    public Result update(long id)
    {
	return notFound();
    }

    public Result delete(long id)
    {
	return notFound();
    }

}
