package com.example.ad_list1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button act = findViewById(R.id.btn_act);
        Button frag = findViewById(R.id.btn_frag);
        Button intnt = findViewById(R.id.btn_int);
        Button rcycView = findViewById(R.id.btn_rcycView);

        act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com/guide/components/activities/intro-activities"));
                startActivity(intent);
            }
        });

        frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com/guide/fragments"));
                startActivity(intent);
            }
        });

        intnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com/guide/components/intents-filters"));
                startActivity(intent);
            }
        });

        rcycView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com/develop/ui/views/layout/recyclerview"));
                startActivity(intent);
            }
        });
    }
}