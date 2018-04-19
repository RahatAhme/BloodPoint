package com.soft_scatch.rahat.bloodpoint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Tips_for_doner_Activity extends AppCompatActivity {
    LinearLayout linearLayout;
    TextView t1,t2,t3,t4,t5,t6,t7,t8;
    android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_for_doner_);

        t1=findViewById(R.id.bannerID);
        t2 =findViewById(R.id.inductionID);
        t3 =findViewById(R.id.beforBannerID);
        t4 =findViewById(R.id.beforID);
        t5 =findViewById(R.id.duringBannerID);
        t6 =findViewById(R.id.duringID);
        t7 =findViewById(R.id.afterBannerID);
        t8=findViewById(R.id.afterID);
        toolbar= findViewById(R.id.tipsBarId);
        toolbar.setTitle("Tips For Doners");
    }
}
