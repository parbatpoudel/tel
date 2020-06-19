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

public class Business_communication_unit_two extends AppCompatActivity {

    ListView listttt;
    // add all the title and description and image on assending order
    String titlessss[] = {"Chapter One", "Chapter Two", "Chapter Three", "Chapter Four", "Chapter five"};
    String descriptionssss[] = {"   Production", "   Products", "   Marketing ", "   Advertising", "   Promotional Tools"};
    int imgssss[] = {R.drawable.finance, R.drawable.informationsystem, R.drawable.businesscommunication, R.drawable.statistics, R.drawable.formula};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_communication_unit_two);


        getSupportActionBar().setTitle("Unit Two ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listttt = findViewById(R.id.english_unit_two);
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


                    Toast.makeText(Business_communication_unit_two.this, "Chapter One Clicked... ", Toast.LENGTH_SHORT).show();
                }
                if (position==1){


                    Toast.makeText(Business_communication_unit_two.this, "Chapter Two Clicked... ", Toast.LENGTH_SHORT).show();
                }
                if (position==2){

                    Toast.makeText(Business_communication_unit_two.this, "Chapter Three Clicked... ", Toast.LENGTH_SHORT).show();
                }
                if (position==3){

                    Toast.makeText(Business_communication_unit_two.this, "Chapter Four Clicked... ", Toast.LENGTH_SHORT).show();
                }
                if (position==3){

                    Toast.makeText(Business_communication_unit_two.this, "Chapter Five Clicked... ", Toast.LENGTH_SHORT).show();
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
