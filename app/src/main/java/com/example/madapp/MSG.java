package com.example.madapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class MSG extends AppCompatActivity {

    EditText subject, message;

    Button btn_sent;

    DatabaseReference dbref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        subject = findViewById(R.id.et_subject);

        message = findViewById(R.id.et_message);

        btn_sent = findViewById(R.id.btn_send);

        dbref = FirebaseDatabase.getInstance().getReference("_messages_");


        btn_sent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Calendar cal = Calendar.getInstance();

                cal.get(Calendar.DAY_OF_MONTH);

                String date = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.YEAR) + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);

                dbref.child(dbref.push().getKey()).setValue(new Messages("TEN23456", "PAT123456", subject.getText().toString(), message.getText().toString(), date ));

            }

        });


    }



}
