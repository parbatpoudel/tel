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

public class  Account_all_chapter extends AppCompatActivity {

    ListView list;
    // add all the title and description and image on assending order
    String titles[] = {"Chapter One", "Chapter Two", "Chapter Three", "Chapter Four", "Chapter five", "Chapter Six", "Chapter Seven", "Chapter Eight",  "Chapter Nine", "Chapter Ten"};
    String descriptions[] = {"Introduction", "General Accepted Accounting Principles", "Double Entry System", "Recording of Business Transaction", "Sub-division of Journal", "Accounting of Cash and Banking Transaction", "Trial Balance", "Reserve and Provision", "Capital and Revenue Concept and Creditiors", "Financial Statement"};
    int imgs[] = {R.drawable.finance, R.drawable.informationsystem, R.drawable.businesscommunication, R.drawable.statistics, R.drawable.formula, R.drawable.finance, R.drawable.informationsystem, R.drawable.businesscommunication, R.drawable.statistics, R.drawable.formula};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_all_chapter);

        getSupportActionBar().setTitle("Financial Accounting");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        list = findViewById(R.id.list1);

        runAnimation(list,0);

        //creating instance of class Adapter

        MyAdapter adapter = new MyAdapter(this, titles, imgs, descriptions);

        //set adapter to list
        list.setAdapter(adapter);

        // IMPORTANT PART
        // HAndle items onclick Listener  in this example there is tost we have to add intent while we are working


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){


                    Toast.makeText(Account_all_chapter.this, "Chapter One Clicked... ", Toast.LENGTH_SHORT).show();
                }
                if (position==1){


                    Toast.makeText(Account_all_chapter.this, "Chapter Two Clicked... ", Toast.LENGTH_SHORT).show();
                }
                if (position==2){

                    Toast.makeText(Account_all_chapter.this, "Chapter Three Clicked... ", Toast.LENGTH_SHORT).show();
                }
                if (position==3){

                    Toast.makeText(Account_all_chapter.this, "Chapter Four Clicked... ", Toast.LENGTH_SHORT).show();
                }
                if (position==4){

                    Toast.makeText(Account_all_chapter.this, "Chapter Five Clicked... ", Toast.LENGTH_SHORT).show();
                }
                if (position==5){

                    Toast.makeText(Account_all_chapter.this, "Chapter Six Clicked... ", Toast.LENGTH_SHORT).show();
                }
                if (position==6){

                    Toast.makeText(Account_all_chapter.this, "Chapter Seven Clicked... ", Toast.LENGTH_SHORT).show();
                }
                if (position==7){

                    Toast.makeText(Account_all_chapter.this, "Chapter Eight Clicked... ", Toast.LENGTH_SHORT).show();
                }
                if (position==8){

                    Toast.makeText(Account_all_chapter.this, "Chapter Nine Clicked... ", Toast.LENGTH_SHORT).show();
                }
                if (position==9){

                    Toast.makeText(Account_all_chapter.this, "Chapter Ten Clicked... ", Toast.LENGTH_SHORT).show();
                }

            }
        });




    }

    private void runAnimation(ListView list, int type) {
        Context context = list.getContext();
        LayoutAnimationController controller = null;

        if (type ==0)
            controller = AnimationUtils.loadLayoutAnimation(context,R.anim.layout_slide_from_right);


        list.setLayoutAnimation(controller);
        list.scheduleLayoutAnimation();
    }


    //Create Custom Adapter class

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String myTitles[];
        String myDescriptions[];
        int[] imgs;

        MyAdapter(Context c, String[] titles, int[] imgs, String[] descriptions){
            super(c, R.layout.row, R.id.text1, titles);
            this.context=c;
            this.imgs=imgs;
            this.myTitles=titles;
            this.myDescriptions=descriptions;


        }
        //Type this manually like@NonNull because it retrieve the wrong library
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.logo);
            TextView myTitle = row.findViewById(R.id.text1);
            TextView myDescription = row.findViewById(R.id.text2);
            images.setImageResource(imgs[position]);
            myTitle.setText(titles[position]);
            myDescription.setText(descriptions[position]);
            return row;
        }
    }
}
