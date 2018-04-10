package com.soft_scatch.rahat.bloodpoint;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Core_Activity extends AppCompatActivity implements View.OnClickListener{


    android.support.v7.widget.Toolbar toolbar;
    Button notification,feedback,addDoner,request,search,tips,ambulance,statistics,premanage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_core_);

        toolbar = findViewById(R.id.coretoolbarid);
        toolbar.setTitle(getResources().getString(R.string.app_name));

        notification= findViewById(R.id.notifyButtonID);
        feedback= findViewById(R.id.responsButtonID);
        addDoner= findViewById(R.id.addDonerButtonID);
        request= findViewById(R.id.requestButtonID);
        search= findViewById(R.id.localityButoonID);
        tips= findViewById(R.id.tipsButtonID);
        ambulance= findViewById(R.id.ambulanceButtonID);
        statistics= findViewById(R.id.statisticButtonID);
        premanage= findViewById(R.id.preManageButtonID);

        notification.setOnClickListener(this);
        feedback.setOnClickListener(this);
        addDoner.setOnClickListener(this);
        request.setOnClickListener(this);
        search.setOnClickListener(this);
        tips.setOnClickListener(this);
        ambulance.setOnClickListener(this);
        statistics.setOnClickListener(this);
        premanage.setOnClickListener(this);


    }
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.simplemenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.logOutID){
            SharedPreferences sp = getSharedPreferences("details", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("stored_user",null);
            editor.commit();
            Intent intent= new Intent(Core_Activity.this,Personal_Details_Activity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id==R.id.notifyButtonID){

        }else if(id==R.id.responsButtonID){

        }else if (id==R.id.addDonerButtonID){
            Intent intent = new Intent(Core_Activity.this,Personal_Details_Activity.class);
            startActivity(intent);
        }else if(id==R.id.requestButtonID){
            Intent intent = new Intent(Core_Activity.this,Request_Activity.class);
            startActivity(intent);
        }else if(id==R.id.localityButoonID){
            Intent intent = new Intent(Core_Activity.this,Request_Activity.class);
            startActivity(intent);
        }else if(id==R.id.preManageButtonID){
            Intent intent = new Intent(Core_Activity.this,Request_Activity.class);
            startActivity(intent);

        }else if(id==R.id.ambulanceButtonID){
            Intent intent = new Intent(Core_Activity.this,Request_Activity.class);
            startActivity(intent);
        }else if(id==R.id.tipsButtonID){
            Intent intent = new Intent(Core_Activity.this,Request_Activity.class);
            startActivity(intent);
        }else if(id==R.id.statisticButtonID){
            Intent intent = new Intent(Core_Activity.this,Request_Activity.class);
            startActivity(intent);
        }
    }
}
