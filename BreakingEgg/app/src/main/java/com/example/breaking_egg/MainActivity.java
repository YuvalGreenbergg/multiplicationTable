package com.example.breaking_egg;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView ivEgg;
    int counter = 7;
    TextView tvCounter;
    Button btnReset;
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


        ivEgg = findViewById(R.id.ivEgg);
        tvCounter = findViewById(R.id.tvCounter);
        btnReset = findViewById(R.id.btnReset);
        tvCounter.setText("" + counter);
        ivEgg.setOnClickListener(this);
        btnReset.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.ivEgg){
            if(counter>0) {
                counter--;
                tvCounter.setText("" + counter);
            }
            if(counter==0) {
                ivEgg.setImageDrawable(getDrawable(R.drawable.crackedegg));
                tvCounter.setTextSize(24);
                tvCounter.setText("IT CRACKED!");
            }

        } else if (v.getId() == R.id.btnReset) {
            counter = 7;
            ivEgg.setImageDrawable(getDrawable(R.drawable.egg));
            tvCounter.setText("" + counter);

        }
    }
}