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
    private RadioGroup genderRadioCities;
    private RadioButton radioButtonPune, radioButtonNagar, radioButtonGadchiroli;
    private CheckBox checkBoxCity, checkBoxLocation , checkBoxCountry;
    private Button submitButton;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("RegistrationData", MODE_PRIVATE);
        nameEditText = findViewById(R.id.editTextName);
        emailEditText = findViewById(R.id.editTextEmail);
        subjectSpinner = findViewById(R.id.spinnerBerthChoice);
        genderRadioCities = findViewById(R.id.radioGroupCities);
        radioButtonPune = findViewById(R.id.radioButtonPune);
        radioButtonNagar = findViewById(R.id.radioButtonNagar);
        radioButtonGadchiroli = findViewById(R.id.radioButtonGadchiroli);  // Reference the "Other" RadioButton
        checkBoxCity = findViewById(R.id.checkBoxVeg);
        checkBoxLocation = findViewById(R.id.checkBoxNonveg);
        checkBoxCountry = findViewById(R.id.checkBoxJain);

        submitButton = findViewById(R.id.buttonSubmit);

        // ... rest of your code for setting up the spinner adapter, etc.

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

        // Determine selected gender based on radio button selection
        String selectedGender;
        int selectedGenderId = genderRadioCities.getCheckedRadioButtonId();
        if (selectedGenderId == radioButtonPune.getId()) {
            selectedGender = "Pune";
        } else if (selectedGenderId == radioButtonNagar.getId()) {
            selectedGender = "Nagar";
        } else if (selectedGenderId == radioButtonGadchiroli.getId()) { // Check for "Other"
            selectedGender = "Gadchiroli";
        } else {
            selectedGender = "";  // Handle case where no button is selected (optional)
        }

        Set<String> qualifications = new HashSet<>();
        if (checkBoxCity.isChecked()) {
            qualifications.add("Veg");
        }
        if (checkBoxLocation.isChecked()) {
            qualifications.add("Nonveg");
        }
        if (checkBoxCountry.isChecked()) {
            qualifications.add("Jain");
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Name", name);
        editor.putString("Email", email);
        editor.putString("Subject", selectedSubject);
        editor.putString("Gender", selectedGender);
        editor.putStringSet("Qualifications", qualifications);
        editor.apply();
        Toast.makeText(MainActivity.this, "Data saved successfully", Toast.LENGTH_SHORT).show();
    }
}
