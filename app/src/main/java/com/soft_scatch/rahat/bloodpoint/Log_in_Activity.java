package com.soft_scatch.rahat.bloodpoint;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class Log_in_Activity extends AppCompatActivity implements View.OnClickListener{

    android.support.v7.widget.Toolbar toolbar;
    EditText userName,passWord;
    Button logIN;
    TextView newHere,forgetPass;
    DBHelper helper= new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_);

        toolbar =findViewById(R.id.toolBarID);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        userName =findViewById(R.id.logUserNameID);
        passWord =findViewById(R.id.logPassID);
        logIN =findViewById(R.id.logInButtonID);
        newHere =findViewById(R.id.newHereTextID);
        forgetPass =findViewById(R.id.forgetPassTextID);

        logIN.setOnClickListener(this);
        newHere.setOnClickListener(this);
        forgetPass.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if(id==R.id.logInButtonID){
            String USER_NAME = userName.getText().toString();
            String PASSWORD = passWord.getText().toString();
            if(USER_NAME.isEmpty()||PASSWORD.isEmpty()){
                Toast.makeText(this, "Please Enter Your Informations", Toast.LENGTH_SHORT).show();
            }else {
                Boolean allow = helper.checking(USER_NAME,PASSWORD);
                if(allow){

                    SharedPreferences sp = getSharedPreferences("details", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("user_name_key",USER_NAME);
                    editor.commit();
                    Intent intent = new Intent(Log_in_Activity.this,Core_Activity.class);
                    startActivity(intent);

                }
            }

        }else if(id== R.id.newHereTextID){
            Intent intent = new Intent(Log_in_Activity.this,Sign_UP_Activity.class);
            startActivity(intent);

        }else if(id == R.id.forgetPassTextID){

        }
    }

}
