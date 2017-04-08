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

        counterstrike = (Button)findViewById(R.id.counterstrike);
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
        gotoevent.putExtra("eventname",viewname);
        startActivity(gotoevent);
    }
}
