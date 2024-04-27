package com.example.popup;

import static com.example.popup.R.*;
import static com.example.popup.R.id.editTextsong;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class ActivityMain extends AppCompatActivity {
    EditText editTextName, editTextEmail, editTextInterest,editTextsong;
    Button btnartform, btngenre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextInterest = findViewById(R.id.editTextInterest);
        editTextsong = findViewById(id.editTextsong);
        btnartform = findViewById(R.id.btnartform);
        btngenre = findViewById(R.id.btngenre);
        // Setup spinner with year options
        btnartform.setOnClickListener(v -> showPopupMenu(v, R.menu.genre_menu));
        btngenre.setOnLongClickListener(v -> {
            showPopupMenu(v, R.menu.artform_menu);
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
        String Interest = editTextInterest.getText().toString();
        String Hometown = editTextsong.getText().toString();
        String userInfo = "Name: " + name + "\nEmail: " + email + "\nInterest: " + Interest + "\nsong: " + Hometown + infoType;
        Toast.makeText(this, userInfo, Toast.LENGTH_SHORT).show();
    }
}