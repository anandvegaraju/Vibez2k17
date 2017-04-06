package com.example.anand.vibez2k17;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Anand on 03-04-2017.
 */

public class UserRegistrationActivity extends AppCompatActivity {

    EditText fullname, emailid, collegename, deptname;
    RadioGroup gender;
    Button submit;
    String nametext, emailtext, collegetext, depttext, gendertext, phonenumber, phlist, fuckthis;
    RadioButton male,female,temp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent getph = getIntent();
        phonenumber = getph.getStringExtra("phonenumber");
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        setContentView(R.layout.regform_activity);

        // link the form layout to objects
        fullname = (EditText)findViewById(R.id.fullnameField);
        emailid = (EditText)findViewById(R.id.emailField);
        collegename = (EditText)findViewById(R.id.collegeField);
        deptname = (EditText)findViewById(R.id.departmentField);
        gender = (RadioGroup)findViewById(R.id.gendergrp);
        submit = (Button)findViewById(R.id.signUpBtn);
        male = (RadioButton)findViewById(R.id.male_radio_btn);
        female = (RadioButton)findViewById(R.id.female_radio_btn);

        fullname.setHintTextColor(getResources().getColor(R.color.primary_text_material_light));
        emailid.setHintTextColor(getResources().getColor(R.color.primary_text_material_light));
        collegename.setHintTextColor(getResources().getColor(R.color.primary_text_material_light));
        deptname.setHintTextColor(getResources().getColor(R.color.primary_text_material_light));


        submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // read text data from widgets and upload it to db
                        //store data in strings

                        if(fullname.getText().toString().trim().equals("")){
                            fullname.setError("Name is required");
                        }
                        else if(collegename.getText().toString().trim().equals("")){
                            collegename.setError("College name is required");
                        }
                        else if(emailid.getText().toString().trim().equals("")){
                            emailid.setError("Email ID is required");
                        }

                        else
                        {



                            //if form is filled
                            nametext = fullname.getText().toString();
                            emailtext = emailid.getText().toString();
                            collegetext = collegename.getText().toString();
                            depttext = deptname.getText().toString();
                            temp = (RadioButton)findViewById(gender.getCheckedRadioButtonId());
                            gendertext = temp.getText().toString();


                                Intent gotomenu = new Intent(UserRegistrationActivity.this,MenuActivity.class);
                                gotomenu.putExtra("phonenumber",phonenumber);
                                gotomenu.putExtra("name",nametext);
                                gotomenu.putExtra("email",emailtext);
                                gotomenu.putExtra("college",collegetext);
                                gotomenu.putExtra("dept",depttext);
                                gotomenu.putExtra("gender",gendertext);
                                gotomenu.putExtra("registered","false");
                                startActivity(gotomenu);









                    }}
                }
        );



    }
}
