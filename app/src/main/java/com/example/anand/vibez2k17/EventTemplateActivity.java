package com.example.anand.vibez2k17;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


/**
 * Created by Anand on 08-04-2017.
 */

public class EventTemplateActivity extends AppCompatActivity {

    String phonenumber, eventnamewithspace;
    TextView detail_head;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_template);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        Intent fromeventlist = getIntent();
        phonenumber = fromeventlist.getStringExtra("phonenumber");
        eventnamewithspace = fromeventlist.getStringExtra("eventname");
        detail_head = (TextView)findViewById(R.id.eventdetailhead);
        detail_head.setText(eventnamewithspace + " details");

    }
}
