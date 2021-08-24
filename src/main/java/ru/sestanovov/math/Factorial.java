package ru.sestanovov.math;

public class Factorial {
    public long factUsingForLoop(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public long factUsingRecursion(int n) {
        if (n <= 2) {
            return n;
        }
        return n * factUsingRecursion(n - 1);
    }
}
