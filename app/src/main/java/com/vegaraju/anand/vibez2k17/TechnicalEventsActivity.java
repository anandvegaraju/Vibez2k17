package com.vegaraju.anand.vibez2k17;

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
    Button counterstrike, thunt, debugging, pands, coding, caedm, minimilitia, cktdbg, pianofiles;
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
        thunt = (Button)findViewById(R.id.bestmanager);
        debugging = (Button)findViewById(R.id.debuggingbutton);
        pands = (Button)findViewById(R.id.wtfisthisbutton);
        coding = (Button)findViewById(R.id.codingbutton);
        caedm = (Button)findViewById(R.id.caed);
        minimilitia = (Button)findViewById(R.id.minimilitia);
        cktdbg = (Button)findViewById(R.id.cktdbg);
        pianofiles = (Button)findViewById(R.id.pianofiles);
    }

    public void OnClick(View view){
        Button button = (Button)findViewById(view.getId());
        viewname = button.getText().toString();
        Intent gotoevent = new Intent(TechnicalEventsActivity.this,EventTemplateActivity.class);
        gotoevent.putExtra("phonenumber",phonenumber);
        gotoevent.putExtra("eventnamee",viewname);
        if (viewname.equalsIgnoreCase("Counter Strike")) {
            gotoevent.putExtra("details","Counter strike 1.6 with team of 4");
            gotoevent.putExtra("timings","10am 28th april 2017");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.\n3. Five per team\n4. No cheats or hacks");
            gotoevent.putExtra("fee","Entry fee : Rs 50 per member\n First place : NA\nSecond place : NA");
            gotoevent.putExtra("eventname","counterstrike");
        }else if(viewname.equalsIgnoreCase("Best Manager")){
            gotoevent.putExtra("details","Conducted by MBA dept");
            gotoevent.putExtra("timings","10am 28th april 2017");
            gotoevent.putExtra("rules","1. Individual event\n2. Multiple participants from a college are allowed\n3. Report in your college uniform\n4. Judge's decision is final\n5. Any misbehaviour will lead to disqualification");
            gotoevent.putExtra("fee","Entry fee : Rs 300\n First place : Rs 2000\nSecond place : NA");
            gotoevent.putExtra("eventname","bestmanager");
        }else if(viewname.equalsIgnoreCase("NFS")){
            gotoevent.putExtra("details","Need for speed (LAN based multiplayer)");
            gotoevent.putExtra("timings","10am 28th april 2017");
            gotoevent.putExtra("rules","1. No Hacks\n2. Play fairly.");
            gotoevent.putExtra("fee","Entry fee : Rs 50 per head\n First place : NA\nSecond place : NA");
            gotoevent.putExtra("eventname","nfs");
        }else if(viewname.equalsIgnoreCase("Pick and Speak")){
            gotoevent.putExtra("details","Speak about a randomly chosen topic");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.");
            gotoevent.putExtra("fee","Entry fee : NA\n First place : NA\nSecond place : NA");
            gotoevent.putExtra("eventname","pickandspeak");
        }else if(viewname.equalsIgnoreCase("Coding")){
            gotoevent.putExtra("details","You know what it is");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.");
            gotoevent.putExtra("fee","Entry fee : NA\n First place : NA\nSecond place : NA");
            gotoevent.putExtra("eventname","coding");
        }else if(viewname.equalsIgnoreCase("CAED Modelling")){
            gotoevent.putExtra("details","You'll be asked to model 3d or 2d components.");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.");
            gotoevent.putExtra("fee","Entry fee : NA\n First place : NA\nSecond place : NA");
            gotoevent.putExtra("eventname","caedmodelling");
        }else if(viewname.equalsIgnoreCase("Mini Militia")){
            gotoevent.putExtra("details","Mobile gaming.");
            gotoevent.putExtra("timings","10am 28th April 2017");
            gotoevent.putExtra("rules","1. No foul play\n2. No hacks.\n3. 4 per team");
            gotoevent.putExtra("fee","Entry fee : Rs 50 per head\n First place : TBD\nSecond place : TBD");
            gotoevent.putExtra("eventname","minimilitia");
        }else if(viewname.equalsIgnoreCase("Circuit Debugging")){
            gotoevent.putExtra("details","TBA");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. No mobile devices allowed.");
            gotoevent.putExtra("fee","Entry fee : NA\n First place : NA\nSecond place : NA");
            gotoevent.putExtra("eventname","cktdbg");
        }else if(viewname.equalsIgnoreCase("Piano Files")){
            gotoevent.putExtra("details","TBA");
            gotoevent.putExtra("timings","10am 28th April 2017");
            gotoevent.putExtra("rules","1. No foul play\n2. No mobile devices allowed.");
            gotoevent.putExtra("fee","Entry fee : Rs 50\n First place : NA\nSecond place : NA");
            gotoevent.putExtra("eventname","pianofiles");
        }
        startActivity(gotoevent);
    }
}
// 9731813442