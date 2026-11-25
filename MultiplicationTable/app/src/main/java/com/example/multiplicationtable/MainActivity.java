package com.example.multiplicationtable;

import android.content.Intent;
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
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {


    private MathViewModel viewModel;
    private EditText answerBox;
    private TextView tvNum1;
    private TextView tvNum2;
    private TextView tvUserName;
    private Button btnKefel;
    private Button btnUpto20;
    private Button btnChallenge;
    private Button btnCheck;
    Intent intent;

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

        viewModel = new ViewModelProvider(this).get(MathViewModel.class);

        intent = getIntent();
        String firstname = intent.getStringExtra("first name");
        String lastname = intent.getStringExtra("last name");

        answerBox = findViewById(R.id.answerBox);
        tvNum1 = findViewById(R.id.tvNum1);
        tvNum2 = findViewById(R.id.tvNum2);
        tvUserName = findViewById(R.id.tvUserName);
        tvUserName.setText(firstname + " " + lastname);
        btnKefel = findViewById(R.id.btnKefel);
        btnChallenge = findViewById(R.id.btnChallenge);
        btnUpto20 = findViewById(R.id.btnUpto20);
        btnCheck = findViewById(R.id.btnCheck);
        viewModel.getNum1().observe(this, number -> {
            tvNum1.setText(String.valueOf(number));
        });
        viewModel.getNum2().observe(this, number -> {
            tvNum2.setText(String.valueOf(number));
        });
        viewModel.getAnswerCorrect().observe(this, correct -> {
            if(correct == null){
                return;
            }
            if(correct){
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
                viewModel.generateQuestion();
                answerBox.setText(null);
            }
            else {
                Toast.makeText(this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                answerBox.setText(null);
            }
        });
    }

    public void modeClicked(View view) {
        if (view.getId() == R.id.btnKefel) {
            viewModel.setGameType(GameType.Normal);
        }
        else if (view.getId() == R.id.btnUpto20) {
            viewModel.setGameType(GameType.UpTo20);
        } else if (view.getId() == R.id.btnChallenge) {
            viewModel.setGameType(GameType.Chellenge);
        }
    }

    public void checkClicked(View view) {
        String answer = answerBox.getText().toString();
        int intAnswer = Integer.parseInt(answer);
        viewModel.checkAns(intAnswer);
    }
}