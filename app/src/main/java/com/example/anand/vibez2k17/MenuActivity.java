package com.example.anand.vibez2k17;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Anand on 03-04-2017.
 */

public class MenuActivity extends AppCompatActivity {

    String nametext, phonenumber, greetingstr, sourcecl, gendertext, collegetext, depttext, emailtext, phlist;
    TextView greeting_text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference userref, regcountref,tmp;
        greeting_text = (TextView)findViewById(R.id.greetingtext);


        regcountref = database.getReference("registeredcount");

        final DatabaseReference phlistref = database.getReference("phonenumbers");

        Intent i = getIntent();
        sourcecl = i.getStringExtra("callfrom");
        if(sourcecl == "regclass"){
            nametext = i.getStringExtra("name");
            phonenumber = i.getStringExtra("phonenumber");
            userref = database.getReference("registeredusers").child(phonenumber);
            gendertext = i.getStringExtra("gender");
            collegetext = i.getStringExtra("college");
            emailtext = i.getStringExtra("email");
            depttext = i.getStringExtra("dept");
            greeting_text.setText("Welcome " + nametext); // display greeting as "Welcome FirstName"

            //update to db
            userref.child("name").setValue(nametext);
            userref.child("phonenumber").setValue(phonenumber);
            userref.child("gender").setValue(gendertext);
            userref.child("email").setValue(emailtext);
            userref.child("branch").setValue(depttext);
            userref.child("college").setValue(collegetext);

            regcountref.addListenerForSingleValueEvent(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            int cunt = dataSnapshot.getValue(Integer.class);
                            regcountref.setValue(cunt+1);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    }
            );

            phlistref.addListenerForSingleValueEvent(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            phlist = dataSnapshot.getValue(String.class);
                            phlist += " " + phonenumber;
                            phlistref.setValue(phlist); //phonenumber added to reglist bitch

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    }
            );

        }else {
            Intent intent = getIntent();
            phonenumber = intent.getStringExtra("phonenumber");
            DatabaseReference nameref = database.getReference("registeredusers").child(phonenumber).child("name");
            nameref.addListenerForSingleValueEvent(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            greeting_text.setText("Welcome " + dataSnapshot.getValue(String.class));

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    }
            );
        }




    }
}
