package com.example.yiupang.freefoodfinder;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.roughike.bottombar.BottomBar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarBadge;
import com.roughike.bottombar.OnMenuTabClickListener;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.LoginResult;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;

public class MainActivity extends ActionBarActivity
{
    BottomBar bottomBar;
    private TextView info;
    //private LoginButton loginButton;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
/*        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        info = (TextView) findViewById(R.id.info);
        loginButton = (LoginButton) findViewById(R.id.login_button);

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                info.setText("UserID:" + loginResult.getAccessToken().getUserId() + "\n" +
                "Auth Token" +
                loginResult.getAccessToken().getToken());
            }

            @Override
            public void onCancel() {
                info.setText("Login insuccessful");
            }

            @Override
            public void onError(FacebookException error) {
                info.setText("Login insuccessful");
            }
        });*/
        setContentView(R.layout.activity_main);
        bottomBar = BottomBar.attach(this, savedInstanceState);
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

            }
        });

        bottomBar.mapColorForTab(0, "#ff0000");
        bottomBar.mapColorForTab(1, "#ff0000");
        bottomBar.mapColorForTab(2, "#ff0000");
        bottomBar.mapColorForTab(3, "#ff0000");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

/*
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
*/

        return super.onOptionsItemSelected(item);
    }
}
