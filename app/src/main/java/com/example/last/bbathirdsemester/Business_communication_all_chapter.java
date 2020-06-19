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
import android.widget.Toast;

public class Business_communication_all_chapter extends AppCompatActivity {

    ListView listtt;
    // add all the title and description and image on assending order
    String titlesss[] = {"Unit One", "Unit Two", "Unit Three", "Unit Four", "Unit five"};
    String descriptionsss[] = {"   Management", "   Production and Marketing", "   Finance", "   Economics", "   Technical Communication"};
    int imgsss[] = {R.drawable.finance, R.drawable.informationsystem, R.drawable.businesscommunication, R.drawable.statistics, R.drawable.formula};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_communication_all_chapter);

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

                    Intent Englih1 = new Intent(Business_communication_all_chapter.this, Business_communication_unit_one.class);
                    startActivity(Englih1);

                }
                if (position==1){

                    Intent Englih2 = new Intent(Business_communication_all_chapter.this, Business_communication_unit_two.class);
                    startActivity(Englih2);
                }
                if (position==2){

                    Intent Englih3 = new Intent(Business_communication_all_chapter.this, Business_communication_unit_three.class);
                    startActivity(Englih3);
                }
                if (position==3){

                    Intent Englih4 = new Intent(Business_communication_all_chapter.this, Business_communication_unit_four.class);
                    startActivity(Englih4);
                }
                if (position==4){

                    Intent Englih5 = new Intent(Business_communication_all_chapter.this, Business_communication_unit_five.class);
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
