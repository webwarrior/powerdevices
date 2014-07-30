package com.visualrecruit.powerdevice;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Button;

/**
 * Created by Shaun on 26/07/2014.
 */
public class BrowserActivity extends Activity{

    private WebView webview;
    private String _username;
    private String _password;
    private Button okButton;
    private static final String PREFS_NAME = "PowerDevices.dat";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_browser_activity);
    }

    @Override
    protected void onResume()
    {
        super.onResume();

//        Intent iin = getIntent();
//        Bundle b = iin.getExtras();
//
//        if(b!=null)
//        {
//            _username =(String) b.get("username");
//            _password =(String) b.get("password");
//        }
//        else
//        {
//
//        }

        // Restore preferences
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        _username = settings.getString("username", "");
        _password = settings.getString("password", "");

        setTitle("Locatiions list");

        webview = (WebView) findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        String theurl = "http://powerdevices.visualrecruit.net.au/PowerDevices/ListByLocation";
        theurl += "?username=" + _username + "&password=" + _password;
        webview.loadUrl(theurl);

        okButton = (Button)findViewById(R.id.ok_buton);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity = new Intent(BrowserActivity.this, LoginActivity.class);

                // We need an Editor object to make preference changes.
                // All objects are from android.context.Context
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("username", "");
                editor.putString("password", "");

                // Commit the edits!
                editor.commit();

                startActivity(activity);
            }
        });


        //webview.loadUrl("http://google.com.au");
    }

//    public String getUsername() {
//        return _username;
//    }
//
//    public void setUsername(String username) {
//        _username = username;
//    }
//
//    public String getPassword() {
//        return _password;
//    }
//
//    public void setPassword(String password) {
//        _password = password;
//    }
}
