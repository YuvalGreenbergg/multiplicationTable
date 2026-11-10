package com.example.multiplicationtable;

public class UpTo20 extends Model {
    @Override
    public void ranInt() {
        num1 = random.nextInt(19) + 1;
        num2 = random.nextInt(19) + 1;
    }
}
