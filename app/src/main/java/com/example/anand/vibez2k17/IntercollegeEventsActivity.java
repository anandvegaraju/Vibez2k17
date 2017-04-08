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

        grpdanceinter = (Button)findViewById(R.id.counterstrike);
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
        gotoevent.putExtra("eventname",viewname);
        startActivity(gotoevent);
    }
}
