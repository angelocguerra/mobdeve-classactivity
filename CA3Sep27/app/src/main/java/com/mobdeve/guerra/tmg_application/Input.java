package com.mobdeve.guerra.tmg_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Input extends AppCompatActivity {
    EditText firstName;
    EditText lastName;
    RadioGroup gender;
    EditText height;
    EditText weight;
    EditText contactNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_input);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void clearBtnClicked (View v) {
        firstName = findViewById(R.id.etFirstName);
        lastName = findViewById(R.id.etLastName);
        gender = findViewById(R.id.rgGender);
        height = findViewById(R.id.etHeight);
        weight = findViewById(R.id.etWeight);
        contactNumber = findViewById(R.id.etContactNum);

        firstName.setText("");
        lastName.setText("");
        gender.clearCheck();
        height.setText("");
        weight.setText("");
        contactNumber.setText("");
    }

    public void submitBtnClicked (View v) {
        firstName = findViewById(R.id.etFirstName);
        lastName = findViewById(R.id.etLastName);
        gender = findViewById(R.id.rgGender);
        height = findViewById(R.id.etHeight);
        weight = findViewById(R.id.etWeight);
        contactNumber = findViewById(R.id.etContactNum);

        String firstNameText = firstName.getText().toString();
        String lastNameText = lastName.getText().toString();
        int selectedGenderId = gender.getCheckedRadioButtonId();
        RadioButton selectedGender = findViewById(selectedGenderId);
        String genderText = selectedGender != null ? selectedGender.getText().toString() : "";
        String heightText = height.getText().toString();
        String weightText = weight.getText().toString();
        String contactNumberText = contactNumber.getText().toString();

        // Check if all fields are filled
        if (firstNameText.isEmpty() || lastNameText.isEmpty() || genderText.isEmpty() || heightText.isEmpty() || weightText.isEmpty() || contactNumberText.isEmpty()) {
            return;
        }

        Intent intent = new Intent(getApplicationContext(), Verdict.class);
        intent.putExtra("firstName", firstNameText);
        intent.putExtra("lastName", lastNameText);
        intent.putExtra("gender", genderText);
        intent.putExtra("height", heightText);
        intent.putExtra("weight", weightText);
        intent.putExtra("contactNumber", contactNumberText);

        startActivity(intent);
    }
}