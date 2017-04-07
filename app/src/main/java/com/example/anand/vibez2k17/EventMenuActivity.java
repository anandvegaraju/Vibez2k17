package com.example.anand.vibez2k17;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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

        culturalbutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent gotocultural = new Intent(EventMenuActivity.this,CulturalEventsActivity.class);
                        gotocultural.putExtra("phonenumber",phonenumber);
                        startActivity(gotocultural);
                    }
                }
        );

        technicalbutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent gototechnical = new Intent(EventMenuActivity.this,TechnicalEventsActivity.class);
                        gototechnical.putExtra("phonenumber",phonenumber);
                        startActivity(gototechnical);
                    }
                }
        );

        intercolgbutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent gotointercolg = new Intent(EventMenuActivity.this,IntercollegeEventsActivity.class);
                        gotointercolg.putExtra("phonenumber",phonenumber);
                        startActivity(gotointercolg);
                    }
                }
        );

        sportsbutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent gotosports = new Intent(EventMenuActivity.this,SportEventsActivity.class);
                        gotosports.putExtra("phonenumber",phonenumber);
                    }
                }
        );






    }
}
