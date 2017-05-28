package com.example.yiupang.freefoodfinder;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.ActionBarActivity;

//CODE SMELLS: following 4 imports are unused
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

//CODE SEMLL: unused import
import com.roughike.bottombar.BottomBarBadge;

public class MainActivity extends ActionBarActivity
{
    static final String RED = "ff0000";
    BottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        bottomBar = BottomBar.attach(this, savedInstanceState);
        //CODE SMELL: It's complicated
        bottomBar.setItemsFromMenu(R.menu.menu_main, new OnMenuTabClickListener()
        {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId)
            {
                if(menuItemId == R.id.BottomBarEvents)
                {
                    EventsScreen es = new EventsScreen();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, es).commit();
                }
                else if(menuItemId == R.id.BottomBarItemMap)
                {
                    MapScreen es = new MapScreen();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, es).commit();
                }
                else if(menuItemId == R.id.BottomBarItemMyEvent)
                {
                    MyEventScreen es = new MyEventScreen();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, es).commit();
                }
                else if(menuItemId == R.id.BottomBarItemAboutUs)
                {
                    AboutUsScreen es = new AboutUsScreen();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, es).commit();
                }
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
        getMenuInflater().inflate(R.menu.top_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //CODE SMELL AND BUG: useless assignment
        int id = item.getItemId();

        //CODE SMELL: remove comment block
        /*
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        */
        return super.onOptionsItemSelected(item);
    }
}
