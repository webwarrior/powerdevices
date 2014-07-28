package com.visualrecruit.powerdevice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.SharedPreferences;

public class LoginActivity extends Activity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button okButton;
    private String userName;
    private String passWord;
    public static final String PREFS_NAME = "PowerDevices.dat";

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


    }

    @Override
    protected void onResume()
    {
        super.onResume();
        usernameEditText = (EditText) findViewById(R.id.user_name);
        passwordEditText = (EditText) findViewById(R.id.password);


        // Restore preferences
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        userName = settings.getString("username", "");
        passWord = settings.getString("password", "");

        if((userName != null) && (userName.length() >0 ) && (passWord != null) && (passWord.length() > 0))
        {
            Intent activity = new Intent(LoginActivity.this, BrowserActivity.class);
            activity.putExtra("username", userName);
            activity.putExtra("password", passWord);
            startActivity(activity);
        }



        okButton = (Button)findViewById(R.id.ok_buton);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity = new Intent(LoginActivity.this, BrowserActivity.class);
                //activity.putExtra(Intent.EXTRA_TEXT, "");

                // We need an Editor object to make preference changes.
                // All objects are from android.context.Context
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("username", usernameEditText.getText().toString());
                editor.putString("password", passwordEditText.getText().toString());
                editor.commit(); //this actuallly stores the details

                activity.putExtra("username", usernameEditText.getText().toString());
                activity.putExtra("password", passwordEditText.getText().toString());

                startActivity(activity);
            }
        });
    }

}
