package ru.sestanovov.math;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CountingElementsTest {
    @Test
    public void whenSeveralElements() {
        Character[] characters = {'a', 'a', 'a'};
        CountingElements<Character> counting = new CountingElements<>();
        int excepted = 3;
        int result = counting.counting(characters);
        assertThat(result, is(excepted));
    }
}