package com.example.yiupang.freefoodfinder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by yiupang on 5/6/2017.
 *
 *
 */
public class MapScreen extends android.support.v4.app.Fragment implements OnMapReadyCallback
{
    ArrayList<Double> lats = new ArrayList<Double>();
    ArrayList<Double> lngs = new ArrayList<Double>();
    ArrayList<String> titles = new ArrayList<String>();
    ArrayList<String> descrips = new ArrayList<String>();
    GoogleMap map;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.map_screen, container, false);
        android.support.v4.app.FragmentManager fragmentManager = getChildFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment) fragmentManager.findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        HttpCall httpCall = new HttpCall();
        httpCall.setMethodType(HttpCall.GET);
        httpCall.setUrl("http://free-food-finder.herokuapp.com/events");

        new HttpRequest() {

            @Override
            public void onResponse(Object response, int code) {
                super.onResponse(response, code);
                if (code != HttpURLConnection.HTTP_OK) {
                    Log.d("ON RESPONSE ERROR", "HTTP ERR: NOT OK");
                } else {
                    ObjectMapper mapper = new ObjectMapper();
                    TypeFactory typeFactory = mapper.getTypeFactory();
                    List<Event> events = null;/*Parse to Event Objs*/
                    try {

                        events = mapper.reader(
                                typeFactory.constructCollectionType(List.class, Event.class)
                        ).readValue((JsonNode) response);

                        Log.d("EVENTS NUM", "Events #: " + events.size());

                        for(int i = 0; i < events.size(); i++)
                        {
                            dropPin(events, i);
                        }

                    } catch (IOException e) {
                        /*handle error*/
                        Log.d("size:  ", e + "");
                    }

                }
            }

        }.execute(httpCall);

        return view;
    }

    public void dropPin(List<Event> events, int i)
    {
        Event currEvent = events.get(i);

        double lat = currEvent.getLat();
        double lng = currEvent.getLng();
        String title = currEvent.getName();
        String desc = currEvent.getDescription();

        lats.add(lat);
        lngs.add(lng);
        titles.add(title);
        descrips.add(desc);

        LatLng currPos = new LatLng(lats.get(i), lngs.get(i));

        map.addMarker(new MarkerOptions().position(currPos).title(titles.get(i)).snippet(descrips.get(i)));

    }

    @Override
    public void onMapReady(GoogleMap map)
    {
        this.map = map;
        LatLng slo = new LatLng(35.2827778, -120.6586111);

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(slo, 12.0f));

        Log.d("LATS NUM", "Events #: " + lats.size());

    }
}
