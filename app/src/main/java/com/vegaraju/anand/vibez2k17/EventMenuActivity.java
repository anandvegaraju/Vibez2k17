package com.vegaraju.anand.vibez2k17;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Anand on 07-04-2017.
 */

public class EventMenuActivity extends AppCompatActivity implements View.OnTouchListener {
    ImageButton culturalbutton, technicalbutton, sportsbutton;
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
        technicalbutton = (ImageButton)findViewById(R.id.gallerybutton);
        sportsbutton = (ImageButton)findViewById(R.id.sportscat_button);

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



        sportsbutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent gotosports = new Intent(EventMenuActivity.this,SportEventsActivity.class);
                        gotosports.putExtra("phonenumber",phonenumber);
                        startActivity(gotosports);
                    }
                }
        );


        culturalbutton.setOnTouchListener(this);
        technicalbutton.setOnTouchListener(this);
        sportsbutton.setOnTouchListener(this);









    }

    @Override
    public boolean onTouch(final View v, MotionEvent event) {
        v.setAlpha(0.5f);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                v.setAlpha(0.75f);

            }
        }, 600);
        return super.onTouchEvent(event);
    }
}
