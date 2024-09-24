package com.example.ca1sep13problem2;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    // TODO: Declare the attributes needed
    EditText inputText;
    Button btnSubmit;
    TextView outputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets syst

        // TODO: Associate each view with the corresponding ID via findViewById()
        inputText = findViewById(R.id.inputText);
        btnSubmit = findViewById(R.id.btnSubmit);
        outputText = findViewById(R.id.outputText);
    }emBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
});

    // TODO: Declare the functionalities at this point
    public void findPalindromeSum(View v) {
        Arrays.sort(digits)

        int number = Integer.parseInt(inputText.getText().toString());

        int[] digits = new int[3];
        digits[0] = input / 100; // Hundreds
        digits[1] = (input / 10) % 10; // Tens
        digits[2] = input % 10; // Ones

        // Find the smallest and largest palindromes
        int[] palindromes = findPalindromes(digits);
        int smallestPalindrome = palindromes[0];
        int largestPalindrome = palindromes[1];

        int sum = smallestPalindrome + largestPalindrome;

        // return smallest + largest;
        outputText.setText(sum);
    }

    public int[] findPalindromes(int[] digits) {
        int[] result = new int[2];
        Arrays.sort(digits);

        // Forming the smallest palindrome: digits sorted in ascending order
        int smallestPalindrome = digits[0] * 10000 + digits[1] * 1000 + digits[2] * 100 + digits[1] * 10 + digits[0];

        // Forming the largest palindrome: digits sorted in descending order
        int largestPalindrome = digits[2] * 10000 + digits[1] * 1000 + digits[0] * 100 + digits[1] * 10 + digits[2];

        // Assign the smallest and largest palindromes
        result[0] = smallestPalindrome;
        result[1] = largestPalindrome;

        return result;
    }
}