package com.example.anand.vibez2k17;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Anand on 05-04-2017.
 */

public class MainMenu extends AppCompatActivity {
    String phonenumber,name;
    Button creditsbutton, contactusbutton;
    ViewPager viewPager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu_layout);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        viewPager = (ViewPager)findViewById(R.id.viewPager1);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);

        viewPager.setAdapter(viewPagerAdapter);
        Intent intent = getIntent();
        phonenumber = intent.getStringExtra("phonenumber");

        DatabaseReference nameref = database.getReference(phonenumber).child("name");
        nameref.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        name = dataSnapshot.getValue(String.class);
                        Toast.makeText(getApplicationContext(),"Welcome " + name, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                }
        );


        creditsbutton = (Button)findViewById(R.id.button2);
        creditsbutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"Anand Vegaraju\nBharat VK",Toast.LENGTH_LONG).show();
                    }
                }
        );

    }
}
