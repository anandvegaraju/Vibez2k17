package com.vegaraju.anand.vibez2k17;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * Created by Anand on 08-04-2017.
 */

public class EventTemplateActivity extends AppCompatActivity {

    String phonenumber, eventnamewithspace, eventdetails ,eventfee, eventrules, eventtimings, eventdbname, tmp;
    TextView detail_head, detailstext, rulestext, feetext, timingtext;
    Button eventregister, eventcontact;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_template);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        Intent fromeventlist = getIntent();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference eventnoderef;
        phonenumber = fromeventlist.getStringExtra("phonenumber");
        eventnamewithspace = fromeventlist.getStringExtra("eventnamee");
        eventdetails = fromeventlist.getStringExtra("details");
        eventrules = fromeventlist.getStringExtra("rules");
        eventtimings = fromeventlist.getStringExtra("timings");
        eventfee = fromeventlist.getStringExtra("fee");
        eventdbname = fromeventlist.getStringExtra("eventname");
        eventnoderef = database.getReference(eventdbname);
        detail_head = (TextView)findViewById(R.id.eventdetailhead);
        detailstext = (TextView)findViewById(R.id.eventdetails);
        rulestext = (TextView)findViewById(R.id.eventrules);
        feetext = (TextView)findViewById(R.id.eventfee);
        timingtext = (TextView)findViewById(R.id.eventtimings);
        eventregister = (Button)findViewById(R.id.eventregisterbutton);
        eventcontact = (Button)findViewById(R.id.eventcontactbutton);

        detail_head.setText(eventnamewithspace + " details");
        detailstext.setText(eventdetails);
        rulestext.setText(eventrules);
        feetext.setText(eventtimings);
        feetext.setText(eventfee);

        eventregister.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        eventnoderef.addListenerForSingleValueEvent(
                                new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        tmp = dataSnapshot.getValue(String.class);
                                        if(tmp.contains(phonenumber)){
                                            Toast.makeText(getApplicationContext(),"Already registered",Toast.LENGTH_SHORT).show();
                                        }else {
                                            Intent gotoeventreg = new Intent(EventTemplateActivity.this, EventRegActivity.class);
                                            gotoeventreg.putExtra("phonenumber",phonenumber);
                                            gotoeventreg.putExtra("nodename",eventdbname);
                                            startActivity(gotoeventreg);
                                        }
                                    }

                                    @Override
                                    public void onCancelled(DatabaseError databaseError) {

                                    }
                                }
                        );
                    }
                }
        );

        eventcontact.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent gotocontacts = new Intent(EventTemplateActivity.this, ContactListActivity.class);
                        gotocontacts.putExtra("phonenumber",phonenumber);
                        startActivity(gotocontacts);
                    }
                }
        );


    }
}
