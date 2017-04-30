package com.vegaraju.anand.vibez2k17;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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

    String phonenumber, eventnamewithspace, eventdetails ,eventfee, eventrules, eventtimings, eventdbname, tmp, eventcoordinator, eventcoordnum;
    TextView detail_head, detailstext, rulestext, feetext, timingtext, coordinatorname;
    Button eventregister;
    ImageView whatsappb, smsb, callb;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_template);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        Intent fromeventlist = getIntent();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference eventtnoderef;
        phonenumber = fromeventlist.getStringExtra("phonenumber");
        eventnamewithspace = fromeventlist.getStringExtra("eventnamee");
        eventdetails = fromeventlist.getStringExtra("details");
        eventrules = fromeventlist.getStringExtra("rules");
        getSupportActionBar().setTitle(eventnamewithspace);
        eventtimings = fromeventlist.getStringExtra("timings");
        eventfee = fromeventlist.getStringExtra("fee");
        eventdbname = fromeventlist.getStringExtra("eventname");
        eventcoordinator = fromeventlist.getStringExtra("eventcoordinator");
        eventcoordnum = fromeventlist.getStringExtra("eventcoordinatornum");
        eventtnoderef = database.getReference(eventdbname);
        detail_head = (TextView)findViewById(R.id.eventdetailhead);
        detailstext = (TextView)findViewById(R.id.eventdetails);
        rulestext = (TextView)findViewById(R.id.eventrules);
        feetext = (TextView)findViewById(R.id.eventfee);
        timingtext = (TextView)findViewById(R.id.eventtimings);
        coordinatorname = (TextView)findViewById(R.id.coordinatornametext);
        eventregister = (Button)findViewById(R.id.eventregisterbutton);
        whatsappb = (ImageView)findViewById(R.id.sendwmsg);
        callb = (ImageView)findViewById(R.id.callcoordinator);
        smsb = (ImageView)findViewById(R.id.sendmsg);
        coordinatorname.setText(eventcoordinator);
        detail_head.setText(eventnamewithspace + " details");
        detailstext.setText(eventdetails);
        rulestext.setText(eventrules);
        feetext.setText(eventtimings);
        feetext.setText(eventfee);

        eventregister.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        eventtnoderef.addListenerForSingleValueEvent(
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

        whatsappb.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openWhatsappContact(eventcoordnum);
                    }
                }
        );

        callb.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + eventcoordnum));
                        startActivity(intent);
                    }
                }
        );

        smsb.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", eventcoordnum, null)));
                    }
                }
        );




    }

    void openWhatsappContact(String number) {
        Intent sendIntent = new Intent("android.intent.action.MAIN");
        sendIntent.setComponent(new ComponentName("com.whatsapp","com.whatsapp.Conversation"));
        sendIntent.putExtra("jid", PhoneNumberUtils.stripSeparators(number.substring(1))+"@s.whatsapp.net");//phone number without "+" prefix

        startActivity(sendIntent);
    }
}
