package com.soft_scatch.rahat.bloodpoint;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Add_Ambu_Activity extends AppCompatActivity {

    android.support.v7.widget.Toolbar ambutoolbar;
    EditText ambuHospital,ambuMobile;
    Button ambuAdder;
    LinearLayout ambulayout;
    String[] SubdiscrictName;
    AutoCompleteTextView ambuSubdis;
    String selectedSubDistrict,hospitalName,mobile;
    fire_helper fireHelper = new fire_helper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__ambu_);


        ambutoolbar = findViewById(R.id.ambuToolID);
        ambuAdder = findViewById(R.id.ambuAddButtonID);
        ambuSubdis = findViewById(R.id.ambuSubDisTrict);
        ambuHospital = findViewById(R.id.ambuHospitalID);
        ambuMobile = findViewById(R.id.ambuMobilelID);

        SubdiscrictName = getResources().getStringArray(R.array.Subdistrict_name);
        final ArrayAdapter<String> subDisadapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,SubdiscrictName);
        ambuSubdis.setThreshold(1);
        ambuSubdis.setAdapter(subDisadapter);
        ambuSubdis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedSubDistrict=ambuSubdis.getText().toString();
            }
        });

        ambuAdder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hospitalName=ambuHospital.getText().toString();
               mobile= ambuMobile.getText().toString();
          if (hospitalName.isEmpty()||mobile.isEmpty()||selectedSubDistrict.isEmpty()){
              Toast.makeText(Add_Ambu_Activity.this, "Please enter all the data first", Toast.LENGTH_SHORT).show();
          }else if (mobile.length()!=11){
              Toast.makeText(Add_Ambu_Activity.this, "Invalid Mobile No.", Toast.LENGTH_SHORT).show();
          }

          else {
              fireHelper.addAbulance(hospitalName,mobile,selectedSubDistrict);
              Intent intent= new Intent(Add_Ambu_Activity.this,navigation_drawer.class);
              startActivity(intent);
          }

            }
        });

    }
}
