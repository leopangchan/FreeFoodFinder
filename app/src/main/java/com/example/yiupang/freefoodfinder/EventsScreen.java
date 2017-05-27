package com.example.yiupang.freefoodfinder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//CODE SMELL: unused import
import android.widget.AdapterView;

import android.widget.ListView;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

//CODE SMELL: unised import
import java.util.HashMap;
import java.util.List;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

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
