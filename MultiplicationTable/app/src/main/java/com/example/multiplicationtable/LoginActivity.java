package com.example.multiplicationtable;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    EditText etFstName;
    EditText etLstName;
    Button btnIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etFstName = findViewById(R.id.etFstName);
        etLstName = findViewById(R.id.etLstName);
        btnIntent = findViewById(R.id.btnIntent);

    }


    public void checkClicked(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("first name", etFstName.getText().toString());
        intent.putExtra("last name", etLstName.getText().toString());
        startActivity(intent);
    }



}