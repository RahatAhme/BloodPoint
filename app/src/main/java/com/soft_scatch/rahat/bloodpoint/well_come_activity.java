package com.soft_scatch.rahat.bloodpoint;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class well_come_activity extends AppCompatActivity {

    int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_well_come_activity);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                goToNet();
            }

        });
        thread.start();
    }

    public void doWork() {
        for (progress =50;progress <= 100;progress = progress+50){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void goToNet() {
        SharedPreferences sp = getSharedPreferences("details", Context.MODE_PRIVATE);
        if(sp.contains("stored_user")){
            Intent intent = new Intent(getApplicationContext(),Core_Activity.class);
            startActivity(intent);
        }else {
            Intent intent = new Intent(getApplicationContext(), Log_in_Activity.class);
            startActivity(intent);
        }
    }
}
