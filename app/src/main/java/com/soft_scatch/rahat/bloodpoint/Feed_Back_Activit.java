package com.soft_scatch.rahat.bloodpoint;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Feed_Back_Activit extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbar;
    EditText message;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed__back_);

       toolbar = findViewById(R.id.feedbackTol);
       toolbar.setTitle("Feedback");
       message = findViewById(R.id.feedbackID);
       send =findViewById(R.id.sendButton);

       send.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

              String data = message.getText().toString();

               Intent intent = new Intent(Intent.ACTION_SEND);
               intent.setType("text/email");

               intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"rahat.cityclg@gmail.com"});

               intent.putExtra(Intent.EXTRA_SUBJECT,"FeedBack from user");
               intent.putExtra(Intent.EXTRA_TEXT,"Feed Back : "+data);

               startActivity(Intent.createChooser(intent,"FeedBack with " ));

           }
       });
    }
}
