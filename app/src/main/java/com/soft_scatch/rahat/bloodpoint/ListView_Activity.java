package com.soft_scatch.rahat.bloodpoint;

import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class ListView_Activity extends AppCompatActivity {

    TextView textView;
    android.support.v7.widget.Toolbar toolbar;
    FirebaseFirestore db;

    fire_helper fireHelper;
    String blood;
    String subdi;
    String dist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_);


        fireHelper = new fire_helper(this);

        Bundle obj = getIntent().getExtras();
        String variable = obj.getString("tag");
         blood = obj.getString("bg");
         dist = obj.getString("dis");
         subdi = obj.getString("subdis");


        textView = findViewById(R.id.textViewID);
        toolbar = findViewById(R.id.toolbarID);
        toolbar.setTitle(variable);
         db= FirebaseFirestore.getInstance();

        db.collection("DONER_INFO")
                .whereEqualTo("BLOOD", blood)
                .whereEqualTo("DISTRICT", dist)
                .whereEqualTo("SUB_DISTRICT", subdi)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                String name =(String) document.get("DONER NAME");
                                String phone =(String) document.get("MOBILE");
                                textView.append("Doner Name : "+name+"\nPhone No : " +phone+"\n\n");
                            }

                        } else {
                            Toast.makeText(getApplicationContext(), "No data available", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ListView_Activity.this,navigation_drawer.class);
        startActivity(intent);
        super.onBackPressed();
    }
}

