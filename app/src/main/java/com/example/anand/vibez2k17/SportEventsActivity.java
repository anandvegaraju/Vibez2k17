package com.example.anand.vibez2k17;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Anand on 08-04-2017.
 */

public class SportEventsActivity extends AppCompatActivity {
    String phonenumber, viewname;
    Button shcricket, lcricket, tball, vball, kabaddi, bads, badd;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        Intent i = getIntent();
        phonenumber = i.getStringExtra("phonenumber");

        shcricket = (Button)findViewById(R.id.counterstrike);
        lcricket = (Button)findViewById(R.id.realcricketbutton);
        tball = (Button)findViewById(R.id.throwballbutton);
        vball = (Button)findViewById(R.id.volleyballbutton);
        kabaddi = (Button)findViewById(R.id.kabaddibutton);
        bads = (Button)findViewById(R.id.badmintonsinglebutton);
        badd = (Button)findViewById(R.id.badmintondoublebutton);
    }

    public void OnClick(View view){
        Button button = (Button)findViewById(view.getId());
        viewname = button.getText().toString();
        Intent gotoevent = new Intent(SportEventsActivity.this,EventTemplateActivity.class);
        gotoevent.putExtra("phonenumber",phonenumber);
        gotoevent.putExtra("eventname",viewname);
        startActivity(gotoevent);
    }
}
