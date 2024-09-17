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
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // TODO: Associate each view with the corresponding ID via findViewById()
        inputText = findViewById(R.id.inputText);
        btnSubmit = findViewById(R.id.btnSubmit);
        outputText = findViewById(R.id.outputText);
    }


    // TODO: Declare the functionalities at this point
    public void findPalindromeSum(View v) {
        int number = Integer.parseInt(inputText.getText().toString());

        int digit1 = number / 100;
        int digit2 = (number/10) % 10;
        int digit3 = number % 10;

        int[] palindromes = new int[6];
        palindromes[0] = createPalindrome(digit1, digit2, digit3);
        palindromes[1] = createPalindrome(digit1, digit3, digit2);
        palindromes[2] = createPalindrome(digit2, digit1, digit3);
        palindromes[3] = createPalindrome(digit2, digit3, digit1);
        palindromes[4] = createPalindrome(digit3, digit1, digit2);
        palindromes[5] = createPalindrome(digit3, digit2, digit1);

        int smallest = palindromes[0];
        int largest = palindromes[0];
        for (int palindrome : palindromes) {
            if(palindrome < smallest) {
                smallest = palindrome;
            }
            if (palindrome > largest) {
                largest = palindrome;
            }
        }

        // return smallest + largest;
        outputText.setText(smallest + largest);
    }

    public static int createPalindrome(int a, int b, int c) {
        return a*10001 + b*1010 + c*100;
    }
}