package com.akira.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddTwoNumbersTest {
    @Test
    public void addTwoNumbers() {
        AddTwoNumbers.Solution solution = new AddTwoNumbers().new Solution();

        assertEquals("0>0>0>0>1", solution.addTwoNumbers(
                new AddTwoNumbers.ListNode(new int[] {9}),
                new AddTwoNumbers.ListNode(new int[] {1, 9, 9, 9})).toString());

        assertEquals("0>5>6", solution.addTwoNumbers(
                new AddTwoNumbers.ListNode(new int[] {9, 2, 3}),
                new AddTwoNumbers.ListNode(new int[] {1, 2, 3})).toString());

        assertEquals("0", solution.addTwoNumbers(
                new AddTwoNumbers.ListNode(new int[] {0}),
                new AddTwoNumbers.ListNode(new int[] {0})).toString());
    }
}