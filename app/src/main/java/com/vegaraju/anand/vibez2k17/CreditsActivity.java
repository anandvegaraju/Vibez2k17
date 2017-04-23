package com.vegaraju.anand.vibez2k17;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;


/**
 * Created by Anand on 23-04-2017.
 */

public class CreditsActivity extends AppCompatActivity {

    ImageButton linkedin1, linkedin2;
    Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creditsactivity);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

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
        Uri uri = Uri.parse("smsto:" + number);
        Intent i = new Intent(Intent.ACTION_SENDTO, uri);
        i.setPackage("com.whatsapp");
        startActivity(Intent.createChooser(i, ""));
    }




}
