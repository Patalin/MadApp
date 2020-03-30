package com.example.madapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.MsgHolder> {

    ArrayList<Messages> messages;

    public MsgAdapter(ArrayList<Messages> messages) {
        this.messages = messages;


    }


    @NonNull
    @Override
    public MsgHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        //create a view with our card

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg, parent, false);

        MsgHolder holder = new MsgHolder(v);

        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull MsgHolder msgHolder, int i) {

        msgHolder.sender.setText(messages.get(i).getFrom());

        msgHolder.subject.setText(messages.get(i).getSubject());

    }

    //How many cards the recycle view will make:
    @Override
    public int getItemCount() {
        return messages.size();
    }

    public static class MsgHolder extends RecyclerView.ViewHolder {

        TextView sender, subject;

        public MsgHolder(@NonNull View itemView) {
            super(itemView);

            sender = itemView.findViewById(R.id.tv_sender_id);

            subject = itemView.findViewById(R.id.tv_sender_id);

        }
    }
}
