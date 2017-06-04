package com.example.yiupang.freefoodfinder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
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

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.map_screen, container, false);
        android.support.v4.app.FragmentManager fragmentManager = getChildFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment) fragmentManager.findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //
        HttpCall httpCall = new HttpCall();
        httpCall.setMethodType(HttpCall.GET);
        httpCall.setUrl("http://free-food-finder.herokuapp.com/events");

        new HttpRequest() {

            @Override
            public void onResponse(Object response, int code) {
                super.onResponse(response, code);
                if (code != HttpURLConnection.HTTP_OK) {
                    /* Error Handling */
                } else {
                    ObjectMapper mapper = new ObjectMapper();
                    TypeFactory typeFactory = mapper.getTypeFactory();
                    List<Event> events = null;/*Parse to Event Objs*/
                    try {

                        events = mapper.reader(
                                typeFactory.constructCollectionType(List.class, Event.class)
                        ).readValue((JsonNode) response);

                        for(int i = 0; i < events.size(); i++)
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

    @Override
    public void onMapReady(GoogleMap map)
    {

        /*

        // Add a marker in Sydney and move the camera
        LatLng slo = new LatLng(35.2827778, -120.6586111);
        LatLng sf = new LatLng(37.774929, -122.419416);
        LatLng theP = new LatLng(35.302833, -120.651662);
        map.addMarker(new MarkerOptions().position(slo).title("Downtown").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)).snippet("Downtown of slo"));
        map.addMarker(new MarkerOptions().position(theP).title("The P").snippet("The “P” is a 50-by-30 foot landmark located atop a northwestern hill of California Polytechnic State University, San Luis Obispo, California."));
        map.addMarker(new MarkerOptions().position(sf).title("Marker in sf").snippet("Golden Gate Bridge"));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(slo, 12.0f));

        */

        for(int i = 0; i < lats.size(); i++)
        {
            LatLng currPos = new LatLng(lats.get(i), lngs.get(i));

            map.addMarker(new MarkerOptions().position(currPos).title(titles.get(i)).snippet(descrips.get(i)));

        }
    }
}
