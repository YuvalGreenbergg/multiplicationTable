package com.example.acremote;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnPlus;
    Button btnMinus;
    Button btnOff;
    Button btnOn;
    Button btnTemp;
    TextView tvTemp;
    int temp = 20;
    boolean isOn = false;
    boolean isCold;
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
        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);
        btnOff = findViewById(R.id.btnOff);
        btnOn = findViewById(R.id.btnOn);
        btnTemp = findViewById(R.id.btnTemp);
        btnOff.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnOn.setOnClickListener(this);
        btnTemp.setOnClickListener(this);
        tvTemp = findViewById(R.id.tvTemp);
        tvTemp.setText("" + temp);
    }
    private void Plus(){
        if (isOn){
            if(isCold){
                if(temp<27) {
                    temp++;
                    tvTemp.setText("" + temp);
                }
            }
            else{
                temp++;
                tvTemp.setText("" + temp);
            }
        }
    }
    private void Minus(){
        if (isOn){
            if(!isCold){
                if(temp>18) {
                    temp--;
                    tvTemp.setText("" + temp);
                }
            }
            else{
                temp--;
                tvTemp.setText("" + temp);
            }
        }
    }
    public void onClick(View v) {

        if (v.getId() == R.id.btnTemp && isOn) {
            if (isCold) {
                isCold = false;
                btnTemp.setText("HEAT");
                if (temp < 18) {
                    temp = 18;
                    tvTemp.setText("" + temp);
                }
            } else if (!isCold) {
                isCold = true;
                btnTemp.setText("COLD");
                if (temp > 27) {
                    temp = 27;
                    tvTemp.setText("" + temp);
                }
            }

            if (v.getId() == R.id.btnMinus && isOn && temp > 16) {
                Minus();
            } else if (v.getId() == R.id.btnPlus && isOn && temp < 30) {
                Plus();
            } else if (v.getId() == R.id.btnOff) {
                isOn = false;
                Toast.makeText(this, "AC TURNED OFF", Toast.LENGTH_LONG).show();
                tvTemp.setText("--");

            } else if (v.getId() == R.id.btnOn) {
                isOn = true;
                Toast.makeText(this, "AC TURNED ON", Toast.LENGTH_SHORT).show();
                tvTemp.setText("" + temp);
            }

        }
    }
}