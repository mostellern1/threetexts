package com.example.threetexts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {
    private TextView textView;
    private String textCode, displayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        // Create intent to reveive incoming intent
        Intent receive = getIntent();
        // set textView to TextView element inside of ScrollView element
        textView = findViewById(R.id.scrollViewText);
        // get textCode string sent in intent
        textCode = receive.getStringExtra(MainActivity.EXTRA_MESSAGE);

        /*
            switch to handle incoming text code string
                case handles which value is present
                    sets displayText to corresponding text in res/strings.xml file
         */
        switch (textCode) {
            case "0":
                displayText = getResources().getString(R.string.textOne);
                break;
            case "1":
                displayText = getResources().getString(R.string.textTwo);
                break;
            case "2":
                displayText = getResources().getString(R.string.textThree);
                break;
        }

        // update TextView element to show text requested
        textView.setText(displayText);
    }

}
