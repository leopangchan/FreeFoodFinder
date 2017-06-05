package com.example.yiupang.freefoodfinder;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
/**
 * Created by yiupang on 6/1/2017.
 *
 */
public class TestHttpRequest
{
    private EventsScreen eventsScreen;

    @Mock
    private HttpRequest httpRequest;

    @Captor
    private ArgumentCaptor<HttpRequest> httpRequestArgumentCaptor;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
        eventsScreen = new EventsScreen();
    }

    @Test
    public void testGetCall()
    {
        final String expected = "200";

        HttpCall httpCall = new HttpCall();
        httpCall.setMethodType(HttpCall.GET);
        httpCall.setUrl("http://free-food-finder.herokuapp.com/events");
        new HttpRequest(){
            @Override
            public void onResponse(Object response, int code)
            {
                super.onResponse(response, code);
                assertEquals(expected, Integer.toString(code));
            }
        }.execute(httpCall);
    }

    @Test
    public void testDoInBackground()
    {

    }
}
