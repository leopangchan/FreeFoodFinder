package com.example.yiupang.freefoodfinder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by bryanmcguffin on 5/25/17.
 */

/**
 * This class loads the details pertaining to some selected event.
 * That event is passed in either from the map or from the event list screen.
 */
public class EventDetailsScreen extends Fragment
{
    private Event e = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.event_details_screen, container, false);


        return view;
    }

    /**
     * Call this to give the details screen a new event.
     *
     * @param evt The event to be displayed
     */
    public void captureNewEvent(Event evt)
    {
        e = evt;
    }
}
