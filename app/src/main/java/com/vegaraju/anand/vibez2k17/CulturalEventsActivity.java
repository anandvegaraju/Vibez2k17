package com.vegaraju.anand.vibez2k17;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Anand on 08-04-2017.
 */

public class CulturalEventsActivity extends AppCompatActivity {
    String phonenumber, viewname;
    Button grpdance, solodance, grpsong, solosong, fashionshow, rangoli, shortfilm, photography, beatboxing, mehandi, pencilsketch, collage, facepainting, cookwofire;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cultural);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setTitle("Cultural Events");
        Intent i = getIntent();
        phonenumber = i.getStringExtra("phonenumber");

        //link the button objects

        grpdance = (Button)findViewById(R.id.volleyballinterbutton);
        solodance = (Button)findViewById(R.id.solodancebutton);
        grpsong = (Button)findViewById(R.id.groupsongbutton);
        solosong = (Button)findViewById(R.id.solosongbutton);
        fashionshow = (Button)findViewById(R.id.fashionshowbutton);
        rangoli = (Button)findViewById(R.id.rangolibutton);
        shortfilm = (Button)findViewById(R.id.terriblefilmsbutton);
        photography = (Button)findViewById(R.id.photographybutton);
        beatboxing = (Button)findViewById(R.id.shitboxingbutton);
        mehandi = (Button)findViewById(R.id.mehandi);
        pencilsketch = (Button)findViewById(R.id.pencilsketchbutton);
        collage = (Button)findViewById(R.id.collage);
        facepainting = (Button)findViewById(R.id.facepainting);

    }

    public void OnClick(View view){
        Button button = (Button)findViewById(view.getId());
        viewname = button.getText().toString();
        Intent gotoevent = new Intent(CulturalEventsActivity.this,EventTemplateActivity.class);
        gotoevent.putExtra("phonenumber",phonenumber);
        gotoevent.putExtra("eventnamee",viewname);
        //
        if (viewname.equalsIgnoreCase("Group Dance")) {
            gotoevent.putExtra("details","Step up! Duration of performance should be 4+2 minutes.  ;)");
            gotoevent.putExtra("timings","5th May 2017");
            gotoevent.putExtra("rules","1. No foul play\n2. Max of 10+2 teammates\n 3. Carry 2 pendrives containing song to avoid issues\n 4. No Vulgarity\n5. Judgement based on several factors.");
            gotoevent.putExtra("fee","Entry fee : Rs 1000\n First place : Rs 10000\n");
            gotoevent.putExtra("eventname","groupdance");
            gotoevent.putExtra("eventcoordinator","Bhuvaneshwari");
            gotoevent.putExtra("eventcoordinatornum","+917892369241");
        }else if(viewname.equalsIgnoreCase("Solo Dance")){
            gotoevent.putExtra("details","Showcase your awesome dance moves\n Dance duration is 3+2 minutes");
            gotoevent.putExtra("timings","5th May 2017");
            gotoevent.putExtra("rules","1. No foul play\n2. Max of 1 participant\n3. Carry 2 pendrives containing song to avoid issues\n4. Judgement based on several factors.");
            gotoevent.putExtra("fee","Entry fee : Rs 300\n First place : Rs 3000\n");
            gotoevent.putExtra("eventname","solodance");
            gotoevent.putExtra("eventcoordinator","Bharath kumar");
            gotoevent.putExtra("eventcoordinatornum","+918553317570");
        }else if(viewname.equalsIgnoreCase("Group Song")){
            gotoevent.putExtra("details","It's all about coordination!");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Max of 5 teammates.");
            gotoevent.putExtra("fee","Entry fee : TBA\n First place : TBA\nSecond place : TBA");
            gotoevent.putExtra("eventname","groupsong");
            gotoevent.putExtra("eventcoordinator","Bhuvaneshwari");
            gotoevent.putExtra("eventcoordinatornum","+917892369241");
        }else if(viewname.equalsIgnoreCase("Solo Song")){
            gotoevent.putExtra("details","Showcase your talent");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Max of 1 participant.");
            gotoevent.putExtra("fee","Entry fee : TBA\n First place : TBA\nSecond place : TBA");
            gotoevent.putExtra("eventname","solosong");
            gotoevent.putExtra("eventcoordinator","Bhuvaneshwari");
            gotoevent.putExtra("eventcoordinatornum","+917892369241");
        }else if(viewname.equalsIgnoreCase("Fashion show")){
            gotoevent.putExtra("details","Duration : 8+2 minutes.");
            gotoevent.putExtra("timings","Evening");
            gotoevent.putExtra("rules","1. No foul play\n2. Max of 10+2 teammates.\n3. One team per college\n4. Theme based\n5. Provide songs in 2 pendrives prior to the event.\n6. No vulgarity allowed\n7. Candidates should remove their own set pieces");
            gotoevent.putExtra("fee","Entry fee : TBA\n First place : TBA\nSecond place : TBA");
            gotoevent.putExtra("eventname","fashionshow");
            gotoevent.putExtra("eventcoordinator","Ashmita");
            gotoevent.putExtra("eventcoordinatornum","+917760559392");
        }else if(viewname.equalsIgnoreCase("Rangoli")){
            gotoevent.putExtra("details","A colorful Indian artform");
            gotoevent.putExtra("timings","10am 3rd May 2017");
            gotoevent.putExtra("rules","1. Duration : 1 hour\n2. Max of 2 teammates.\n3. No chalks allowed\n 4. No salt/rice/flowers\n5. Only pure rangoli colors allowed\n6. No moulds.\n7. Only 2 per college");
            gotoevent.putExtra("fee","Entry fee : Rs 100");
            gotoevent.putExtra("eventname","rangoli");
            gotoevent.putExtra("eventcoordinator","Ragini");
            gotoevent.putExtra("eventcoordinatornum","+918867994551");
        }else if(viewname.equalsIgnoreCase("Short Film")){
            gotoevent.putExtra("details","Awaken the talented filmmaker in you .");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. No foul play\n2. Duration : 10+2\n3. No vulgarity or beeps");
            gotoevent.putExtra("fee","Entry fee : TBA");
            gotoevent.putExtra("eventname","shortfilm");
            gotoevent.putExtra("eventcoordinator","Chandru");
            gotoevent.putExtra("eventcoordinatornum","+919980845794");
        }else if(viewname.equalsIgnoreCase("Photography")){
            gotoevent.putExtra("details","Two categories : DSLR and mobile.\nCapture the beauty of the world through lens.\nTopic will be given on spot");
            gotoevent.putExtra("timings","9am to 1pm");
            gotoevent.putExtra("rules","1. Only one participant\n2. Image should be in JPEG format\n3. No filters\n4. On spot registration allowed\n5. Theme will be given on spot.\n6. For mobile photography camera should be of min 10mp\n7. No filters\n8. 3 hour event\n9. Judge's decision is final ");
            gotoevent.putExtra("fee","Entry fee : Contact the coordinator");
            gotoevent.putExtra("eventname","photography");
            gotoevent.putExtra("eventcoordinator","Suhas & Mahantesh");
            gotoevent.putExtra("eventcoordinatornum","+918277007008");
        }else if(viewname.equalsIgnoreCase("Beat Boxing")){
            gotoevent.putExtra("details","A form of vocal percussion primarily involving the art of mimicking\n drum machines using one's mouth, lips, tongue, and voice.");
            gotoevent.putExtra("timings","6-7 May 2017");
            gotoevent.putExtra("rules","1. One minute showcase\n2. Only one participant\n3. No profanity allowed\n4. No musical instruments");
            gotoevent.putExtra("fee","Entry fee : TBA\n First place : TBA\nSecond place : TBA");
            gotoevent.putExtra("eventname","beatboxing");
            gotoevent.putExtra("eventcoordinator","Harshitha");
            gotoevent.putExtra("eventcoordinatornum","+917795930442");
        }else if(viewname.equalsIgnoreCase("Mehandi")){
            gotoevent.putExtra("details","Indian art.");
            gotoevent.putExtra("timings","12pm 3rd May 2017");
            gotoevent.putExtra("rules","1. No foul play\n2. Max of 2 teammates\n3. Duration will be 45 minutes\n4. No Indian/Arabic design\n5. Carry your own mehandi cone.\n6. No black cone\n7. Only 2 per college");
            gotoevent.putExtra("fee","Entry fee : Rs 100");
            gotoevent.putExtra("eventname","mehandi");
            gotoevent.putExtra("eventcoordinator","Sagarika");
            gotoevent.putExtra("eventcoordinatornum","+917022666160");
        }else if(viewname.equalsIgnoreCase("Pencil Sketch")){
            gotoevent.putExtra("details","Showcase your talent with a pencil.");
            gotoevent.putExtra("timings","10am 3rd May 2017");
            gotoevent.putExtra("rules","1. Duration : 45 minutes\n2. Only one participant.\n3. Theme will be given on spot\n4. No tracing\n5. No mobile devices allowed\n6. Only 2 per college");
            gotoevent.putExtra("fee","Entry fee : Rs 100");
            gotoevent.putExtra("eventname","pencilsketch");
            gotoevent.putExtra("eventcoordinator","Anusha");
            gotoevent.putExtra("eventcoordinatornum","+918861265596");
        }else if(viewname.equalsIgnoreCase("Collage")){
            gotoevent.putExtra("details","The theme is Indian army.");
            gotoevent.putExtra("timings","2pm 3rd May 2017");
            gotoevent.putExtra("rules","1. No foul play\n2. Max of 2 teammates.\n3. Duration : 45 minutes\n4. News papers only\n5. Carry your own materials\n6. No scissors\n7. Only 2 per college");
            gotoevent.putExtra("fee","Entry fee : Rs 150");
            gotoevent.putExtra("eventname","collage");
            gotoevent.putExtra("eventcoordinator","Aakash");
            gotoevent.putExtra("eventcoordinatornum","+918095185157");
        }else if(viewname.equalsIgnoreCase("Face Painting")){
            gotoevent.putExtra("details","Face painting is a fun way to dress up—no costume required ;)");
            gotoevent.putExtra("timings","12pm 3rd May 2017");
            gotoevent.putExtra("rules","1. Duration : 1 hour\n2. Any concept allowed\n3. Get your own paints/brushes\n4. Use only face paints\n5. Bring a volunteer\n6. Only 2 per college");
            gotoevent.putExtra("fee","Entry fee : Rs 100");
            gotoevent.putExtra("eventname","facepainting");
            gotoevent.putExtra("eventcoordinator","Shilpa");
            gotoevent.putExtra("eventcoordinatornum","+917019653980");

        }


        startActivity(gotoevent);
    }


}
