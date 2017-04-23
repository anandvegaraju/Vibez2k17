package com.vegaraju.anand.vibez2k17;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Anand on 05-04-2017.
 */

public class MainMenu extends AppCompatActivity implements View.OnTouchListener{
    String phonenumber,name,facebookUrl;
    Button creditsbutton, contactusbutton;
    ImageButton eventbutton, gallerybutton, sponsorsbutton, directionbutton,facebookbutton,alumnibutton;
    ViewPager viewPager;
    public static String FACEBOOK_URL = "https://www.facebook.com/sambhramfest2k17";
    public static String FACEBOOK_PAGE_ID = "sambhramfest2k17";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu_layout);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        viewPager = (ViewPager)findViewById(R.id.viewPager1);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

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

        // show credits
        creditsbutton = (Button)findViewById(R.id.button2);
        creditsbutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent gotocredits = new Intent(MainMenu.this,CreditsActivity.class);
                        startActivity(gotocredits);
                    }
                }
        );

        //open google maps for directions
        directionbutton = (ImageButton)findViewById(R.id.imageButton11);
        directionbutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent gmintent = new Intent(android.content.Intent.ACTION_VIEW,
                                Uri.parse("google.navigation:q=13.089396, 77.546225"));
                        startActivity(gmintent);

                    }
                }
        );

        // open fb page
        facebookbutton = (ImageButton)findViewById(R.id.imageButtonfb);
        facebookUrl = getFacebookPageURL(this);
        facebookbutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
                        facebookIntent.setData(Uri.parse(facebookUrl));
                        startActivity(facebookIntent);
                    }
                }

        );

        eventbutton = (ImageButton)findViewById(R.id.imageButton5);
        eventbutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent gotoeventmenu = new Intent(MainMenu.this, EventMenuActivity.class);
                        gotoeventmenu.putExtra("phonenumber",phonenumber);
                        startActivity(gotoeventmenu);
                    }
                }
        );

        contactusbutton = (Button)findViewById(R.id.volleyballinterbutton);
        contactusbutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent gotocontacts = new Intent(MainMenu.this,ContactListActivity.class);
                        startActivity(gotocontacts);
                    }
                }
        );

        alumnibutton = (ImageButton)findViewById(R.id.alumnibutton);
        alumnibutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent gotoalumnireg = new Intent(MainMenu.this, AlumniRegActivity.class);
                        gotoalumnireg.putExtra("phonenumber",phonenumber);
                        startActivity(gotoalumnireg);
                    }
                }
        );

        sponsorsbutton = (ImageButton)findViewById(R.id.imageButton13);
        gallerybutton = (ImageButton)findViewById(R.id.gallerybutton);

        sponsorsbutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"Coming soon",Toast.LENGTH_SHORT).show();
                    }
                }
        );

        gallerybutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"Coming soon",Toast.LENGTH_SHORT).show();
                    }
                }
        );

        eventbutton.setOnTouchListener(this);
        facebookbutton.setOnTouchListener(this);
        alumnibutton.setOnTouchListener(this);
        directionbutton.setOnTouchListener(this);
        sponsorsbutton.setOnTouchListener(this);
        gallerybutton.setOnTouchListener(this);






    }

    @Override
    public boolean onTouch(final View v, MotionEvent event) {
        v.setAlpha(0.5f);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                v.setAlpha(0.75f);

            }
        }, 600);
        return super.onTouchEvent(event);
    }



    public String getFacebookPageURL(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
            if (versionCode >= 3002850) { //newer versions of fb app
                return "fb://facewebmodal/f?href=" + FACEBOOK_URL;
            } else { //older versions of fb app
                return "fb://page/" + FACEBOOK_PAGE_ID;
            }
        } catch (PackageManager.NameNotFoundException e) {
            return FACEBOOK_URL; //normal web url
        }
    }



}
