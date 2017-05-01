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
            "App team : Anand", //1
            "App team : Bharat",//2
            "Coordinator : Manu",//3
            "Fest :Prof.Trupthi",//4
            "Chandru(Short film)",//6
            "Uday(Fest)",//7
            "Nitin(Cooking)",//8
            "Bhuveshwari(Solo dance)",//9
            "Bhuveshwari(BeatBoxing)",//10
            "Faculty coordinator(Technical)",//11
            "Yogananda (Technical",//12
            "Suhas H(DSLR Photography)",//13
            "Charan C (Mobile Photography)",//14
            "Sagarika(Mehendi",//15
            "Shilpa(Face Painting)",//16
            "Anusha(Pencil Sketch)",//17
            "Akash(Collage)",//18
            "Ragini(Rangoli)",//19
            "Harshitha(BeatBoxing)",//20
            "Bharath(Dance)"//21




    } ;
    String[] contactlist = {
            "+919483526746", //1
            "+918553502771", //2
            "+918867562618",//3
            "+919036393116",//4
            "+919738586117",//5
            "+919980845794",//6
            "+919739465976",//7
            "+918861604042",//8
            "+919900120619",//9
            "+919900120619",//10
            "+918105963010",//11
            "+918277007008",//12
            "+919738640150",//13
            "+917022666160",//14
            "+917019653980",//15
            "+918861265596",//16
            "+918095185157",//17
            "+918867994551",//18
            "+917795930442",//19
            "+918553317570"//20
    } ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactlist_layout);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setTitle("Contact Coordinators");

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
