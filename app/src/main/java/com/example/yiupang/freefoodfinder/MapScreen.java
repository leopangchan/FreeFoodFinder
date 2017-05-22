package com.example.yiupang.freefoodfinder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by yiupang on 5/6/2017.
 *
 *
 */

public class MapScreen extends android.support.v4.app.Fragment implements OnMapReadyCallback
{
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.map_screen, container, false);
        android.support.v4.app.FragmentManager fragmentManager = getChildFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment) fragmentManager.findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return view;
    }

    //CODE SMELL: remove comment block
    /*    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_screen);
    }*/

    @Override
    public void onMapReady(GoogleMap map)
    {
        // Add a marker in Sydney and move the camera
        LatLng slo = new LatLng(35.2827778, -120.6586111);
        LatLng sf = new LatLng(37.774929, -122.419416);
        LatLng theP = new LatLng(35.302833, -120.651662);
        map.addMarker(new MarkerOptions().position(slo).title("Downtown").snippet("Downtownd of slo"));
        map.addMarker(new MarkerOptions().position(theP).title("The P").snippet("The “P” is a 50-by-30 foot landmark located atop a northwestern hill of California Polytechnic State University, San Luis Obispo, California."));
        map.addMarker(new MarkerOptions().position(sf).title("Marker in sf").snippet("Golden Gate Bridge"));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(slo, 12.0f));
    }
}
