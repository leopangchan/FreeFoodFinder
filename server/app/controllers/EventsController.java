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

    @Transactional
    public Result get()
    {
		List<Event> res = JPA.em().createQuery("SELECT e from Event e", Event.class).getResultList();
		if (res == null || res.size() == 0)
		{
			return notFound();
		}
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
    	Event e0 = JPA.em().find(Event.class, id);
    	if (e0 == null)
    	{
    		return notFound("No event with id "+id);
    	}
    	e.eventId = id;
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
