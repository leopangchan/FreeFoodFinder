package com.example.yiupang.freefoodfinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
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
        final View view = inflater.inflate(R.layout.myevent_screen, container, false);
        Event google = new Event("Google Networking Session", "A Pizza", "We're hiring");
        google.setPlace("Kennedy Library");
        google.setDate("2017-06-21");
        Event amazon = new Event("Amazon Networking Session", "Two Pizzas", "We're hiring!");
        amazon.setPlace("20");
        amazon.setDate("2017-06-22");
        Event microsoft = new Event("Microsoft Networking Session", "Three Pizzas", "We're hiring!!!");
        microsoft.setPlace("University Union");
        microsoft.setDate("2017-06-23");
        Event airbnb = new Event("Airbnb Techtalk", "Four Pizzas", "We are hiring");
        airbnb.setPlace("Kennedy Library");
        airbnb.setDate("2017-06-24");
        Event facebook = new Event("Facebook Networking Session", "Five Pizzas", "We are hiring!");
        facebook.setPlace("20");
        facebook.setDate("2017-06-25");

        ArrayList<Event> myEventsArray = new ArrayList<>();
        myEventsArray.add(google);
        myEventsArray.add(amazon);
        myEventsArray.add(microsoft);
        myEventsArray.add(airbnb);
        myEventsArray.add(facebook);

        EventArrayAdapter myEventsAdapter = new EventArrayAdapter(view.getContext(), R.layout.events_list_item, myEventsArray);
        ListView myEventsListView = (ListView) view.findViewById(R.id.myevents_list);
        myEventsListView.setAdapter(myEventsAdapter);
        setItemListener(myEventsListView);

        ArrayList<Event> favEventsArray = new ArrayList<>();
        favEventsArray.add(facebook);
        favEventsArray.add(airbnb);
        favEventsArray.add(microsoft);

        EventArrayAdapter adapter = new EventArrayAdapter(view.getContext(), R.layout.events_list_item, favEventsArray);
        ListView favEventsListView = (ListView) view.findViewById(R.id.favevents_list);
        favEventsListView.setAdapter(adapter);
        setItemListener(favEventsListView);

        final Button button = (Button) view.findViewById(R.id.create_event_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent details = new Intent(getContext(), CreateEventScreen.class);
                startActivity(details);
            }
        });

        return view;
    }

    private void setItemListener(final ListView listView)
    {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
            {
                Event selectedEvent = (Event) adapterView.getAdapter().getItem(position);
                startActivity(Utility.getDetail(selectedEvent, getContext()));
            }
        });
    }
}
