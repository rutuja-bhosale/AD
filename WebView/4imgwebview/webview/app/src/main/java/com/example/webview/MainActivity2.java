package com.example.webview;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity2 extends AppCompatActivity {
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String str = intent.getStringExtra("bt1");
        String str1 = intent.getStringExtra("bt2");
        String str2 = intent.getStringExtra("bt3");
        String str3 = intent.getStringExtra("bt4");
        WebView web = findViewById(R.id.web);
        web.setWebViewClient(new WebViewClient());
        web.loadUrl(str);
        web.loadUrl(str1);
        web.loadUrl(str2);
        web.loadUrl(str3);
        WebSettings webSettings = web.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}