package com.example.madapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Moodle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moodle);

        WebView webView = findViewById(R.id.web_view);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://partnerships.moodle.roehampton.ac.uk");
    }


}


