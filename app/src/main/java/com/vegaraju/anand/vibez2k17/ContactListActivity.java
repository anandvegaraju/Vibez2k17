package com.vegaraju.anand.vibez2k17;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by Anand on 08-04-2017.
 */

public class ContactListActivity extends AppCompatActivity {

    ListView list;
    String[] web = {
            "App team : Anand",
            "App team : Bharat",
            "Coordinator : Manu",
            "Fest : Prof.Trupthi",
            "Kushal(Short film)",
            "Deepak(Short film)",
            "Coordinator : Uday",
            "Nitin(Cooking)",
            "Bhuveshwari(Solo dance)",
            "Bhuveshwari(BeatBoxing)",
            "Faculty coordinator(Technical)",
            "Yogananda (Technical",
            "Suhas H(DSLR Photography)",
            "Charan C (Mobile Photography)"




    } ;
    String[] contactlist = {
            "+919483526746",
            "+918553502771",
            "+918867562618",
            "+919036393116",
            "+919738586117",
            "+918147724401",
            "+919739465976",
            "+918861604042",
            "+919900120619",
            "+919900120619",
            "+918105963010",
            "+919731813442",
            "+919738640150"
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
        Intent sendIntent = new Intent("android.intent.action.MAIN");
        sendIntent.setComponent(new ComponentName("com.whatsapp","com.whatsapp.Conversation"));
        sendIntent.putExtra("jid", PhoneNumberUtils.stripSeparators(number.substring(1))+"@s.whatsapp.net");//phone number without "+" prefix

        startActivity(sendIntent);
    }
}
