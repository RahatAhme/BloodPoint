package com.soft_scatch.rahat.bloodpoint;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Ambulance_Activity extends AppCompatActivity {

    AutoCompleteTextView subdistrict;
    Button ambulanceSearch;
    android.support.v7.widget.Toolbar toolbar;
    ImageView ambuImage;
    String selectedSubDistrict;
    String [] subDistrictAray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance_);


        subdistrict = findViewById(R.id.ambuSubDisAutoTextID);
        ambulanceSearch = findViewById(R.id.ambulButtonIID);
        ambuImage = findViewById(R.id.ambuImageID);
        toolbar = findViewById(R.id.toolBarId);
        toolbar.setTitle("Ambulance Search");


        subDistrictAray = getResources().getStringArray(R.array.Subdistrict_name);
        final ArrayAdapter<String> subDisadapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,subDistrictAray);
        subdistrict.setThreshold(1);
        subdistrict.setAdapter(subDisadapter);
        subdistrict.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedSubDistrict=subdistrict.getText().toString();
            }
        });

        ambulanceSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedSubDistrict.isEmpty()){
                    Toast.makeText(Ambulance_Activity.this, "select a sub district first", Toast.LENGTH_SHORT).show();
                }
         else {
               Intent intent = new Intent(getApplicationContext(),AmbuListView_Activity.class);
               intent.putExtra("sub",selectedSubDistrict);
               startActivity(intent);
           }
            }
        });
    }
}
