package com.example.anand.vibez2k17;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by Anand on 03-04-2017.
 */

public class UserRegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent getph = getIntent();
        String phonenumber = getph.getStringExtra("phonenumber");
        setContentView(R.layout.registration_layout);


        // remove this later
        Toast.makeText(getApplicationContext(),phonenumber,Toast.LENGTH_SHORT).show();


    }
}
