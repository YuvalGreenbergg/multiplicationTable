package com.example.multiplicationtable;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText answerBox;
    TextView tvNum1;
    TextView tvNum2;
    Button btnKefel;
    Button btnUpto20;
    Button btnChallenge;

    Controller controller;
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
        answerBox = findViewById(R.id.answerBox);
        tvNum1 = findViewById(R.id.tvNum1);
        tvNum2 = findViewById(R.id.tvNum2);
        btnKefel = findViewById(R.id.btnKefel);
        btnChallenge = findViewById(R.id.btnChallenge);
        btnUpto20 = findViewById(R.id.btnUpto20);




        controller = new Controller(this);
    }

    public void modeClicked(View view) {
        if (view.getId() == R.id.btnKefel) {
            controller.normal();
        }
        else if (view.getId() == R.id.btnUpto20) {
            controller.upTo20();
        } else if (view.getId() == R.id.btnChallenge) {
            controller.challange();
        }
    }

    public void checkClicked(View view) {
        String answer = answerBox.getText().toString();
        int intAnswer = Integer.parseInt(answer);
        controller.checkAns(intAnswer);
    }

    public void displayNums(int num1, int num2) {
        tvNum1.setText(""+num1);
        tvNum2.setText(""+num2);
    }
    public void displayVictory(){
        answerBox.setText(null);
        Toast.makeText(this, "Very Well!", Toast.LENGTH_SHORT).show();
    }

    public void displayFailure() {
        answerBox.setText(null);
        Toast.makeText(this, "Almost! Too Bad", Toast.LENGTH_LONG).show();
    }
}