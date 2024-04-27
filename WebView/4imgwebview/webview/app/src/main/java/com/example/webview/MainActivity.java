package com.example.webview;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton bt1,bt2,bt3,bt4;
        bt1 = findViewById(R.id.button);
        bt2 = findViewById(R.id.button1);
        bt3 = findViewById(R.id.button2);
        bt4 = findViewById(R.id.button3);
        bt1.setOnClickListener(view -> {
            String str = "https://www.Youtube.com/";
            Intent i = new Intent(getApplicationContext(),MainActivity2.class);
            i.putExtra("bt1",str);
            startActivity(i);
        });
        bt2.setOnClickListener(view -> {
            String str1 = "https://www.amazon.in/";
            Intent i = new Intent(getApplicationContext(),MainActivity2.class);
            i.putExtra("bt2",str1);
            startActivity(i);
        });
        bt3.setOnClickListener(view -> {
            String str1 = "https://www.flipkart.com/";
            Intent i = new Intent(getApplicationContext(),MainActivity2.class);
            i.putExtra("bt3",str1);
            startActivity(i);
        });
        bt4.setOnClickListener(view -> {
            String str1 = "https://www.facebook.com/";
            Intent i = new Intent(getApplicationContext(),MainActivity2.class);
            i.putExtra("bt4",str1);
            startActivity(i);
        });
    }
}