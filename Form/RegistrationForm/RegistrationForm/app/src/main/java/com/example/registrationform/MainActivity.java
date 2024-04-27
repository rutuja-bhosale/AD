package com.example.registrationform;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashSet;
import java.util.Set;
public class MainActivity extends AppCompatActivity {
    private EditText nameEditText, emailEditText;
    private Spinner subjectSpinner;
    private RadioGroup genderRadioGroup;
    private CheckBox checkBoxGraduate, checkBoxPostGraduate;
    private Button submitButton;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("RegistrationData", MODE_PRIVATE);
        nameEditText = findViewById(R.id.editTextName);
        emailEditText = findViewById(R.id.editTextEmail);
        subjectSpinner = findViewById(R.id.spinnerSubject);
        genderRadioGroup = findViewById(R.id.radioGroupGender);
        checkBoxGraduate = findViewById(R.id.checkBoxGraduate);
        checkBoxPostGraduate = findViewById(R.id.checkBoxPostGraduate);
        submitButton = findViewById(R.id.buttonSubmit);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.subjects_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subjectSpinner.setAdapter(adapter);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("saving data");
                saveData();
                System.out.println("saved data");
                Intent intent = new Intent(MainActivity.this, ShowActivity.class);
                System.out.println("before intent");
                startActivity(intent);
                System.out.println("after intent");
            }
        });
    }
    private void saveData() {
        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String selectedSubject = subjectSpinner.getSelectedItem().toString();
        int selectedGenderId = genderRadioGroup.getCheckedRadioButtonId();
        String gender = selectedGenderId == R.id.radioButtonMale ? "Male" : "Female";
        Set<String> qualifications = new HashSet<>();
        if (checkBoxGraduate.isChecked()) {
            qualifications.add("Graduate");
        }
        if (checkBoxPostGraduate.isChecked()) {
            qualifications.add("Post Graduate");
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Name", name);
        editor.putString("Email", email);
        editor.putString("Subject", selectedSubject);
        editor.putString("Gender", gender);
        editor.putStringSet("Qualifications", qualifications);
        editor.apply();
        Toast.makeText(MainActivity.this, "Data saved successfully", Toast.LENGTH_SHORT).show();
    }
}
