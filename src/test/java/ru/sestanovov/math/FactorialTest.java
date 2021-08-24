package ru.sestanovov.math;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FactorialTest {

    private static final Factorial factorial = new Factorial();

    @Test
    public void whenFactUsingForLoop() {
        long result = factorial.factUsingForLoop(4);
        long expected = 24;
        assertThat(result, is(expected));
    }

    @Test
    public void whenFactUsingRecursion() {
        long result = factorial.factUsingRecursion(5);
        long expected = 120;
        assertThat(result, is(expected));
    }
}