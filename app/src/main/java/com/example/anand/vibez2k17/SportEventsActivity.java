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

        shcricket = (Button)findViewById(R.id.volleyballinterbutton);
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
        gotoevent.putExtra("eventnamee",viewname);
        //
        if (viewname.equalsIgnoreCase("Short Cricket")) {
            gotoevent.putExtra("details","Cricket with reduced overs and players. ");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.\n3. 7+3 team members");
            gotoevent.putExtra("fee","Entry fee : NA\n First place : NA\nSecond place : NA");
            gotoevent.putExtra("eventname","shortcricket");
        }else if(viewname.equalsIgnoreCase("Long cricket")){
            gotoevent.putExtra("details","The traditional cricket format.");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.");
            gotoevent.putExtra("fee","Entry fee : NA\n First place : NA\nSecond place : NA");
            gotoevent.putExtra("eventname","longcricket");
        }else if(viewname.equalsIgnoreCase("Throwball")){
            gotoevent.putExtra("details","Catch and throw ball over the net");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.\n3. 6+3 team members");
            gotoevent.putExtra("fee","Entry fee : NA\n First place : NA\nSecond place : NA");
            gotoevent.putExtra("eventname","throwball");
        }else if(viewname.equalsIgnoreCase("Volleyball")){
            gotoevent.putExtra("details","Volleyball as we know it");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.\n3. 6+3 team members");
            gotoevent.putExtra("fee","Entry fee : NA\n First place : NA\nSecond place : NA");
            gotoevent.putExtra("eventname","volleyball");
        }else if(viewname.equalsIgnoreCase("Kabbadi")){
            gotoevent.putExtra("details","Kabaddi like we know");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.\n3. 7+3 team members");
            gotoevent.putExtra("fee","Entry fee : NA\n First place : NA\nSecond place : NA");
            gotoevent.putExtra("eventname","kabaddi");
        }else if(viewname.equalsIgnoreCase("Carrom doubles")){
            gotoevent.putExtra("details","Carrom (girls)");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.");
            gotoevent.putExtra("fee","Entry fee : NA\n First place : NA\nSecond place : NA");
            gotoevent.putExtra("eventname","carrom");
        }else if(viewname.equalsIgnoreCase("Badminton doubles")){
            gotoevent.putExtra("details","Badminton with 2 players in a side.\n(girls only)");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.");
            gotoevent.putExtra("fee","Entry fee : NA\n First place : NA\nSecond place : NA");
            gotoevent.putExtra("eventname","badmintondoubles");
        }

        startActivity(gotoevent);
    }
}
