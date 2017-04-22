package com.example.anand.vibez2k17;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Anand on 08-04-2017.
 */

public class ContactListActivity extends AppCompatActivity {

    ListView list;
    String[] web = {
            "App team : Anand",
            "App team : Bharat",
            "Fest coordinator",
            "Faculty : Prof Trupthi",
            "Coordinator : Kushal",
            "Coordinator : Deepak",
            "Coordinator : Uday",
            "Coordinator : Nitin"


    } ;
    String[] contactlist = {
            "+919483526746",
            "+918553502771",
            "+918867562618",
            "+919036393116",
            "+919738586117",
            "+918147724401",
            "+919739465976",
            "+918861604042"
    } ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactlist_layout);

        CustomList adapter = new
                CustomList(ContactListActivity.this, web);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                openWhatsappContact(contactlist[position]);
            }
        });
    }

    void openWhatsappContact(String number) {
        Uri uri = Uri.parse("smsto:" + number);
        Intent i = new Intent(Intent.ACTION_SENDTO, uri);
        i.setPackage("com.whatsapp");
        startActivity(Intent.createChooser(i, ""));
    }
}
