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

public class SportEventsActivity extends AppCompatActivity {
    String phonenumber, viewname;
    Button shcricket, tball, vball, kabaddi, bads, badd;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setTitle("Sporting events");
        Intent i = getIntent();
        phonenumber = i.getStringExtra("phonenumber");

        shcricket = (Button)findViewById(R.id.volleyballinterbutton);
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
            gotoevent.putExtra("details","Registrations are closed\nCricket with reduced overs and players. ");
            gotoevent.putExtra("timings","Event completed");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.\n3. 7+3 team members");
            gotoevent.putExtra("fee","Entry fee : NA\n First place : NA\nSecond place : NA");
            gotoevent.putExtra("eventname","shortcricket");
            gotoevent.putExtra("eventcoordinator","Manu");
            gotoevent.putExtra("eventcoordinatornum","+918867562618");
        }else if(viewname.equalsIgnoreCase("Throwball")){
            gotoevent.putExtra("details","Registrations are closed\nCatch and throw ball over the net");
            gotoevent.putExtra("timings","Event finished");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.\n3. 6+3 team members");
            gotoevent.putExtra("fee","Entry fee : NA\n First place : NA\nSecond place : NA");
            gotoevent.putExtra("eventname","throwball");
            gotoevent.putExtra("eventcoordinator","Sagarika");
            gotoevent.putExtra("eventcoordinatornum","+917022666160");
        }else if(viewname.equalsIgnoreCase("Volleyball")){
            gotoevent.putExtra("details","Registrations are closed\nVolleyball as we know it");
            gotoevent.putExtra("timings","Event completed");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.\n3. 6+3 team members");
            gotoevent.putExtra("fee","Entry fee : NA\n First place : NA\nSecond place : NA");
            gotoevent.putExtra("eventname","volleyball");
            gotoevent.putExtra("eventcoordinator","Manu");
            gotoevent.putExtra("eventcoordinatornum","+918867562618");
        }else if(viewname.equalsIgnoreCase("Kabbadi")){
            gotoevent.putExtra("details","Registrations are closed\nKabaddi like we know");
            gotoevent.putExtra("timings","Event completed");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.\n3. 7+3 team members");
            gotoevent.putExtra("fee","Entry fee : NA\n First place : NA\nSecond place : NA");
            gotoevent.putExtra("eventname","kabaddi");
            gotoevent.putExtra("eventcoordinator","Manu");
            gotoevent.putExtra("eventcoordinatornum","+918867562618");
        }else if(viewname.equalsIgnoreCase("Carrom doubles")){
            gotoevent.putExtra("details","Registrations are closed\nCarrom (girls)");
            gotoevent.putExtra("timings","Event completed");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.");
            gotoevent.putExtra("fee","Entry fee : NA\n First place : NA\nSecond place : NA");
            gotoevent.putExtra("eventname","carrom");
            gotoevent.putExtra("eventcoordinator","Manu");
            gotoevent.putExtra("eventcoordinatornum","+918867562618");
        }else if(viewname.equalsIgnoreCase("Badminton doubles")){
            gotoevent.putExtra("details","Registrations are closed\nBadminton with 2 players in a side.\n(girls only)");
            gotoevent.putExtra("timings","Event completed");
            gotoevent.putExtra("rules","1. No foul play\n2. Play fairly.");
            gotoevent.putExtra("fee","Entry fee : NA\n First place : NA\nSecond place : NA");
            gotoevent.putExtra("eventname","badmintondoubles");
            gotoevent.putExtra("eventcoordinator","Sagarika");
            gotoevent.putExtra("eventcoordinatornum","+917022666160");
        }

        startActivity(gotoevent);
    }
}
