package com.example.last.bbathirdsemester;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
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

public class Business_communication_unit_one extends AppCompatActivity {

    ListView listt;
    // add all the title and description and image on assending order
    String titless[] = {"Chapter One", "Chapter Two", "Chapter Three", "Chapter Four", "Chapter five", "Chapter Six", "Chapter Seven"};
    String descriptionss[] = {"The Three Sector of the Economy", "Management", "Company Structure", "Work and Motivation", "Management and Cultural Diversity", "Recuitment", "Labour relations"};
    int imgss[] = {R.drawable.finance, R.drawable.informationsystem, R.drawable.businesscommunication, R.drawable.statistics, R.drawable.formula, R.drawable.finance, R.drawable.informationsystem};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_communication_all_units);

        getSupportActionBar().setTitle("Unit One ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listt = findViewById(R.id.english_unit_one);
        runAnimation(listt,0);


        //creating instance of class Adapter

        MyAdapter adapter = new MyAdapter(this, titless, imgss, descriptionss);

        //set adapter to list
        listt.setAdapter(adapter);

        // IMPORTANT PART
        // HAndle items onclick Listener  in this example there is tost we have to add intent while we are working


        listt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){

                    Intent englishchapterone = new Intent(Business_communication_unit_one.this, English_chapter_one.class);
                    startActivity(englishchapterone);

                }
                if (position==1){

                    Intent englishchaptertwo = new Intent(Business_communication_unit_one.this, English_chapter_two.class);
                    startActivity(englishchaptertwo);

                }
                if (position==2){
                    Intent englishchapterthree = new Intent(Business_communication_unit_one.this, English_chapter_three.class);
                    startActivity(englishchapterthree);
                }
                if (position==3){
                    Intent englishchapterfour = new Intent(Business_communication_unit_one.this, English_chapter_four.class);
                    startActivity(englishchapterfour);
                }
                if (position==4){
                    Intent englishchapterfive = new Intent(Business_communication_unit_one.this, English_chapter_five.class);
                    startActivity(englishchapterfive);
                }
                if (position==5){
                    Intent englishchaptersix = new Intent(Business_communication_unit_one.this, English_chapter_six.class);
                    startActivity(englishchaptersix);
                }
                if (position==6){
                    Intent englishchapterseven = new Intent(Business_communication_unit_one.this, English_chapter_seven.class);
                    startActivity(englishchapterseven);
                }

            }
        });




    }

    private void runAnimation(ListView listt, int type) {
        Context context = listt.getContext();
        LayoutAnimationController controller = null;

        if (type ==0)
            controller = AnimationUtils.loadLayoutAnimation(context,R.anim.layout_slide_from_right);


        listt.setLayoutAnimation(controller);
        listt.scheduleLayoutAnimation();
    }


    //Create Custom Adapter class

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String myTitless[];
        String myDescriptionss[];
        int[] imgss;

        MyAdapter(Context cc, String[] titless, int[] imgss, String[] descriptionss){
            super(cc, R.layout.colon, R.id.textt1, titless);
            this.context=cc;
            this.imgss=imgss;
            this.myTitless=titless;
            this.myDescriptionss=descriptionss;


        }
        //Type this manually like@NonNull because it retrieve the wrong library
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View colon = layoutInflater.inflate(R.layout.colon, parent, false);
            ImageView imagess = colon.findViewById(R.id.logoo);
            TextView myTitlee = colon.findViewById(R.id.textt1);
            TextView myDescriptionn = colon.findViewById(R.id.textt2);
            imagess.setImageResource(imgss[position]);
            myTitlee.setText(titless[position]);
            myDescriptionn.setText(descriptionss[position]);
            return colon;
        }
    }
}
