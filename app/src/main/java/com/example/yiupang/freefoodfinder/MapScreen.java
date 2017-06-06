package com.example.yiupang.freefoodfinder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by yiupang on 5/6/2017.
 *
 *
 */
public class MapScreen extends android.support.v4.app.Fragment implements OnMapReadyCallback
{
    ArrayList<Double> lats = new ArrayList<>();
    ArrayList<Double> lngs = new ArrayList<>();
    ArrayList<String> titles = new ArrayList<>();
    ArrayList<String> descrips = new ArrayList<>();
    HashMap<String, String> markerLocations = new HashMap<>();
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
                if (code != HttpURLConnection.HTTP_OK)
                {
                    Log.d("ON RESPONSE ERROR", "HTTP ERR: NOT OK");
                }
                else
                {
                    List<Event> events = Utility.parseFromJSONToEventObjs((JsonNode) response);
                    Log.d("EVENTS NUM", "Events #: " + events.size());
                    for(int i = 0; i < events.size(); i++)
                    {

                        dropPin(events, i);
                    }
                }
            }

        }.execute(httpCall);

        return view;
    }

    public void dropPin(List<Event> events, int i)
    {
        Event currEvent = events.get(i);

        double offset = 0.00005f;
        double lat = currEvent.getLat();
        double lng = currEvent.getLng();
        while(markerLocations.containsKey(lat + lng + ""))
        {
            lat += offset;
            lng += offset;
        }
        currEvent.setLat(lat);
        currEvent.setLng(lng);
        markerLocations.put(currEvent.getLat() + currEvent.getLng() + "", "");

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
