package com.example.fibonacci;

public class Fibonacci {
    public int num;
    public int result;

    public Fibonacci() {}
    public Fibonacci(int num)
    {
        this.num = num;
        this.result = Calculate(num);
    }

    public int Calculate(int num) {
        if (num == 0) {
            result = 0;
        }
        if (num == 1) {
            result = 1;
        }
        if (num >= 2) {
            result = Calculate(num - 2) + Calculate(num - 1);
        }
        return result;
    }

    @Override
    public String toString() {
        return "F(" + num + ") = " + result;
    }
}
