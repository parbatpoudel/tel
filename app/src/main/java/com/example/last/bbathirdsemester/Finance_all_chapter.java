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

public class Finance_all_chapter extends AppCompatActivity {

    ListView listt;
    // add all the title and description and image on assending order
    String titless[] = {"Chapter One", "Chapter Two", "Chapter Three", "Chapter Four", "Chapter five", "Chapter Six", "Chapter Seven", "Chapter Eight"};
    String descriptionss[] = {"Introduction", "Financial Statement Taxes and Cash Flow Analysis", "The Time Value of Money", "Risk and Return", "Bond Valuation and Stock Rate", "Stock Valuation", "Capital Budgeting Analysis", "Working Capital Management"};
    int imgss[] = {R.drawable.finance, R.drawable.informationsystem, R.drawable.businesscommunication, R.drawable.statistics, R.drawable.formula, R.drawable.finance, R.drawable.informationsystem, R.drawable.businesscommunication,};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance_all_chapter);

        getSupportActionBar().setTitle("Business Finance");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listt = findViewById(R.id.listt1);
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


                    Toast.makeText(Finance_all_chapter.this, "Chapter One Clicked... ", Toast.LENGTH_SHORT).show();
                }
                if (position==1){


                    Toast.makeText(Finance_all_chapter.this, "Chapter Two Clicked... ", Toast.LENGTH_SHORT).show();
                }
                if (position==2){

                    Toast.makeText(Finance_all_chapter.this, "Chapter Three Clicked... ", Toast.LENGTH_SHORT).show();
                }
                if (position==3){

                    Toast.makeText(Finance_all_chapter.this, "Chapter Four Clicked... ", Toast.LENGTH_SHORT).show();
                }
                if (position==4){

                    Toast.makeText(Finance_all_chapter.this, "Chapter FIve Clicked... ", Toast.LENGTH_SHORT).show();
                }
                if (position==5){

                    Toast.makeText(Finance_all_chapter.this, "Chapter Six Clicked... ", Toast.LENGTH_SHORT).show();
                }
                if (position==6){

                    Toast.makeText(Finance_all_chapter.this, "Chapter Seven Clicked... ", Toast.LENGTH_SHORT).show();
                }
                if (position==7){

                    Toast.makeText(Finance_all_chapter.this, "Chapter Eight Clicked... ", Toast.LENGTH_SHORT).show();
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
