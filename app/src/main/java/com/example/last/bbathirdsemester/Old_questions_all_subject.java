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

public class Old_questions_all_subject extends AppCompatActivity {

    ListView listtttt;
    // add all the title and description and image on assending order
    String titlesssss[] = {"Business Finance", "Management Information System", "Business Communication", "Business Statistics", "Financial Accounting"};
    String descriptionsssss[] = {"   ", "   ", "   ", "   ", "   "};
    int imgsssss[] = {R.drawable.finance, R.drawable.informationsystem, R.drawable.businesscommunication, R.drawable.statistics, R.drawable.account};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_questions_all_subject);

        getSupportActionBar().setTitle("Old Questions");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listtttt = findViewById(R.id.old_questions_navigation);
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

                    Intent busineesfinanold = new Intent(Old_questions_all_subject.this, Old_question_of_finance.class);
                    startActivity(busineesfinanold);
                }
                if (position==1){

                    Intent informationsysold = new Intent(Old_questions_all_subject.this, Old_question_of_information_system.class);
                    startActivity(informationsysold);
                }
                if (position==2){

                    Intent busineescommuold = new Intent(Old_questions_all_subject.this, Old_question_of_business_communication.class);
                    startActivity(busineescommuold);

                }
                if (position==3){

                    Intent busineesstatold = new Intent(Old_questions_all_subject.this, Old_question_of_statistics.class);
                    startActivity(busineesstatold);

                }
                if (position==4){

                    Intent finaccold = new Intent(Old_questions_all_subject.this, Old_question_of_account.class);
                    startActivity(finaccold);

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

        MyAdapter(Context ccccc, String[] titlesssss, int[] imgsssss, String[] descriptionsssss){
            super(ccccc, R.layout.colon, R.id.texttttt1, titlesssss);
            this.context=ccccc;
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
