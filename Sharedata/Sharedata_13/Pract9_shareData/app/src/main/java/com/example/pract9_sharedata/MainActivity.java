package com.example.pract9_sharedata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText name = findViewById(R.id.name);
        EditText phone = findViewById(R.id.phone);
        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = name.getText().toString().trim();
                String p = phone.getText().toString().trim();
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                intent.putExtra("name", n);
                intent.putExtra("phone", p);
                startActivity(intent);
            }
        });
    }
}