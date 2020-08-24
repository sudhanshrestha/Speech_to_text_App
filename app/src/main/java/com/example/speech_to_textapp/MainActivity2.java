package com.example.speech_to_textapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    TextView mtxtResult;
    TextView mtxtDesc;
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mtxtResult = findViewById(R.id.txtResult);
        Bundle extras =getIntent().getExtras();
        CookieManager.getInstance().setAcceptCookie(true);
        mWebView = (WebView) findViewById(R.id.webView);
        if (extras !=null) {
            String data = extras.getString("Voice_Data");
            if (data !=null){

                mWebView.getSettings().setLoadsImagesAutomatically(true);
                mWebView.getSettings().setJavaScriptEnabled(true);
                mWebView.loadUrl("https://www.google.com/search?q=what+is+a+"+data);


            }
            else {
                Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show();
            }
            }
        }
    }
