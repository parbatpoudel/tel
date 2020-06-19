package com.example.last.bbathirdsemester;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Business_communication_unit_five extends AppCompatActivity {

    ListView listtttt;
    // add all the title and description and image on assending order
    String titlesssss[] = {"Chapter One", "Chapter Two", "Chapter Three", "Chapter Four", "Chapter five"};
    String descriptionsssss[] = {"   Document Design", "   Graphics", "   The Summary ", "   Proposal ", "   Oral Presentation"};
    int imgsssss[] = {R.drawable.finance, R.drawable.informationsystem, R.drawable.businesscommunication, R.drawable.statistics, R.drawable.informationsystem};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_communication_unit_five);

        getSupportActionBar().setTitle("Unit Five");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        listtttt = findViewById(R.id.english_unit_five);
        runAnimation(listtttt,0);


        //creating instance of class Adapter

        MyAdapter adapter = new MyAdapter(this, titlesssss, imgsssss, descriptionsssss);

        //set adapter to list
        listtttt.setAdapter(adapter);

        // IMPORTANT PART
        // HAndle items onclick Listener  in this example there is tost we have to add intent while we are working


        listtttt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){


                    Toast.makeText(Business_communication_unit_five.this, "Chapter One Clicked... ", Toast.LENGTH_SHORT).show();
                }
                if (position==1){


                    Toast.makeText(Business_communication_unit_five.this, "Chapter Two Clicked... ", Toast.LENGTH_SHORT).show();
                }
                if (position==2){

                    Toast.makeText(Business_communication_unit_five.this, "Chapter Three Clicked... ", Toast.LENGTH_SHORT).show();
                }
                if (position==3){

                    Toast.makeText(Business_communication_unit_five.this, "Chapter Four Clicked... ", Toast.LENGTH_SHORT).show();
                }
                if (position==3){

                    Toast.makeText(Business_communication_unit_five.this, "Chapter Five Clicked... ", Toast.LENGTH_SHORT).show();
                }

            }
        });




    }

    private void runAnimation(ListView listtttt, int type) {
        Context context = listtttt.getContext();
        LayoutAnimationController controller = null;

        if (type ==0)
            controller = AnimationUtils.loadLayoutAnimation(context,R.anim.layout_slide_from_right);


        listtttt.setLayoutAnimation(controller);
        listtttt.scheduleLayoutAnimation();
    }


    //Create Custom Adapter class

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String myTitlesssss[];
        String myDescriptionsssss[];
        int[] imgsssss;

        MyAdapter(Context c, String[] titlesssss, int[] imgsssss, String[] descriptionsssss){
            super(c, R.layout.colon, R.id.texttttt1, titlesssss);
            this.context=c;
            this.imgsssss=imgsssss;
            this.myTitlesssss=titlesssss;
            this.myDescriptionsssss=descriptionsssss;


        }
        //Type this manually like@NonNull because it retrieve the wrong library
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View colonnnn = layoutInflater.inflate(R.layout.colonnnn, parent, false);
            ImageView imagesssss = colonnnn.findViewById(R.id.logooooo);
            TextView myTitleeeee = colonnnn.findViewById(R.id.texttttt1);
            TextView myDescriptionnnnn = colonnnn.findViewById(R.id.texttttt2);
            imagesssss.setImageResource(imgsssss[position]);
            myTitleeeee.setText(titlesssss[position]);
            myDescriptionnnnn.setText(descriptionsssss[position]);
            return colonnnn;
        }
    }
}
