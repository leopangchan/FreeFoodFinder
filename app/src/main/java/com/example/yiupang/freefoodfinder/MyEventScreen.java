package com.example.yiupang.freefoodfinder;

//CODE SMELL: unused import
import android.app.Fragment;

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

        ArrayList<Event> myEventsArray = new ArrayList();
        myEventsArray.add(new Event("Free Food 1", "Pizza", "Come !!"));
        myEventsArray.add(new Event("Free Food 5", "GodPizza", "Come Again !!"));
        myEventsArray.add(new Event("Free Food 4", "GodPizza", "Come Again !!"));
        myEventsArray.add(new Event("Free Food 8", "GodPizza", "Come Again !!"));

        EventArrayAdapter myEventsAdapter = new EventArrayAdapter(view.getContext(), R.layout.events_list_item, myEventsArray);
        ListView myEventsListView = (ListView) view.findViewById(R.id.myevents_list);
        myEventsListView.setAdapter(myEventsAdapter);
        setItemListener(myEventsListView);

        ArrayList<Event> favEventsArray = new ArrayList();
        favEventsArray.add(new Event("Free Food 2", "Pizza", "Come !!"));
        favEventsArray.add(new Event("Free Food 3", "BobPizza", "Come Again !!"));
        favEventsArray.add(new Event("Free Food 6", "BobPizza", "Come Again !!"));
        favEventsArray.add(new Event("Free Food 9", "BobPizza", "Come Again !!"));

        EventArrayAdapter adapter = new EventArrayAdapter(view.getContext(), R.layout.events_list_item, favEventsArray);
        ListView favEventsListView = (ListView) view.findViewById(R.id.favevents_list);
        favEventsListView.setAdapter(adapter);
        setItemListener(favEventsListView);

        final Button button = (Button) view.findViewById(R.id.create_event_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent details = new Intent(getContext(), CreateEventScreen1.class);
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
        Intent details = new Intent(getContext(), EventDetailsScreen1.class);

        details.putExtra("selectedEventName", selectedEvent.getName());
        details.putExtra("selectedEventTime", selectedEvent.getTime());
        details.putExtra("selectedEventPlace", selectedEvent.getPlace());
        details.putExtra("selectedEventDesc", selectedEvent.getDescription());
        details.putExtra("selectedEventFoodType", selectedEvent.getFoodType());

        startActivity(details);
    }
}
