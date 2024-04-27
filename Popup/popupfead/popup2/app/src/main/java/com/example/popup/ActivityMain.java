package com.example.popup;

import static com.example.popup.R.array.*;
import static com.example.popup.R.id.btnbranch;
import static com.example.popup.R.id.btnclub;
import static com.example.popup.R.id.editTextHometown;
import static com.example.popup.R.id.editTextInterest;
import static com.example.popup.R.id.editTextMarks;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class ActivityMain extends AppCompatActivity {
    EditText editTextName, editTextEmail, editTextMarks, editTextInterest,editTextHometown;
    Button btnbranch, btnclub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextMarks = findViewById(R.id.editTextMarks);
        editTextInterest = findViewById(R.id.editTextInterest);
        editTextHometown = findViewById(R.id.editTextHometown);
        btnbranch = findViewById(R.id.btnbranch);
        btnclub = findViewById(R.id.btnclub);
        // Setup spinner with year options
        btnbranch.setOnClickListener(v -> showPopupMenu(v, R.menu.club_menu));
        btnclub.setOnLongClickListener(v -> {
            showPopupMenu(v, R.menu.branch_menu);
            return true;
        });
    }

    private void showPopupMenu(View view, int menuResId) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(menuResId, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(item -> {
            displayUserInfo(Objects.requireNonNull(item.getTitle()).toString());
            return true;
        });
        popupMenu.show();
    }
    private void displayUserInfo(String infoType) {
        String name = editTextName.getText().toString();
        String email = editTextEmail.getText().toString();
        String Marks = editTextMarks.getText().toString();
        String Interest = editTextInterest.getText().toString();
        String Hometown = editTextHometown.getText().toString();
        String userInfo = "Name: " + name + "\nEmail: " + email + "\nMarks: " + Marks + "\nInterest: " + Interest + "\nHometown: " + Hometown + infoType;
        Toast.makeText(this, userInfo, Toast.LENGTH_LONG).show();
    }
}