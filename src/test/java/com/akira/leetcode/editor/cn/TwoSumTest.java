package com.akira.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwoSumTest {
    @Test
    public void twoSum() {
        TwoSum.Solution solution = new TwoSum().new Solution();

        int[] nums = new int[] {1, 2, 3, 4, 5, 6};
        int target = 10;
        int[] expected = new int[] {3, 5};

        assertArrayEquals(expected, solution.twoSum1(nums, target));
        assertArrayEquals(expected, solution.twoSum2(nums, target));
        assertArrayEquals(expected, solution.twoSum3(nums, target));
    }
}