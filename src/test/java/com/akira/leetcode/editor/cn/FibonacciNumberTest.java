package com.akira.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciNumberTest {
    @Test
    public void fib() {
        FibonacciNumber.Solution solution = new FibonacciNumber().new Solution();
        assertEquals(0, solution.fib(0));
        assertEquals(1, solution.fib(1));
        assertEquals(8, solution.fib(6));
    }
}