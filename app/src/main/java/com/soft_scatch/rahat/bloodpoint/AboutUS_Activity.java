package com.soft_scatch.rahat.bloodpoint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutUS_Activity extends AppCompatActivity {
    android.support.v7.widget.Toolbar toolbar;
    ImageView phot;
    TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us_);

        toolbar= findViewById(R.id.usBarId);
        phot= findViewById(R.id.meID);
        toolbar.setTitle("About Us");

    }
}
