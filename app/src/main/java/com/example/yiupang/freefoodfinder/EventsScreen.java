package com.example.yiupang.freefoodfinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//CODE SMELL: unused import
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.ListView;
import java.util.ArrayList;

//CODE SMELL: unised import
import java.lang.reflect.Array;

/**
 * Created by yiupang on 5/6/2017.
 *
 */

public class EventsScreen extends android.support.v4.app.Fragment
{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.events_screen, container, false);
        ArrayList<Event> dataArray = new ArrayList<>();
        dataArray.add(new Event("Free Food 1", "Pizza", "Come !!"));
        dataArray.add(new Event("Free Food 5", "GoodPizza", "Come Again!"));
        dataArray.add(new Event("Free Food 4", "NicePizza", "Come Again"));
        dataArray.add(new Event("Free Food 8", "SuperPizza", "Come Again!!"));

        EventArrayAdapter adapter = new EventArrayAdapter(view.getContext(), R.layout.events_list_item, dataArray);
        ListView listView = (ListView) view.findViewById(R.id.events_screen);
        listView.setAdapter(adapter);
        setItemListener(listView);
        return view;
    }

    public void setItemListener(ListView listView)
    {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AboutUsScreen es = new AboutUsScreen();
                getFragmentManager().beginTransaction().replace(R.id.frame, es).commit();
            }
        });
    }
}
