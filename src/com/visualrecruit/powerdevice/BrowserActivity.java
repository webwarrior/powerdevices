package com.visualrecruit.powerdevice;

import android.app.Activity;
import android.os.Bundle;
//import android.view.View;
import android.webkit.WebView;
//import android.widget.Button;
//import android.widget.EditText;
import android.content.Intent;

/**
 * Created by Shaun on 26/07/2014.
 */
public class BrowserActivity extends Activity{

    private WebView webview;
    private String _username;
    private String _password;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_browser_activity);

        Intent iin = getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            _username =(String) b.get("username");
            _password =(String) b.get("password");
        }
        else
        {

        }
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        webview = (WebView) findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        String theurl = "http://powerdevices.visualrecruit.net.au/PowerDevices/ListByLocation";
        theurl += "?username=" + _username + "&password=" + _password;
        webview.loadUrl(theurl);
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
