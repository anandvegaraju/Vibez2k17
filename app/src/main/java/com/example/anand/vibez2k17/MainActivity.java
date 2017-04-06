package com.example.anand.vibez2k17;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.digits.sdk.android.AuthCallback;
import com.digits.sdk.android.Digits;
import com.digits.sdk.android.DigitsAuthButton;
import com.digits.sdk.android.DigitsException;
import com.digits.sdk.android.DigitsSession;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "uAejj1SMn0nERAO0NnzxdMlaJ";
    private static final String TWITTER_SECRET = "UpwPTv7np3CQSDIC2OeWAaJ4r1Ij9nmLe6oU7JpuqJsZx9AHLT";


    String numlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Digits.Builder digitsBuilder = new Digits.Builder().withTheme(R.style.CustomDigitsTheme);
        Fabric.with(this, new TwitterCore(authConfig), digitsBuilder.build());
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference phonelistref = database.getReference("phonenumbers");
        final DatabaseReference phonelistref1 = database.getReference("phonenumbers");



        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        DigitsAuthButton digitsButton = (DigitsAuthButton) findViewById(R.id.auth_button2);
        digitsButton.setText("Register");
        digitsButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        digitsButton.setCallback(new AuthCallback() {
            @Override
            public void success(DigitsSession session, final String phoneNumber) {
                // TODO: associate the session userID with your user model
                Toast.makeText(getApplicationContext(), "Please wait", Toast.LENGTH_SHORT).show();
                phonelistref.addListenerForSingleValueEvent(
                        new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                numlist = dataSnapshot.getValue(String.class);
                                if(numlist.contains(phoneNumber)){
                                    Toast.makeText(getApplicationContext(),"Already Registered",Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    Intent regintent = new Intent(MainActivity.this,UserRegistrationActivity.class);
                                    regintent.putExtra("phonenumber",phoneNumber);
                                    startActivity(regintent);

                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        }
                );




            }

            @Override
            public void failure(DigitsException exception) {
                Log.d("Digits", "Sign in with Digits failure", exception);
            }
        });

        DigitsAuthButton digitsAuthButton2 = (DigitsAuthButton)findViewById(R.id.auth_button);
        digitsAuthButton2.setText("Login");
        digitsAuthButton2.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        digitsAuthButton2.setCallback(
                new AuthCallback() {
                    @Override
                    public void success(DigitsSession session, final String phoneNumber) {

                        Toast.makeText(getApplicationContext(),"Please wait",Toast.LENGTH_SHORT).show();
                        phonelistref1.addListenerForSingleValueEvent(
                                new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        numlist = dataSnapshot.getValue(String.class);
                                        if(numlist.contains(phoneNumber)){
                                            Intent gotomainmenu = new Intent(MainActivity.this,MainMenu.class);
                                            gotomainmenu.putExtra("phonenumber",phoneNumber);
                                            startActivity(gotomainmenu);
                                        }
                                        else {
                                            Toast.makeText(getApplicationContext(),"Please register first",Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    @Override
                                    public void onCancelled(DatabaseError databaseError) {

                                    }
                                }
                        );



                    }

                    @Override
                    public void failure(DigitsException error) {

                    }
                }
        );

    }
}
