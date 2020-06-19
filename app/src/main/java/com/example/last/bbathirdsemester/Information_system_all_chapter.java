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

public class Information_system_all_chapter extends AppCompatActivity {

    ListView listttt;
    // add all the title and description and image on assending order
    String titlessss[] = {"Chapter One", "Chapter Two", "Chapter Three", "Chapter Four", "Chapter five", "Chapter Six", "Chapter Seven", "Chapter Eight"};
    String descriptionssss[] = {"Information Systems In Gloabal Business Today", "Global e-business and Collaboration", "Information System, Organization and Strategy", "Ethical and Social issues in Information System", "Information Technology Infrastructure", "Foundation of Businesss Intelligence", "Security Information System", "Building Information System"};
    int imgssss[] = {R.drawable.finance, R.drawable.informationsystem, R.drawable.businesscommunication, R.drawable.statistics, R.drawable.formula, R.drawable.finance, R.drawable.informationsystem, R.drawable.businesscommunication};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_system_all_chapter);

        getSupportActionBar().setTitle("Management Information System");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        listttt = findViewById(R.id.listttt1);
        runAnimation(listttt,0);


        //creating instance of class Adapter

        MyAdapter adapter = new MyAdapter(this, titlessss, imgssss, descriptionssss);

        //set adapter to list
        listttt.setAdapter(adapter);

        // IMPORTANT PART
        // HAndle items onclick Listener  in this example there is tost we have to add intent while we are working


        listttt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent chapteroneinfosys = new Intent(Information_system_all_chapter.this, Information_system_chapter_one.class);
                    startActivity(chapteroneinfosys);
                }
                if (position==1){
                    Intent chaptertwoinfosys = new Intent(Information_system_all_chapter.this, Information_system_chapter_two.class);
                    startActivity(chaptertwoinfosys);
                }
                if (position==2){
                    Intent chapterthreeinfosys = new Intent(Information_system_all_chapter.this, Information_system_chapter_three.class);
                    startActivity(chapterthreeinfosys);
                }
                if (position==3){
                    Intent chapterfourinfosys = new Intent(Information_system_all_chapter.this, Information_system_chapter_four.class);
                    startActivity(chapterfourinfosys);
                }
                if (position==4){
                    Intent chapterfiveinfosys = new Intent(Information_system_all_chapter.this, Information_system_chapter_five.class);
                    startActivity(chapterfiveinfosys);
                }
                if (position==5){
                    Intent chaptersixinfosys = new Intent(Information_system_all_chapter.this, Information_system_chapter_six.class);
                    startActivity(chaptersixinfosys);
                }
                if (position==6){
                    Intent chapterseveninfosys = new Intent(Information_system_all_chapter.this, Information_system_chapter_seven.class);
                    startActivity(chapterseveninfosys);
                }
                if (position==7){
                    Intent chaptereightinfosys = new Intent(Information_system_all_chapter.this, Information_system_chapter_eight.class);
                    startActivity(chaptereightinfosys);
                }

            }
        });




    }

    private void runAnimation(ListView listttt, int type) {
        Context context = listttt.getContext();
        LayoutAnimationController controller = null;

        if (type ==0)
            controller = AnimationUtils.loadLayoutAnimation(context,R.anim.layout_slide_from_right);


        listttt.setLayoutAnimation(controller);
        listttt.scheduleLayoutAnimation();
    }


    //Create Custom Adapter class

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String myTitlessss[];
        String myDescriptionssss[];
        int[] imgssss;

        MyAdapter(Context c, String[] titlessss, int[] imgssss, String[] descriptionssss){
            super(c, R.layout.colon, R.id.textttt1, titlessss);
            this.context=c;
            this.imgssss=imgssss;
            this.myTitlessss=titlessss;
            this.myDescriptionssss=descriptionssss;


        }
        //Type this manually like@NonNull because it retrieve the wrong library
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View colonnn = layoutInflater.inflate(R.layout.colonnn, parent, false);
            ImageView imagessss = colonnn.findViewById(R.id.logoooo);
            TextView myTitleeee = colonnn.findViewById(R.id.textttt1);
            TextView myDescriptionnnn = colonnn.findViewById(R.id.textttt2);
            imagessss.setImageResource(imgssss[position]);
            myTitleeee.setText(titlessss[position]);
            myDescriptionnnn.setText(descriptionssss[position]);
            return colonnn;
        }
    }
}
