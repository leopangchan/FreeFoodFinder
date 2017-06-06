package com.example.yiupang.freefoodfinder;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;

import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;


public class MainActivity extends AppCompatActivity
{
    private Fragment getSelectedFragement(int menuItemId)
    {
        if(menuItemId == R.id.BottomBarEvents)
            return new EventsScreen();
        else if(menuItemId == R.id.BottomBarItemMap)
            return new MapScreen();
        else if(menuItemId == R.id.BottomBarItemMyEvent)
            return new MyEventScreen();
        else
            return new AboutUsScreen();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        BottomBar bottomBar;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomBar = BottomBar.attach(this, savedInstanceState);

        bottomBar.setItemsFromMenu(R.menu.menu_main, new OnMenuTabClickListener()
        {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId)
            {
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.frame, getSelectedFragement(menuItemId)).commit();
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId)
            {
                //CODE SMELL: This method is empty
            }
        });

        bottomBar.mapColorForTab(0, Color.RED);
        bottomBar.mapColorForTab(1, Color.RED);
        bottomBar.mapColorForTab(2, Color.RED);
        bottomBar.mapColorForTab(3, Color.RED);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
