package com.example.last.bbathirdsemester;

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

public class Old_question_of_business_communication extends AppCompatActivity {

    ListView listtt;
    // add all the title and description and image on assending order
    String titlesss[] = {"   Old Question 2019", "   Old Question 2018", "   Old Question 2017", "   Old Question 2016", "   Old Question 2015"};
    String descriptionsss[] = {"   ", "   ", "   ", "   ", "   "};
    int imgsss[] = {R.drawable.finance, R.drawable.informationsystem, R.drawable.businesscommunication, R.drawable.statistics, R.drawable.formula};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_question_of_business_communication);

        getSupportActionBar().setTitle("Business Communication");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        listtt = findViewById(R.id.listtt1);
        runAnimation(listtt,0);


        //creating instance of class Adapter

        MyAdapter adapter = new MyAdapter(this, titlesss, imgsss, descriptionsss);

        //set adapter to list
        listtt.setAdapter(adapter);

        // IMPORTANT PART
        // HAndle items onclick Listener  in this example there is tost we have to add intent while we are working


        listtt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){

                    Intent Englih1 = new Intent(Old_question_of_business_communication.this, Old_question_of_english_2019.class);
                    startActivity(Englih1);

                }
                if (position==1){

                    Intent Englih2 = new Intent(Old_question_of_business_communication.this, Old_question_of_english_2018.class);
                    startActivity(Englih2);
                }
                if (position==2){

                    Intent Englih3 = new Intent(Old_question_of_business_communication.this, Old_question_of_english_2017.class);
                    startActivity(Englih3);
                }
                if (position==3){

                    Intent Englih4 = new Intent(Old_question_of_business_communication.this, Old_question_of_english_2016.class);
                    startActivity(Englih4);
                }
                if (position==4){

                    Intent Englih5 = new Intent(Old_question_of_business_communication.this, Old_question_of_english_2015.class);
                    startActivity(Englih5);
                }
            }
        });




    }

    private void runAnimation(ListView listtt, int type) {
        Context context = listtt.getContext();
        LayoutAnimationController controller = null;

        if (type ==0)
            controller = AnimationUtils.loadLayoutAnimation(context,R.anim.layout_slide_from_right);


        listtt.setLayoutAnimation(controller);
        listtt.scheduleLayoutAnimation();
    }


    //Create Custom Adapter class

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String myTitlesss[];
        String myDescriptionsss[];
        int[] imgsss;

        MyAdapter(Context ccc, String[] titlesss, int[] imgsss, String[] descriptionsss){
            super(ccc, R.layout.colon, R.id.texttt1, titlesss);
            this.context=ccc;
            this.imgsss=imgsss;
            this.myTitlesss=titlesss;
            this.myDescriptionsss=descriptionsss;


        }
        //Type this manually like@NonNull because it retrieve the wrong library
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View colonn = layoutInflater.inflate(R.layout.colonn, parent, false);
            ImageView imagesss = colonn.findViewById(R.id.logooo);
            TextView myTitleee = colonn.findViewById(R.id.texttt1);
            TextView myDescriptionnn = colonn.findViewById(R.id.texttt2);
            imagesss.setImageResource(imgsss[position]);
            myTitleee.setText(titlesss[position]);
            myDescriptionnn.setText(descriptionsss[position]);
            return colonn;
        }

    }
}
