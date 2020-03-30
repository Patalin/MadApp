package com.example.madapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Emails extends AppCompatActivity {

    RecyclerView rv;

    Query dbref;

    MsgAdapter adapter;

    ArrayList<Messages> messages;

    public Emails() {
        messages = new ArrayList<>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emails);

        rv = findViewById(R.id.rv_emails);

        rv.setLayoutManager(new LinearLayoutManager(Emails.this));

        dbref = FirebaseDatabase.getInstance().getReference("_messages_").orderByChild("to").equalTo("test@gmail.com");

        dbref.addListenerForSingleValueEvent(listner);

    }

    ValueEventListener listner = new ValueEventListener() {


        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            for(DataSnapshot dss: dataSnapshot.getChildren()) {

                messages.add(dss.getValue(Messages.class));

            }

            adapter = new MsgAdapter(messages);

            rv.setAdapter(adapter);

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };



}
