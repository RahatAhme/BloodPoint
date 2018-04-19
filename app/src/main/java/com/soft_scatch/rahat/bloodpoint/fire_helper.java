package com.soft_scatch.rahat.bloodpoint;


import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class fire_helper {
    String data;

    public fire_helper(Context context) {
        this.context = context;
    }

    Context context;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    StringBuffer showing ;


    public void donerAdder(String donerName, String mobileNO, String selectedbg, String selectedDistrict, String selectedSubDistrict, String birthDate, String selectedGender) {

        Map<String, Object> DONER = new HashMap<>();
        DONER.put("DONER NAME", donerName);
        DONER.put("MOBILE", mobileNO);
        DONER.put("BLOOD", selectedbg);
        DONER.put("DISTRICT", selectedDistrict);
        DONER.put("SUB_DISTRICT", selectedSubDistrict);
        DONER.put("BIRTHDAY", birthDate);
        DONER.put("GENDER", selectedGender);

// Add a new document with a generated ID
        db.collection("DONER_INFO")
                .add(DONER)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(context, "Data is inserted", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(context, "Network problem \n Please later", Toast.LENGTH_SHORT).show();
                    }
                });


    }



    public String search(String blood, String dist, String subdi) {

         showing= new StringBuffer();



        return data;


    }

    public void addAbulance(String hospitalName, String mobile, String selectedSubDistrict) {

        Map<String, Object> AMBULANCE = new HashMap<>();
        AMBULANCE.put("HOSPITAL NAME", hospitalName);
        AMBULANCE.put("MOBILE", mobile);
        AMBULANCE.put("SUB_DISTRICT", selectedSubDistrict);

// Add a new document with a generated ID
        db.collection("AMBULANCE_TABLE")
                .add(AMBULANCE)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(context, "Data is inserted", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(context, "Network problem \n Please later", Toast.LENGTH_SHORT).show();
                    }
                });

    }
}
