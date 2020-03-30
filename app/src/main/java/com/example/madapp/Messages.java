package com.example.madapp;

public class Messages {

    String to, from, subject, message, date;


    public Messages(String to, String from, String subject, String message, String date) {

        this.to = to;

        this.from = from;

        this.subject = subject;

        this.message = message;

        this.date = date;

    }

    public Messages () {


    }

    public void setDate (String date) {

        this.date = date;

    }

    public String getTo() {


        return to;

    }

    public void setTo(String to) {this.to = to;}

    public String getFrom() {return from;}

    public void setFrom(String from) {this.from = from;}

    public String getSubject() {return subject;}

    public void setSubject(String subject) {this.subject = subject;}

    public String getMessage() {return message;}

    public void setMessage(String message) {this.message = message;}



}


