package com.example.anand.vibez2k17;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;

/**
 * Created by Anand on 07-04-2017.
 */

public class EventMenuActivity extends AppCompatActivity {
    ImageButton culturalbutton, technicalbutton, sportsbutton, intercolgbutton;
    String phonenumber;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventmenu_activity);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        Intent i = getIntent();
        phonenumber = i.getStringExtra("phonenumber");

        // link buttons with event categories

        culturalbutton = (ImageButton)findViewById(R.id.culturalcat_button);
        technicalbutton = (ImageButton)findViewById(R.id.tech_button);
        sportsbutton = (ImageButton)findViewById(R.id.sportscat_button);
        intercolgbutton = (ImageButton)findViewById(R.id.intercolg_button);






    }
}
