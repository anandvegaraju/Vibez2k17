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

public class CulturalEventsActivity extends AppCompatActivity {
    String phonenumber, viewname;
    Button grpdance, solodance, grpsong, solosong, fusionsong, fashionshow, rangoli, shortfilm, photography, beatboxing, mehandi, pencilsketch, collage, facepainting, cookwofire;
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
        fusionsong = (Button)findViewById(R.id.fusionsong);
        fashionshow = (Button)findViewById(R.id.fashionshowbutton);
        rangoli = (Button)findViewById(R.id.rangolibutton);
        shortfilm = (Button)findViewById(R.id.terriblefilmsbutton);
        photography = (Button)findViewById(R.id.photographybutton);
        beatboxing = (Button)findViewById(R.id.shitboxingbutton);
        mehandi = (Button)findViewById(R.id.mehandi);
        pencilsketch = (Button)findViewById(R.id.pencilsketchbutton);
        collage = (Button)findViewById(R.id.collage);
        facepainting = (Button)findViewById(R.id.facepainting);
        cookwofire = (Button)findViewById(R.id.cooking);


    }

    public void OnClick(View view){
        Button button = (Button)findViewById(view.getId());
        viewname = button.getText().toString();
        Intent gotoevent = new Intent(CulturalEventsActivity.this,EventTemplateActivity.class);
        gotoevent.putExtra("phonenumber",phonenumber);
        gotoevent.putExtra("eventnamee",viewname);
        //
        if (viewname.equalsIgnoreCase("Group Dance")) {
            gotoevent.putExtra("details","Step up! Duration of performance should be 6 minutes.;)");
            gotoevent.putExtra("timings","5th May 2017");
            gotoevent.putExtra("rules","1. No foul play\n2. Max of 10 teammates\n 3. Carry 2 pendrives containing song to avoid issues\n 4. No Vulgarity\n4. Judgement based on several factors.");
            gotoevent.putExtra("fee","Entry fee : Rs 1000\n First place : Rs 10000\n");
            gotoevent.putExtra("eventname","groupdance");
        }else if(viewname.equalsIgnoreCase("Solo Dance")){
            gotoevent.putExtra("details","Showcase your awesome dance moves\n Dance duration is 5 minutes");
            gotoevent.putExtra("timings","5th May 2017");
            gotoevent.putExtra("rules","1. No foul play\n2. Max of 1 participant\n3. Carry 2 pendrives containing song to avoid issues\n4. Judgement based on several factors.");
            gotoevent.putExtra("fee","Entry fee : Rs 300\n First place : Rs 3000\n");
            gotoevent.putExtra("eventname","solodance");
        }else if(viewname.equalsIgnoreCase("Group Song")){
            gotoevent.putExtra("details","It's all about coordination!");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Max of 5 teammates.");
            gotoevent.putExtra("fee","Entry fee : TBA\n First place : TBA\nSecond place : TBA");
            gotoevent.putExtra("eventname","groupsong");
        }else if(viewname.equalsIgnoreCase("Solo Song")){
            gotoevent.putExtra("details","Showcase your talent");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Max of 1 participant.");
            gotoevent.putExtra("fee","Entry fee : TBA\n First place : TBA\nSecond place : TBA");
            gotoevent.putExtra("eventname","solosong");
        }else if(viewname.equalsIgnoreCase("Group song fusion")){
            gotoevent.putExtra("details","Karaoke");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Max of 8 teammates.");
            gotoevent.putExtra("fee","Entry fee : TBA\n First place : TBA\nSecond place : TBA");
            gotoevent.putExtra("eventname","fusionsong");
        }else if(viewname.equalsIgnoreCase("Fashion show")){
            gotoevent.putExtra("details","");
            gotoevent.putExtra("timings","Evening");
            gotoevent.putExtra("rules","1. No foul play\n2. Max of 12 teammates.");
            gotoevent.putExtra("fee","Entry fee : TBA\n First place : TBA\nSecond place : TBA");
            gotoevent.putExtra("eventname","fashionshow");
        }else if(viewname.equalsIgnoreCase("Rangoli")){
            gotoevent.putExtra("details","A colorful Indian artform");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Max of 2 teammates.");
            gotoevent.putExtra("fee","Entry fee : TBA\n First place : TBA\nSecond place : TBA");
            gotoevent.putExtra("eventname","rangoli");
        }else if(viewname.equalsIgnoreCase("Short Film")){
            gotoevent.putExtra("details","Awaken the talented filmmaker in you .");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Duration : 10+2\n3. No vulgarity or beeps");
            gotoevent.putExtra("fee","Entry fee : TBA\n First place : TBA\nSecond place : TBA");
            gotoevent.putExtra("eventname","shortfilm");
        }else if(viewname.equalsIgnoreCase("Photography")){
            gotoevent.putExtra("details","Capture the beauty of the world through lens.\nTopic will be given on spot");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Only one participant\n");
            gotoevent.putExtra("fee","Entry fee : TBA\n First place : TBA\nSecond place : TBA");
            gotoevent.putExtra("eventname","photography");
        }else if(viewname.equalsIgnoreCase("Beat Boxing")){
            gotoevent.putExtra("details","A form of vocal percussion primarily involving the art of mimicking\n drum machines using one's mouth, lips, tongue, and voice.");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Only one participant");
            gotoevent.putExtra("fee","Entry fee : TBA\n First place : TBA\nSecond place : TBA");
            gotoevent.putExtra("eventname","beatboxing");
        }else if(viewname.equalsIgnoreCase("Mehandi")){
            gotoevent.putExtra("details","Indian art.");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Max of 2 teammates");
            gotoevent.putExtra("fee","Entry fee : TBA\n First place : TBA\nSecond place : TBA");
            gotoevent.putExtra("eventname","mehandi");
        }else if(viewname.equalsIgnoreCase("Pencil Sketch")){
            gotoevent.putExtra("details","Showcase your talent with a pencil.");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Only one participant.");
            gotoevent.putExtra("fee","Entry fee : TBA\n First place : TBA\nSecond place : TBA");
            gotoevent.putExtra("eventname","pencilsketch");
        }else if(viewname.equalsIgnoreCase("Collage")){
            gotoevent.putExtra("details","The theme is Indian army.");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Max of 2 teammates.");
            gotoevent.putExtra("fee","Entry fee : TBA\n First place : TBA\nSecond place : TBA");
            gotoevent.putExtra("eventname","collage");
        }else if(viewname.equalsIgnoreCase("Face Painting")){
            gotoevent.putExtra("details","Face painting is a fun way to dress up—no costume required ;)");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Max of 2 teammates.");
            gotoevent.putExtra("fee","Entry fee : TBA\n First place : TBA\nSecond place : TBA");
            gotoevent.putExtra("eventname","facepainting");

        }else if(viewname.equalsIgnoreCase("Cooking without fire")){
            gotoevent.putExtra("details","Showcase your culinary skills but,\n with a catch. No stove or heating.");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Max of 2 teammates.\n3. Only for Sambhram students");
            gotoevent.putExtra("fee","Entry fee : TBA\n First place : TBA\nSecond place : TBA");
            gotoevent.putExtra("eventname","cooking");
        }


        startActivity(gotoevent);
    }


}
