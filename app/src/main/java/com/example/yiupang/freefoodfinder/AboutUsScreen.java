package com.example.yiupang.freefoodfinder;

import android.content.res.Configuration;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.Gravity;
import android.widget.Toast;

import java.util.Calendar;
import android.view.Window;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;


import android.view.WindowManager;
import android.view.Window;

/**
 * Created by yiupang on 5/6/2017.
 *
 */

public class AboutUsScreen extends android.support.v4.app.Fragment
{


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        Element adsElement = new Element();
        adsElement.setTitle("Advertise with us");

        View aboutPage = new AboutPage(getContext())
                .setDescription(" Free Food Finder is the easiest way" +
                        " to locate events serving free food wherever you may be." +
                        " FreeFood Finder enables you to easily find club meetings," +
                        " company recruiting sessions, and campus events near your current location." +
                        " Simply select an event to get all deets.")
                .isRTL(false)
                //.setImage(R.drawable.dummy_image2)
                .addGroup("Connect with us")
                .addEmail("contact@freefoodfinder.com")
                .addWebsite("freefoodfinder.io")
                .addFacebook("zuck")
                .addTwitter("latimesfood")
                .addYoutube("foodwishes")
                .addPlayStore("com.ideashower.readitlater.pro")
                .addInstagram("tastemade")
                .addGitHub("leopangchan/FreeFoodFinder")
                .addItem(new Element().setTitle("Version 1.10"))
                .addItem(adsElement)
                .addItem(getCopyRightsElement())
                .create();

        return aboutPage;

    }

    Element getCopyRightsElement() {
        Element copyRightsElement = new Element();
        final String copyrights = String.format(getString(R.string.copy_right), Calendar.getInstance().get(Calendar.YEAR));
        copyRightsElement.setTitle(copyrights);
        //copyRightsElement.setIconDrawable(R.drawable.about_icon_copy_right);
        copyRightsElement.setIconTint(mehdi.sakout.aboutpage.R.color.about_item_icon_color);
        copyRightsElement.setIconNightTint(android.R.color.white);
        copyRightsElement.setGravity(Gravity.CENTER);
        copyRightsElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), copyrights, Toast.LENGTH_SHORT).show();
            }
        });
        return copyRightsElement;
    }


}

