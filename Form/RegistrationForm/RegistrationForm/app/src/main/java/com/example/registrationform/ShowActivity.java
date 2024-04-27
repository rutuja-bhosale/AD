package com.example.registrationform;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Set;
public class ShowActivity extends AppCompatActivity {
    private TextView textViewName, textViewEmail, textViewSubject, textViewGender,
            textViewQualifications;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        textViewName = findViewById(R.id.textViewName);
        textViewEmail = findViewById(R.id.textViewEmail);
        textViewSubject = findViewById(R.id.textViewSubject);
        textViewGender = findViewById(R.id.textViewGender);
        textViewQualifications = findViewById(R.id.textViewQualifications);
        SharedPreferences sharedPreferences = getSharedPreferences("RegistrationData",
                MODE_PRIVATE);
        String name = sharedPreferences.getString("Name", "");
        String email = sharedPreferences.getString("Email", "");
        String subject = sharedPreferences.getString("Subject", "");
        String gender = sharedPreferences.getString("Gender", "");
        Set<String> qualifications = sharedPreferences.getStringSet("Qualifications", null);
        textViewName.setText("Name: " + name);
        textViewEmail.setText("Email: " + email);
        textViewSubject.setText("Subject: " + subject);
        textViewGender.setText("Gender: " + gender);
        if (qualifications != null) {
            textViewQualifications.setText("Qualifications: " + qualifications.toString());
        }
    }
}