package com.example.yiupang.freefoodfinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

/**
 * Created by yiupang on 5/6/2017.
 *
 */

public class EventsScreen extends Fragment
{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        final View view = inflater.inflate(R.layout.events_screen, container, false); /*Make it final so that the inner class can't change it*/

        /*Make a GET call to initialize the table*/
        HttpCall httpCall = new HttpCall();
        httpCall.setMethodType(HttpCall.GET);
        httpCall.setUrl("http://free-food-finder.herokuapp.com/events");
        new HttpRequest(){
            @Override
            public void onResponse(List<Event> response)
            {
                super.onResponse(response);
                ListView listView = (ListView) view.findViewById(R.id.events_screen);
                listView.setAdapter(new EventArrayAdapter(view.getContext(), R.layout.events_list_item, response));
                setItemListener(listView);
            }
        }.execute(httpCall);

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
