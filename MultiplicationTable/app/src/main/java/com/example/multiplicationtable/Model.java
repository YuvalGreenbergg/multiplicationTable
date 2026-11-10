package com.example.multiplicationtable;

import android.widget.EditText;

import java.util.Random;

public abstract class Model {
    int num1;
    int num2;

    Random random = new Random();
    public int getNum1(){
        return num1;
    }
    public int getNum2(){
        return num2;
    }
    public abstract void ranInt();

    public boolean checkAns(int ans){
        return num1 * num2 == ans;
    }
}
