package com.soft_scatch.rahat.bloodpoint;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
    fire_helper fireHelper = new fire_helper(this);
    String selectedDistrict,selectedSubDistrict,selectedGender,selectedbg,donerName,mobileNO;
    String[] bloodGroupArray;
    String[] genderArray;
    String[] discrictName;
    String[] SubdiscrictName;
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
        donerAdd = findViewById(R.id.doneriid);


        bloodGroupArray = getResources().getStringArray(R.array.bloodGroups);
        ArrayAdapter<String> bgadapter = new ArrayAdapter <String>(this,R.layout.sample_view,R.id.testViewSampleID,bloodGroupArray);
        bloodGroupSpinner.setAdapter(bgadapter);




        genderArray = getResources().getStringArray(R.array.genders);
        ArrayAdapter<String> genderAdapter = new ArrayAdapter<String>(this,R.layout.sample_view,R.id.testViewSampleID,genderArray);
        genderSpinner.setAdapter(genderAdapter);




        discrictName = getResources().getStringArray(R.array.district_name);
        ArrayAdapter<String> disadapter = new ArrayAdapter<String>(this,R.layout.sample_view,R.id.testViewSampleID,discrictName);
        district.setThreshold(1);
        district.setAdapter(disadapter);
      district.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               selectedDistrict = district.getText().toString();
          }
      });

        SubdiscrictName = getResources().getStringArray(R.array.Subdistrict_name);
        final ArrayAdapter<String> subDisadapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,SubdiscrictName);
        subDistrict.setThreshold(1);
        subDistrict.setAdapter(subDisadapter);
        subDistrict.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedSubDistrict=subDistrict.getText().toString();
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

            }
        };

      donerAdd.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
           donerName = name.getText().toString();
           mobileNO = mobile.getText().toString();
           selectedbg= bloodGroupSpinner.getSelectedItem().toString();
           selectedGender = genderSpinner.getSelectedItem().toString();
             birthDate = birthday.getText().toString();
if(donerName.isEmpty()||mobileNO.isEmpty()||birthDate.isEmpty()||selectedDistrict.isEmpty()||selectedSubDistrict.isEmpty()){
    Toast.makeText(Personal_Details_Activity.this, "Please enter all the data first", Toast.LENGTH_SHORT).show();

}else if(mobileNO.length()!=11){
    Toast.makeText(Personal_Details_Activity.this, "Invalid Mobile No", Toast.LENGTH_SHORT).show();
}else if(selectedbg.contains("Blood Group")){
    Toast.makeText(Personal_Details_Activity.this, "Select your blood group", Toast.LENGTH_SHORT).show();
}else if (selectedGender.contains("Sex")){
    Toast.makeText(Personal_Details_Activity.this, "Select your gender", Toast.LENGTH_SHORT).show();
}else {
    fireHelper.donerAdder(donerName, mobileNO, selectedbg, selectedDistrict, selectedSubDistrict, birthDate, selectedGender);
    Intent intent = new Intent(Personal_Details_Activity.this, navigation_drawer.class);
    startActivity(intent);
}
          }
      });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Personal_Details_Activity.this,navigation_drawer.class);
        startActivity(intent);
        super.onBackPressed();
    }
}
