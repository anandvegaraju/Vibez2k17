package com.example.anand.vibez2k17;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Anand on 08-04-2017.
 */

public class AlumniRegActivity extends AppCompatActivity {

    String phonenumber,tmp1="",tmp2;
    EditText dept,yog;
    Button alumreg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alumniregform_layout);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        Intent i = getIntent();
        phonenumber = i.getStringExtra("phonenumber");
        final DatabaseReference alumlistref = database.getReference("alumnilist");



        alumreg = (Button)findViewById(R.id.alumbutton);
        alumreg.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        alumlistref.addListenerForSingleValueEvent(
                                new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        tmp1 = dataSnapshot.getValue(String.class);
                                        if(tmp1.contains(phonenumber)){
                                            Toast.makeText(getApplicationContext(),"Already registered",Toast.LENGTH_SHORT).show();

                                        }
                                        else{
                                            Intent gotoaf = new Intent(AlumniRegActivity.this,AlumniDB.class);
                                            gotoaf.putExtra("phonenumber",phonenumber);
                                            startActivity(gotoaf);
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



    }
}
