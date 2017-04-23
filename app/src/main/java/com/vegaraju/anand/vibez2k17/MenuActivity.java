package com.vegaraju.anand.vibez2k17;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Anand on 03-04-2017.
 */

public class MenuActivity extends AppCompatActivity {

    String nametext, phonenumber, gendertext, collegetext, depttext, emailtext, phlist;
    int regcount;
    TextView greeting_text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference userref,regcountref;
        greeting_text = (TextView)findViewById(R.id.greetingtext);


        final DatabaseReference phlistref = database.getReference("phonenumbers");
        regcountref = database.getReference("regcount");

        Intent i = getIntent();

        nametext = i.getStringExtra("name");
        phonenumber = i.getStringExtra("phonenumber");
        userref = database.getReference(phonenumber);

        gendertext = i.getStringExtra("gender");
        collegetext = i.getStringExtra("college");
        emailtext = i.getStringExtra("email");
        depttext = i.getStringExtra("dept");
         // display greeting as "Welcome FirstName"

        greeting_text.setText("Welcome " + nametext);



            //update to db
        userref.child("name").setValue(nametext);
        userref.child("phonenumber").setValue(phonenumber);
        userref.child("gender").setValue(gendertext);
        userref.child("email").setValue(emailtext);
        userref.child("branch").setValue(depttext);
        userref.child("college").setValue(collegetext);





        phlistref.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        phlist = dataSnapshot.getValue(String.class);
                        phlist += " " + phonenumber;
                        phlistref.setValue(phlist); //phonenumber added to reglist
                        }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        }
                    }
            );

        regcountref.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        regcount = dataSnapshot.getValue(Integer.class);
                        regcountref.setValue(regcount+1);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                }
        );

        Intent gotomain = new Intent(MenuActivity.this,MainActivity.class);
        Toast.makeText(getApplicationContext(),"Updating to db",Toast.LENGTH_LONG).show();
        startActivity(gotomain);




    }
}
