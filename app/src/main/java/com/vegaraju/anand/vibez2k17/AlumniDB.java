package com.vegaraju.anand.vibez2k17;

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

public class AlumniDB extends AppCompatActivity {

    String phonenumber,tmp1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alumnitemp);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        Intent intent = getIntent();
        phonenumber = intent.getStringExtra("phonenumber");
        final DatabaseReference alumlistref = database.getReference("alumnilist");






        alumlistref.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        tmp1 = dataSnapshot.getValue(String.class);

                        tmp1 = dataSnapshot.getValue(String.class);
                        tmp1 += " " + phonenumber;
                        alumlistref.setValue(tmp1);
                        Toast.makeText(getApplicationContext(),"Cya soon:)",Toast.LENGTH_SHORT).show();
                        Intent goback1 = new Intent(AlumniDB.this,MainMenu.class);
                        goback1.putExtra("phonenumber",phonenumber);
                        startActivity(goback1);



                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                }
        );
    }
}
