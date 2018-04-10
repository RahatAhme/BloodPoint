package com.soft_scatch.rahat.bloodpoint;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class Personal_Details_Activity extends AppCompatActivity {

    private DatePickerDialog.OnDateSetListener mDateSetListener;
    EditText name,mobile, birthday;
    AutoCompleteTextView district,subDistrict;
    Spinner genderSpinner,bloodGroupSpinner;
    Button donerAdd;
    DBHelper helper = new DBHelper(this);
    String selectedDistrict,selectedSubDistrict,selectedGender,selectedbg;
    String[] bloodGroupArray;
    String[] genderArray;
    String [] discrictName;
    String [] SubdiscrictName;
    String birthDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal__details_);

        name = findViewById(R.id.donerNameID);
        mobile = findViewById(R.id.donerMobileID);
        birthday = findViewById(R.id.BDTextID);
        district = findViewById(R.id.districtID);
        subDistrict = findViewById(R.id.subDistrictID);
        genderSpinner = findViewById(R.id.sexSpinnerID);
        bloodGroupSpinner = findViewById(R.id.reqbgSpinnerID);
        donerAdd = findViewById(R.id.addDonerButtonID);


        bloodGroupArray = getResources().getStringArray(R.array.bloodGroups);
        ArrayAdapter<String> bgadapter = new ArrayAdapter<String>(this,R.layout.sample_view,R.id.testViewSampleID,bloodGroupArray);
        bloodGroupSpinner.setAdapter(bgadapter);
       selectedbg= bloodGroupSpinner.getSelectedItem().toString();

        genderArray = getResources().getStringArray(R.array.genders);
        ArrayAdapter<String> genderAdapter = new ArrayAdapter<String>(this,R.layout.sample_view,R.id.testViewSampleID,genderArray);
        genderSpinner.setAdapter(genderAdapter);
        selectedGender = genderSpinner.getSelectedItem().toString();

        discrictName = getResources().getStringArray(R.array.district_name);
        ArrayAdapter<String> disadapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,discrictName);
        district.setThreshold(1);
        district.setAdapter(disadapter);

        district.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedDistrict =  district.getText().toString();
            }
        });

        SubdiscrictName = getResources().getStringArray(R.array.Subdistrict_name);
        ArrayAdapter<String> subDisadapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,SubdiscrictName);
        subDistrict.setThreshold(1);
        subDistrict.setAdapter(subDisadapter);
        subDistrict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedSubDistrict =  subDistrict.getText().toString();
            }
        });

        birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        Personal_Details_Activity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d("date", "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);
                String date = day + "/" + month + "/" + year;
                birthday.setText(date);
                birthDate = birthday.getText().toString();
            }
        };

      donerAdd.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              String donerName = name.getText().toString();
              String mobileNO = mobile.getText().toString();
              long isInserted = helper.insert_doner_data(donerName,selectedGender,selectedbg,selectedDistrict,selectedSubDistrict,mobileNO);
              if(isInserted!= -1){
                  Toast.makeText(Personal_Details_Activity.this, "Doner is added", Toast.LENGTH_SHORT).show();
                  Intent intent = new Intent(Personal_Details_Activity.this,Core_Activity.class);
                  startActivity(intent);
              }
          }
      });

    }


}
