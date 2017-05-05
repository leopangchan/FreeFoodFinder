package controllers;

import play.mvc.*;

import views.html.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class FavoriteController extends Controller {

    public Result get(long id)
    {
	return notFound();
    }

    public Result create(long userid, long eventid)
    {
	return notFound();
    }

    public Result delete(long userid, long eventid)
    {
	return notFound();
    }

}
