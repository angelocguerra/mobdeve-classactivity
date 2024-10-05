package com.mobdeve.guerra.tmg_application;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class Verdict extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_verdict);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent i = getIntent();
        String firstName = i.getStringExtra("firstName");
        String lastName = i.getStringExtra("lastName");
        String gender = i.getStringExtra("gender");
        String height = i.getStringExtra("height");
        String weight = i.getStringExtra("weight");
        String contactNumber = i.getStringExtra("contactNumber");

        // Print values to logcat
        Log.d("Verdict", "First Name: " + firstName);
        Log.d("Verdict", "Last Name: " + lastName);
        Log.d("Verdict", "Gender: " + gender);
        Log.d("Verdict", "Height: " + height);
        Log.d("Verdict", "Weight: " + weight);
        Log.d("Verdict", "Contact Number: " + contactNumber);

        // Calculate BMI
        double heightInCm = Double.parseDouble(height);
        double weightInKg = Double.parseDouble(weight);
        double bmi = weightInKg / Math.pow(heightInCm / 100, 2);

        TextView title = findViewById(R.id.tvTitle);
        TextView verdict = findViewById(R.id.tvVerdict);
        ImageView verdictImage = findViewById(R.id.ivVerdictImage);
        TextView heightText = findViewById(R.id.tvHeight);
        TextView weightText = findViewById(R.id.tvWeight);
        TextView genderText = findViewById(R.id.tvGender);
        TextView bmiContactText = findViewById(R.id.tvBMIContact);

        heightText.setText("Your Height: " + height + " cm");
        weightText.setText("You Weight: " + weight + " kg");
        genderText.setText("Your Gender: " + gender);
        title.setText("Thank you for applying, " + firstName + " !");

        if((Objects.equals(gender, "Male") && bmi >= 20 && bmi <= 24 && heightInCm >= 170) ||
                (Objects.equals(gender, "Female") && bmi >= 19 && bmi <= 23 && heightInCm >= 160)) {
            verdictImage.setImageResource(R.drawable.p1_approved);
            verdict.setTextSize(48);
            verdict.setText("You Qualify!");
            bmiContactText.setText(String.format("Your BMI: %.2f", bmi));
        } else {
            verdictImage.setImageResource(R.drawable.p1_wait);
            verdict.setTextSize(20);
            verdict.setText("I will get in touch with your contact no.");
            bmiContactText.setText("Your contact no.: " + contactNumber);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(getApplicationContext(), Introduction.class);
        startActivity(i);
        finish();
    }
}