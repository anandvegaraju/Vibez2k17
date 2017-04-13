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

public class TechnicalEventsActivity extends AppCompatActivity {
    String phonenumber, viewname;
    Button counterstrike, caed, thunt, minimilitia, debugging, pands, coding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technical);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        Intent i = getIntent();
        phonenumber = i.getStringExtra("phonenumber");

        counterstrike = (Button)findViewById(R.id.volleyballinterbutton);
        caed = (Button)findViewById(R.id.caedmbutton);
        thunt = (Button)findViewById(R.id.treasurehuntbutton);
        minimilitia = (Button)findViewById(R.id.minimilitiabutton);
        debugging = (Button)findViewById(R.id.debuggingbutton);
        pands = (Button)findViewById(R.id.wtfisthisbutton);
        coding = (Button)findViewById(R.id.codingbutton);
    }

    public void OnClick(View view){
        Button button = (Button)findViewById(view.getId());
        viewname = button.getText().toString();
        Intent gotoevent = new Intent(TechnicalEventsActivity.this,EventTemplateActivity.class);
        gotoevent.putExtra("phonenumber",phonenumber);
        gotoevent.putExtra("eventnamee",viewname);
        if (viewname.equalsIgnoreCase("Counter Strike")) {
            gotoevent.putExtra("details","Counter strike 1.6 with team of 4");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.");
            gotoevent.putExtra("fee","Entry fee : Rs 500\n First place : Rs 3000\nSecond place : Rs 1500");
            gotoevent.putExtra("eventname","counterstrike");
        }else if(viewname.equalsIgnoreCase("CAED modelling")){
            gotoevent.putExtra("details","The traditional cricket format.");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.");
            gotoevent.putExtra("fee","Entry fee : Rs 500\n First place : Rs 3000\nSecond place : Rs 1500");
            gotoevent.putExtra("eventname","caedmodelling");
        }else if(viewname.equalsIgnoreCase("Treasure Hunt")){
            gotoevent.putExtra("details","Catch and throw ball over the net");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.");
            gotoevent.putExtra("fee","Entry fee : Rs 500\n First place : Rs 3000\nSecond place : Rs 1500");
            gotoevent.putExtra("eventname","treasurehunt");
        }else if(viewname.equalsIgnoreCase("Mini Militia")){
            gotoevent.putExtra("details","Android game - LAN based");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.");
            gotoevent.putExtra("fee","Entry fee : Rs 500\n First place : Rs 3000\nSecond place : Rs 1500");
            gotoevent.putExtra("eventname","minimilitia");
        }else if(viewname.equalsIgnoreCase("Debugging")){
            gotoevent.putExtra("details","Correct the obfuscated code.");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.");
            gotoevent.putExtra("fee","Entry fee : Rs 500\n First place : Rs 3000\nSecond place : Rs 1500");
            gotoevent.putExtra("eventname","debugging");
        }else if(viewname.equalsIgnoreCase("Pick and Speak")){
            gotoevent.putExtra("details","Speak about a randomly chosen topic");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.");
            gotoevent.putExtra("fee","Entry fee : Rs 500\n First place : Rs 3000\nSecond place : Rs 1500");
            gotoevent.putExtra("eventname","pickandspeak");
        }else if(viewname.equalsIgnoreCase("Coding")){
            gotoevent.putExtra("details","You know what it is");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.");
            gotoevent.putExtra("fee","Entry fee : Rs 500\n First place : Rs 3000\nSecond place : Rs 1500");
            gotoevent.putExtra("eventname","coding");
        }
        startActivity(gotoevent);
    }
}
