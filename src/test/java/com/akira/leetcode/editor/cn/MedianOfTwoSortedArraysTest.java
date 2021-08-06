package com.akira.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class MedianOfTwoSortedArraysTest {
    @Test
    public void findMedianSortedArrays() {
        MedianOfTwoSortedArrays.Solution solution = new MedianOfTwoSortedArrays().new Solution();
        assertEquals(3, solution.findMedianSortedArrays(new int[] {1, 2, 3}, new int[] {4, 5}), 0);
        assertEquals(3.5, solution.findMedianSortedArrays(new int[] {1, 2, 3}, new int[] {4, 5, 6}), 0);
    }
}