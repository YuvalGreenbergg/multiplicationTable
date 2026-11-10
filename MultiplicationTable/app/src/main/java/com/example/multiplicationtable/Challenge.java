package com.example.multiplicationtable;

public class Challenge extends Model {
    @Override
    public void ranInt() {
        num1 = random.nextInt(99) + 1;
        num2 = random.nextInt(99) + 1;
    }
}
