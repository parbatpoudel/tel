package com.example.last.bbathirdsemester;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Formula_all_subject extends AppCompatActivity {
    Button formula_statistics, formula_business_finance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formula_all_subject);

        getSupportActionBar().setTitle("Formula");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        formula_statistics = (Button) findViewById(R.id.formula_statistics);
        formula_business_finance = (Button) findViewById(R.id.formula_business_finance);

        formula_statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent formulaa_businesss = new Intent(Formula_all_subject.this, Formula_statistics_all_chapter.class);
                startActivity(formulaa_businesss);
            }
        });

        formula_business_finance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent formulaa_business = new Intent(Formula_all_subject.this, Formula_finance_all_chapter.class);
                startActivity(formulaa_business);
            }
        });


    }
}
