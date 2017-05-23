package com.example.yiupang.freefoodfinder;

//CODE SMELL: unused import
import android.app.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by yiupang on 5/6/2017.
 *
 */

public class MyEventScreen extends android.support.v4.app.Fragment
{
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.myevent_screen, container, false);

        /* ArrayList<Event> myEventsArray = new ArrayList();
        myEventsArray.add(new Event("Free Food 1", "Pizza", "Come !!"));
        myEventsArray.add(new Event("Free Food 5", "GodPizza", "Come Again !!"));
        myEventsArray.add(new Event("Free Food 4", "GodPizza", "Come Again !!"));
        myEventsArray.add(new Event("Free Food 8", "GodPizza", "Come Again !!"));

        EventArrayAdapter myEventsAdapter = new EventArrayAdapter(view.getContext(), R.layout.events_list_item, myEventsArray);
        ListView myEventsListView = (ListView) view.findViewById(R.id.myevents_list);
        myEventsListView.setAdapter(myEventsAdapter);

        ArrayList<Event> favEventsArray = new ArrayList();
        favEventsArray.add(new Event("Free Food 2", "Pizza", "Come !!"));
        favEventsArray.add(new Event("Free Food 3", "BobPizza", "Come Again !!"));
        favEventsArray.add(new Event("Free Food 6", "BobPizza", "Come Again !!"));
        favEventsArray.add(new Event("Free Food 9", "BobPizza", "Come Again !!"));

        EventArrayAdapter adapter = new EventArrayAdapter(view.getContext(), R.layout.events_list_item, favEventsArray);
        ListView favEventsListView = (ListView) view.findViewById(R.id.favevents_list);
        favEventsListView.setAdapter(adapter); */

        return view;
    }
}
