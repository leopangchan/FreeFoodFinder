package controllers;

import play.mvc.*;

import views.html.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class ReportController extends Controller {

    public Result create(long eventid)
    {
	return notFound();
    }
}
