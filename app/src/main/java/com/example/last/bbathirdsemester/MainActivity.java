package com.example.last.bbathirdsemester;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Button business_communication, business_finance, statistics, account, information_system, formula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        business_communication = (Button) findViewById(R.id.business_communication);
        business_finance = (Button) findViewById(R.id.business_finance);
        statistics = (Button) findViewById(R.id.statistics);
        account = (Button) findViewById(R.id.account);
        information_system = (Button) findViewById(R.id.information_system);
        formula = (Button) findViewById(R.id.formula);


        business_communication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent communication = new Intent(MainActivity.this, Business_communication_all_chapter.class);
                startActivity(communication);
            }
        });

        business_finance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent finance = new Intent(MainActivity.this, Finance_all_chapter.class);
                startActivity(finance);
            }
        });

        statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent statistics = new Intent(MainActivity.this, Statistics_all_chapter.class);
                startActivity(statistics);
            }
        });

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent account = new Intent(MainActivity.this, Account_all_chapter.class);
                startActivity(account);
            }
        });

        formula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent formula = new Intent(MainActivity.this, Formula_all_subject.class);
                startActivity(formula);
            }
        });

        information_system.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent information_system = new Intent(MainActivity.this, Information_system_all_chapter.class);
                startActivity(information_system);
            }
        });



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.setting) {
            Toast.makeText(MainActivity.this, "Setting ", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.description) {
            Toast.makeText(MainActivity.this, "Descriptions", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.about_us) {
            Toast.makeText(MainActivity.this, "About Us", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.syllabus) {

            Intent syllabuss = new Intent(MainActivity.this,Syllabus_all_subject.class);
            startActivity(syllabuss);

        } else if (id == R.id.old_questions) {

            Intent old_questions = new Intent(MainActivity.this,Old_questions_all_subject.class);
            startActivity(old_questions);

        } else if (id == R.id.solution) {

            Intent old_questionssoln = new Intent(MainActivity.this,Old_questions_solution_all_subject.class);
            startActivity(old_questionssoln);

        } else if (id == R.id.exam_center) {

            Toast.makeText(MainActivity.this, "Not Published Yet !!!", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.result) {

            Toast.makeText(MainActivity.this, "Not Published Yet !!!", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        } else if (id == R.id.nav_rate) {

        } else if (id == R.id.bba_first_semester) {

            Toast.makeText(MainActivity.this, "Not Published Yet !!!", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.bba_second_semester) {

            Toast.makeText(MainActivity.this, "Not Published Yet !!!", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.bba_four_semsester) {

            Toast.makeText(MainActivity.this, "Not Published Yet !!!", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.bba_five_semsester) {

            Toast.makeText(MainActivity.this, "Not Published Yet !!!", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.bba_six_semsester) {

            Toast.makeText(MainActivity.this, "Not Published Yet !!!", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.bba_seven_semsester) {

            Toast.makeText(MainActivity.this, "Not Published Yet !!!", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.bba_eight_semsester) {

            Toast.makeText(MainActivity.this, "Not Published Yet !!!", Toast.LENGTH_SHORT).show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
