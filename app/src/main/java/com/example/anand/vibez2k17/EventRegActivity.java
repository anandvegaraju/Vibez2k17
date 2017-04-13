package com.example.anand.vibez2k17;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Anand on 08-04-2017.
 */

public class EventRegActivity extends AppCompatActivity {

    String phonenumber, eventnodename, tmp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventregdb);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        Intent i5 = getIntent();
        phonenumber = i5.getStringExtra("phonenumber");
        eventnodename = i5.getStringExtra("nodename");
        final DatabaseReference eventref = database.getReference(eventnodename);
        eventref.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        tmp = dataSnapshot.getValue(String.class);
                        tmp += phonenumber;
                        eventref.setValue(tmp);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                }
        );
        Intent gotoeventmenu = new Intent(EventRegActivity.this, EventMenuActivity.class);
        Toast.makeText(getApplicationContext(),"Registered ",Toast.LENGTH_SHORT).show();
        gotoeventmenu.putExtra("phonenumber",phonenumber);
        startActivity(gotoeventmenu);

    }
}
