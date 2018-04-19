package com.soft_scatch.rahat.bloodpoint;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sign_UP_Activity extends AppCompatActivity {

    EditText UserName,PassWord,ConfirmPass;
    Button next;
    DBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up_);

        helper = new DBHelper(this);

        UserName =findViewById(R.id.regUserNameID);
        PassWord  =findViewById(R.id.regPassID);
        ConfirmPass =findViewById(R.id.regConPassID);
        next =findViewById(R.id.signUpButtonID);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_name =UserName.getText().toString();
                String password =PassWord.getText().toString();
                String Conpassword =ConfirmPass.getText().toString();
                if(user_name.isEmpty()||password.isEmpty()){
                    Toast.makeText(Sign_UP_Activity.this, "Please enter all data", Toast.LENGTH_SHORT).show();
                }else if (password.equals(Conpassword)){
                    long isInserted = helper.insert_data(user_name,password);
                    if (isInserted!=-1){
                        SharedPreferences sp = getSharedPreferences("details", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("stored_user",user_name);
                        editor.commit();
                        Toast.makeText(Sign_UP_Activity.this, "Account create successfull", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),Personal_Details_Activity.class);
                        startActivity(intent);

                    }
                }else {
                    Toast.makeText(Sign_UP_Activity.this, "Passwords should be same", Toast.LENGTH_SHORT).show();
                }
                }

        });
    }
}
