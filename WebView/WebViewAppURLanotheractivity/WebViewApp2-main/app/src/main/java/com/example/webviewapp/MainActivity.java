package com.example.webviewapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText urlInput = findViewById(R.id.urlInput);
        Button openWebViewButton = findViewById(R.id.openWebViewButton);

        openWebViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = urlInput.getText().toString();
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });
    }
}
