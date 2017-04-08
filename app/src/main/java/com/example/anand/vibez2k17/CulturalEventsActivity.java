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

        grpdance = (Button)findViewById(R.id.counterstrike);
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
        gotoevent.putExtra("eventname",viewname);
        startActivity(gotoevent);
    }


}
