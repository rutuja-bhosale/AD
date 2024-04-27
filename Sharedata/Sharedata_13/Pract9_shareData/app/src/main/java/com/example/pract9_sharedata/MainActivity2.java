package com.example.pract9_sharedata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView name = findViewById(R.id.name);
        TextView phone = findViewById(R.id.phone);
        Button btn = findViewById(R.id.btn);

        String sharedName = getIntent().getStringExtra("name");
        String sharedPhone = getIntent().getStringExtra("phone");

        name.setText(sharedName);
        phone.setText(sharedPhone);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}