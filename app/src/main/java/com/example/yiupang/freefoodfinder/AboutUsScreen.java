package com.example.yiupang.freefoodfinder;

//CODE SMELL: Unused import
import android.app.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yiupang on 5/6/2017.
 */

public class AboutUsScreen extends android.support.v4.app.Fragment
{
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.aboutus_screen, container, false);
    }
}
