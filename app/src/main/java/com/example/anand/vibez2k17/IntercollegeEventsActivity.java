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

public class IntercollegeEventsActivity extends AppCompatActivity {
    String phonenumber, viewname;
    Button grpdanceinter, kabaddiinter, csinter, minimilitiainter, caedinter, ppinter, codinginter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intercollege);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        Intent i = getIntent();
        phonenumber = i.getStringExtra("phonenumber");

        grpdanceinter = (Button)findViewById(R.id.volleyballinterbutton);
        kabaddiinter = (Button)findViewById(R.id.kabaddintrabutton);
        csinter = (Button)findViewById(R.id.csintrabutton);
        minimilitiainter = (Button)findViewById(R.id.crappymilitiabutton);
        caedinter = (Button)findViewById(R.id.caedintrabutton);
        ppinter = (Button)findViewById(R.id.ppintrabutton);
        codinginter = (Button)findViewById(R.id.cdintrabutton);
    }

    public void OnClick(View view){
        Button button = (Button)findViewById(view.getId());
        viewname = button.getText().toString();
        Intent gotoevent = new Intent(IntercollegeEventsActivity.this,EventTemplateActivity.class);
        gotoevent.putExtra("phonenumber",phonenumber);
        gotoevent.putExtra("eventnamee",viewname);

        if (viewname.equalsIgnoreCase("Volleyball (Boys)")) {
            gotoevent.putExtra("details","Cricket with reduced overs and players.");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.");
            gotoevent.putExtra("fee","Entry fee : Rs 500\n First place : Rs 3000\nSecond place : Rs 1500");
            gotoevent.putExtra("eventname","volleyballinter");
        }else if(viewname.equalsIgnoreCase("Kabaddi (boys)")){
            gotoevent.putExtra("details","The traditional cricket format.");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.");
            gotoevent.putExtra("fee","Entry fee : Rs 500\n First place : Rs 3000\nSecond place : Rs 1500");
            gotoevent.putExtra("eventname","kabaddiinter");
        }else if(viewname.equalsIgnoreCase("Counter Strike")){
            gotoevent.putExtra("details","Catch and throw ball over the net");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.");
            gotoevent.putExtra("fee","Entry fee : Rs 500\n First place : Rs 3000\nSecond place : Rs 1500");
            gotoevent.putExtra("eventname","counterstrikeinter");
        }else if(viewname.equalsIgnoreCase("Mini Militia")){
            gotoevent.putExtra("details","Volleyball as we know it");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.");
            gotoevent.putExtra("fee","Entry fee : Rs 500\n First place : Rs 3000\nSecond place : Rs 1500");
            gotoevent.putExtra("eventname","minimilitiainter");
        }else if(viewname.equalsIgnoreCase("CAED Modelling")){
            gotoevent.putExtra("details","Kabaddi like we know");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.");
            gotoevent.putExtra("fee","Entry fee : Rs 500\n First place : Rs 3000\nSecond place : Rs 1500");
            gotoevent.putExtra("eventname","caedinter");
        }else if(viewname.equalsIgnoreCase("Paper Presentation")){
            gotoevent.putExtra("details","Solo badminton");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.");
            gotoevent.putExtra("fee","Entry fee : Rs 500\n First place : Rs 3000\nSecond place : Rs 1500");
            gotoevent.putExtra("eventname","paperpresentationinter");
        }else if(viewname.equalsIgnoreCase("Coding/Debugging")){
            gotoevent.putExtra("details","Badminton with 2 players in a side.");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.");
            gotoevent.putExtra("fee","Entry fee : Rs 500\n First place : Rs 3000\nSecond place : Rs 1500");
            gotoevent.putExtra("eventname","codinginter");
        }
        startActivity(gotoevent);
    }
}
