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
        Event google = new Event("Google Networking Session", "A Pizza", "We're hiring!!");
        google.setFoodType("Pizza");
        google.setPlace("14 Computer Science");
        google.setDate("2017-06-21");
        Event amazon = new Event("Amazon Networking Session", "Two Pizzas", "We're hiring!!");
        amazon.setFoodType("Pizza");
        amazon.setPlace("14 Computer Science");
        amazon.setDate("2017-06-22");
        Event microsoft = new Event("Microsoft Networking Session", "Three Pizzas", "We're hiring!!");
        microsoft.setFoodType("Pizza");
        microsoft.setPlace("14 Computer Science");
        microsoft.setDate("2017-06-22");
        Event airbnb = new Event("Airbnb Techtalk", "Three Pizzas", "We're hiring!!");
        airbnb.setFoodType("Pizza");
        airbnb.setPlace("14 Computer Science");
        airbnb.setDate("2017-06-22");
        Event facebook = new Event("Facebook Networking Session", "Four Pizzas", "We're hiring!!");
        facebook.setFoodType("Pizza");
        facebook.setPlace("14 Computer Science");
        facebook.setDate("2017-06-22");

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
                /* Intent details = new Intent(getContext(), EventDetailsScreen1.class);

                details.putExtra("selectedEventName", "name");
                details.putExtra("selectedEventTime", "time");
                details.putExtra("selectedEventPlace", "place");
                details.putExtra("selectedEventDesc", "desc");
                details.putExtra("selectedEventFoodType", "type"); */

                startActivity(details);
            }
        });

        return view;
    }

    public void setItemListener(final ListView listView)
    {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
            {
                Event selectedEvent = (Event) adapterView.getAdapter().getItem(position);

                switchActivity(selectedEvent);
            }
        });
    }

    public void switchActivity(Event selectedEvent)
    {
        Intent details = new Intent(getContext(), EventDetailsScreen.class);

        details.putExtra("selectedEventName", selectedEvent.getName());
        details.putExtra("selectedEventTime", selectedEvent.getTime());
        details.putExtra("selectedEventPlace", selectedEvent.getPlace());
        details.putExtra("selectedEventDesc", selectedEvent.getDescription());
        details.putExtra("selectedEventFoodType", selectedEvent.getFoodType());

        startActivity(details);
    }
}
