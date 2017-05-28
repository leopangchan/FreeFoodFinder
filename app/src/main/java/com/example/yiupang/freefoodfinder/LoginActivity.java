package com.example.yiupang.freefoodfinder;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


public class LoginActivity extends AppCompatActivity
{

    private CallbackManager callbackManager;
    private TextView info;
    private LoginButton loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());

        AccessTokenTracker accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken newAccessToken) {
                updateWithToken(newAccessToken);
            }
        };

        updateWithToken(AccessToken.getCurrentAccessToken());


        callbackManager = CallbackManager.Factory.create();

        setContentView(R.layout.activity_login);
        info = (TextView)findViewById(R.id.info);
        loginButton = (LoginButton)findViewById(R.id.login_button);


        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult loginResult) {
                nextActivity();
            }

            @Override
            public void onCancel() {
                info.setText("Login attempt cancelled.");

            }

            @Override
            public void onError(FacebookException error) {
                info.setText("Login attempt failed.");

            }
        });


    }

    // Check token to determine if already logged in
    private void updateWithToken(AccessToken currentAccessToken) {

        if (currentAccessToken != null) {
            nextActivity();

        } else {
            return;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int responseCode, Intent intent) {
        //Facebook login
        callbackManager.onActivityResult(requestCode, responseCode, intent);

    }

    // Redirect to main activity
    private void nextActivity(){

        Intent main = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(main);
    }

}
