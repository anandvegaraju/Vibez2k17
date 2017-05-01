package com.vegaraju.anand.vibez2k17;


import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


/**
 * Created by Anand on 23-04-2017.
 */

public class CreditsActivity extends AppCompatActivity {

    ImageButton linkedin1, linkedin2;
    Intent intent;
    private AdView mAdView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creditsactivity);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setTitle("Credits");
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-9244088228461369/4858268730");


        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        linkedin1 = (ImageButton)findViewById(R.id.linkedin1);
        linkedin2 = (ImageButton)findViewById(R.id.linkedin2);


        linkedin1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openWhatsappContact("+919483526746");

                    }
                }
        );

        linkedin2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openWhatsappContact("+918553502771");

                    }
                }
        );



    }

    void openWhatsappContact(String number) {



        //
        Intent sendIntent = new Intent("android.intent.action.MAIN");
        sendIntent.setComponent(new ComponentName("com.whatsapp","com.whatsapp.Conversation"));
        sendIntent.putExtra("jid", PhoneNumberUtils.stripSeparators(number.substring(1))+"@s.whatsapp.net");//phone number without "+" prefix

        startActivity(sendIntent);
    }




}
