/*
    ThreeTexts developed by Noah Mosteller

    Copyright 2020

    This program displays 3 buttons on screen for a user to choose
    Each button leads to a different, predetermined text within res/string.xml
    Text is embedded within a ScrollView, allowing scrolling
    Back button included
 */
package com.example.threetexts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;

import com.example.threetexts.DisplayActivity;
import com.example.threetexts.R;

public class MainActivity extends AppCompatActivity {
    // Tag for debugging
    private static final String LOG_TAG_MAIN =
            MainActivity.class.getSimpleName();
    // Constant for intent type
    public static final String EXTRA_MESSAGE =
            "com.example.threetexts.extra.MESSAGE";

    // Variable for passing text code to DisplayActivity
    public String textCode = null;

    // Standard onCreate initialization
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchTextView(View view) {
        // Declaration of intent to DisplayActivity
        Intent passTextCode = new Intent(this, DisplayActivity.class);

        /*
            switch that gets the id of the button pressed
                case determines which button
                    adds to log for debugging
                    sets textCode to corresponding value
         */
        switch (view.getId()) {
            case R.id.textOne_button:
                Log.d(LOG_TAG_MAIN, "One Clicked");
                textCode = "0";
                break;
            case R.id.textTwo_button:
                Log.d(LOG_TAG_MAIN, "Two Clicked");
                textCode = "1";
                break;
            case R.id.textThree_button:
                Log.d(LOG_TAG_MAIN, "Three Clicked");
                textCode = "2";
                break;
        }
        // Insert text code into passTextCode intent, then send to activity
        passTextCode.putExtra(EXTRA_MESSAGE, textCode);
        startActivity(passTextCode);
    }
}