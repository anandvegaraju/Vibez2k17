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

public class CulturalEventsActivity extends AppCompatActivity {
    String phonenumber, viewname;
    Button grpdance, solodance, grpsong, solosong, madads, fashionshow, dumbfuck, shortfilm, photography, beatboxing, mimcry, pencilsketch;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cultural);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        Intent i = getIntent();
        phonenumber = i.getStringExtra("phonenumber");

        //link the button objects

        grpdance = (Button)findViewById(R.id.volleyballinterbutton);
        solodance = (Button)findViewById(R.id.solodancebutton);
        grpsong = (Button)findViewById(R.id.groupsongbutton);
        solosong = (Button)findViewById(R.id.solosongbutton);
        madads = (Button)findViewById(R.id.retardedshowbutton);
        fashionshow = (Button)findViewById(R.id.fashionshowbutton);
        dumbfuck = (Button)findViewById(R.id.dumbfucksbutton);
        shortfilm = (Button)findViewById(R.id.terriblefilmsbutton);
        photography = (Button)findViewById(R.id.photographybutton);
        beatboxing = (Button)findViewById(R.id.shitboxingbutton);
        mimcry = (Button)findViewById(R.id.lessiqshowbutton);
        pencilsketch = (Button)findViewById(R.id.pencilsketchbutton);


    }

    public void OnClick(View view){
        Button button = (Button)findViewById(view.getId());
        viewname = button.getText().toString();
        Intent gotoevent = new Intent(CulturalEventsActivity.this,EventTemplateActivity.class);
        gotoevent.putExtra("phonenumber",phonenumber);
        gotoevent.putExtra("eventnamee",viewname);
        //
        if (viewname.equalsIgnoreCase("Group Dance")) {
            gotoevent.putExtra("details","Cricket with reduced overs and players.");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.");
            gotoevent.putExtra("fee","Entry fee : Rs 500\n First place : Rs 3000\nSecond place : Rs 1500");
            gotoevent.putExtra("eventname","groupdance");
        }else if(viewname.equalsIgnoreCase("Solo Dance")){
            gotoevent.putExtra("details","The traditional cricket format.");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.");
            gotoevent.putExtra("fee","Entry fee : Rs 500\n First place : Rs 3000\nSecond place : Rs 1500");
            gotoevent.putExtra("eventname","solodance");
        }else if(viewname.equalsIgnoreCase("Group Song")){
            gotoevent.putExtra("details","Catch and throw ball over the net");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.");
            gotoevent.putExtra("fee","Entry fee : Rs 500\n First place : Rs 3000\nSecond place : Rs 1500");
            gotoevent.putExtra("eventname","groupsong");
        }else if(viewname.equalsIgnoreCase("Solo Song")){
            gotoevent.putExtra("details","Volleyball as we know it");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.");
            gotoevent.putExtra("fee","Entry fee : Rs 500\n First place : Rs 3000\nSecond place : Rs 1500");
            gotoevent.putExtra("eventname","solosong");
        }else if(viewname.equalsIgnoreCase("MADADS")){
            gotoevent.putExtra("details","Kabaddi like we know");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.");
            gotoevent.putExtra("fee","Entry fee : Rs 500\n First place : Rs 3000\nSecond place : Rs 1500");
            gotoevent.putExtra("eventname","madads");
        }else if(viewname.equalsIgnoreCase("Fashion show")){
            gotoevent.putExtra("details","Solo badminton");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.");
            gotoevent.putExtra("fee","Entry fee : Rs 500\n First place : Rs 3000\nSecond place : Rs 1500");
            gotoevent.putExtra("eventname","fashionshow");
        }else if(viewname.equalsIgnoreCase("Dumb Charades")){
            gotoevent.putExtra("details","Badminton with 2 players in a side.");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.");
            gotoevent.putExtra("fee","Entry fee : Rs 500\n First place : Rs 3000\nSecond place : Rs 1500");
            gotoevent.putExtra("eventname","dumbcharades");
        }else if(viewname.equalsIgnoreCase("Short Film")){
            gotoevent.putExtra("details","Badminton with 2 players in a side.");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.");
            gotoevent.putExtra("fee","Entry fee : Rs 500\n First place : Rs 3000\nSecond place : Rs 1500");
            gotoevent.putExtra("eventname","shortfilm");
        }else if(viewname.equalsIgnoreCase("Photography")){
            gotoevent.putExtra("details","Badminton with 2 players in a side.");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.");
            gotoevent.putExtra("fee","Entry fee : Rs 500\n First place : Rs 3000\nSecond place : Rs 1500");
            gotoevent.putExtra("eventname","photography");
        }else if(viewname.equalsIgnoreCase("Beat Boxing")){
            gotoevent.putExtra("details","Badminton with 2 players in a side.");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.");
            gotoevent.putExtra("fee","Entry fee : Rs 500\n First place : Rs 3000\nSecond place : Rs 1500");
            gotoevent.putExtra("eventname","beatboxing");
        }else if(viewname.equalsIgnoreCase("Mimic Show")){
            gotoevent.putExtra("details","Badminton with 2 players in a side.");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.");
            gotoevent.putExtra("fee","Entry fee : Rs 500\n First place : Rs 3000\nSecond place : Rs 1500");
            gotoevent.putExtra("eventname","mimicry");
        }else if(viewname.equalsIgnoreCase("Pencil Sketch")){
            gotoevent.putExtra("details","Badminton with 2 players in a side.");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.");
            gotoevent.putExtra("fee","Entry fee : Rs 500\n First place : Rs 3000\nSecond place : Rs 1500");
            gotoevent.putExtra("eventname","pencilsketch");
        }


        startActivity(gotoevent);
    }


}
