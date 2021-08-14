package com.akira.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumSubarrayTest {
    @Test
    public void maxSubArray() {
        MaximumSubarray.Solution solution = new MaximumSubarray().new Solution();
        assertEquals(3, solution.maxSubArray(new int[] {0, 1, 2}));
        assertEquals(6, solution.maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}