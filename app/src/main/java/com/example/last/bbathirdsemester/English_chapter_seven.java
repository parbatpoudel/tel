package com.example.last.bbathirdsemester;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class English_chapter_seven extends AppCompatActivity {

    private TextView chapter_seven_english_text;
    private PDFView chapter_seven_english;

    private ProgressDialog dialog;


    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference mref=database.getReference("business_communication_chapter_seven");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_chapter_seven);

        getSupportActionBar().setTitle("Chapter Seven English");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        chapter_seven_english = (PDFView) findViewById(R.id.chapter_seven_english);
        chapter_seven_english_text = (TextView) findViewById(R.id.chapter_seven_english_text);

        dialog = new ProgressDialog(English_chapter_seven.this);
        dialog.setTitle("Loading...");
        dialog.setMessage("need internet connection");
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String value=dataSnapshot.getValue(String.class);
                chapter_seven_english_text.setText(value);
                String Url=chapter_seven_english_text.getText().toString();
                new RetrievePdfStream().execute(Url);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


            }
        });}

    class RetrievePdfStream extends AsyncTask<String,Void, InputStream> {

        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream = null;
            try{
                URL url = new  URL (strings[0]);
                HttpsURLConnection urlConnection = (HttpsURLConnection)url.openConnection();
                if (urlConnection.getResponseCode()==200)
                {
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                }
            }catch (IOException e){
                return null;
            }
            return inputStream;

        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            chapter_seven_english.fromStream(inputStream).load();
            if (dialog.isShowing()){
                dialog.dismiss();
            }
        }

    }
}
