package com.example.mynicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity3 extends AppCompatActivity {
    private WebView miweb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        miweb = findViewById(R.id.webview);
        WebSettings webSettings = miweb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        miweb.loadUrl("https://console.dialogflow.com/api-client/demo/embedded/934837c1-f21d-4999-a18d-491e663547e2");
    }
}