package com.soft_scatch.rahat.bloodpoint;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class AmbuListView_Activity extends AppCompatActivity {

    android.support.v7.widget.Toolbar listtoolbar;
    TextView listView;
    FirebaseFirestore db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambu_list_view_);




        listtoolbar= findViewById(R.id.ambuListtoolbarID);
        listView = findViewById(R.id.ambulisttextViewID);

        Bundle obj = getIntent().getExtras();
        String subDistrict = obj.getString("sub");

        db= FirebaseFirestore.getInstance();
        db.collection("AMBULANCE_TABLE")
                .whereEqualTo("SUB_DISTRICT", subDistrict)

                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                String name =(String) document.get("HOSPITAL NAME");
                                String phone =(String) document.get("MOBILE");
                                listView.append("Hospital Name : "+name+"\nPhone No : " +phone+"\n\n");
                            }

                        } else {
                            Toast.makeText(getApplicationContext(), "No data available", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AmbuListView_Activity.this,navigation_drawer.class);
        startActivity(intent);
        super.onBackPressed();
    }

}
