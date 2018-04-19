package com.soft_scatch.rahat.bloodpoint;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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

public class navigation_drawer extends AppCompatActivity
        implements View.OnClickListener,NavigationView.OnNavigationItemSelectedListener {

    Button notification,feedback,addDoner,request,search,tips,ambulance,statistics,premanage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        notification= findViewById(R.id.notifyButtonID);
        feedback= findViewById(R.id.responsButtonID);
        addDoner= findViewById(R.id.doneriid);
        request= findViewById(R.id.requestButtonID);
        search= findViewById(R.id.localityButoonID);
        tips= findViewById(R.id.tipsButtonID);
        ambulance= findViewById(R.id.serchAmbuButtonIID);
        statistics= findViewById(R.id.statisticButtonID);
        premanage= findViewById(R.id.donorId);

        notification.setOnClickListener(this);
        feedback.setOnClickListener(this);
        addDoner.setOnClickListener(this);
        request.setOnClickListener(this);
        search.setOnClickListener(this);
        tips.setOnClickListener(this);
        ambulance.setOnClickListener(this);
        statistics.setOnClickListener(this);
        premanage.setOnClickListener(this);




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent =new Intent(getApplicationContext(),Personal_Details_Activity.class);
               startActivity(intent);
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
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_ambulance) {
            Intent intent = new Intent(getApplicationContext(),Add_Ambu_Activity.class);
            startActivity(intent);

        } else if (id == R.id.nav_rate_us) {

        } else if (id == R.id.nav_feedback) {
            Intent intent = new Intent(getApplicationContext(),Feed_Back_Activit.class);
            startActivity(intent);


        }  else if (id == R.id.nav_share) {


        } else if (id == R.id.nav_send) {
            Intent intent = new Intent(getApplicationContext(),AboutUS_Activity.class);
            startActivity(intent);

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id==R.id.notifyButtonID){
            Toast.makeText(this, "Empty Notification", Toast.LENGTH_SHORT).show();
        }else if(id==R.id.responsButtonID){
            Toast.makeText(this, "No Respons available", Toast.LENGTH_SHORT).show();

        }else if (id==R.id.doneriid){
            SharedPreferences sp = getSharedPreferences("details", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("stored_user",null);
            editor.commit();
            Intent intent= new Intent(navigation_drawer.this,Log_in_Activity.class);
            startActivity(intent);
        }else if(id==R.id.requestButtonID){
            Toast.makeText(this, "Upcoming Feature", Toast.LENGTH_SHORT).show();
        }else if(id==R.id.localityButoonID){
            Intent intent = new Intent(navigation_drawer.this,Search_with_Locality.class);
            startActivity(intent);
        }else if(id==R.id.serchAmbuButtonIID){
          Intent intent =new Intent(navigation_drawer.this,Ambulance_Activity.class);
          startActivity(intent);
        }else if(id==R.id.tipsButtonID){
            Intent intent = new Intent(navigation_drawer.this,Tips_for_doner_Activity.class);
            startActivity(intent);
        }else if(id==R.id.statisticButtonID){
            Toast.makeText(this, "Upcoming Feature", Toast.LENGTH_SHORT).show();
        }
        else if(id==R.id.donorId){
            Toast.makeText(this, "This feature will be available in next update", Toast.LENGTH_SHORT).show();
        }
    }


}

