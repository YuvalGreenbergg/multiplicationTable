package com.example.multiplicationtable;

import java.util.Random;

public class Normal extends Model {
    @Override
    public void ranInt() {
        num1 = random.nextInt(9) + 1;
        num2 = random.nextInt(9) + 1;
    }
}
