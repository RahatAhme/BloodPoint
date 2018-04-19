package com.soft_scatch.rahat.bloodpoint;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ToolbarWidgetWrapper;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Request_Activity extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbar;
    EditText hospitalName;
    AutoCompleteTextView requestedDistrict,requestedSubDistrict;
    Spinner requestedBloodGroup;
    String district,subditrict,hospitalname,bloodgroup;
    String[] reqbloodGroupArray;
    String[] districtArray;
    String[] subDistrictArray;
    Button sendReq;
    DBHelper helper = new DBHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_);
        toolbar = findViewById(R.id.reqesttoolbarid);
        toolbar.setTitle(getResources().getString(R.string.app_name));

        hospitalName = findViewById(R.id.hospitalTextID);
        requestedBloodGroup = findViewById(R.id.reqbgSpinnerID);
        requestedDistrict = findViewById(R.id.reqDistrictID);
        requestedSubDistrict = findViewById(R.id.reqSubDistrictID);
        sendReq = findViewById(R.id.sendRequestID);

        reqbloodGroupArray = getResources().getStringArray(R.array.bloodGroups);
        ArrayAdapter<String> bgadapter = new ArrayAdapter<String>(this,R.layout.sample_view,R.id.testViewSampleID,reqbloodGroupArray);
        requestedBloodGroup.setAdapter(bgadapter);
        bloodgroup= requestedBloodGroup.getSelectedItem().toString();

        districtArray = getResources().getStringArray(R.array.district_name);
        ArrayAdapter<String> disadapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,districtArray);
        requestedDistrict.setThreshold(1);
        requestedDistrict.setAdapter(disadapter);

        requestedDistrict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                district =  requestedDistrict.getText().toString();
            }
        });

        subDistrictArray = getResources().getStringArray(R.array.Subdistrict_name);
        final ArrayAdapter<String> subDisadapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,subDistrictArray);
        requestedSubDistrict.setThreshold(1);
        requestedSubDistrict.setAdapter(subDisadapter);
        requestedSubDistrict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subditrict =  requestedSubDistrict.getText().toString();
            }
        });

        sendReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hospitalname= hospitalName.getText().toString();

                Toast.makeText(Request_Activity.this, "Request is on process", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(Request_Activity.this,navigation_drawer.class);
                startActivity(intent);
                clean();
            }
        });
    }

    public void clean(){
        hospitalName.setText("");
        requestedDistrict.setText("");
        requestedSubDistrict.setText("");
    }
}
