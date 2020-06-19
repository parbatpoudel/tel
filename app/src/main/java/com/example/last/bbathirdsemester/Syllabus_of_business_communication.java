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

public class Syllabus_of_business_communication extends AppCompatActivity {

    private TextView syllabus_text_of_business_communication;
    private PDFView syllabus_of_business_communication;


    private ProgressDialog dialog;


    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference mref=database.getReference("syllabus_of_business_communication");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus_of_business_communication);

        getSupportActionBar().setTitle("Syllabus of English");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        syllabus_of_business_communication = (PDFView) findViewById(R.id.syllabus_of_business_communication);
        syllabus_text_of_business_communication = (TextView) findViewById(R.id.syllabus_text_of_business_communication);

        dialog = new ProgressDialog(Syllabus_of_business_communication.this);
        dialog.setTitle("Loading...");
        dialog.setMessage("need internet connection");
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String value=dataSnapshot.getValue(String.class);
                syllabus_text_of_business_communication.setText(value);
                String Url=syllabus_text_of_business_communication.getText().toString();
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
            syllabus_of_business_communication.fromStream(inputStream).load();

            if (dialog.isShowing()){
                dialog.dismiss();
            }
        }
    }
}
