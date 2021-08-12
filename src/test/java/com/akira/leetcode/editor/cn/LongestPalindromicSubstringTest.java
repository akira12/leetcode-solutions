package com.akira.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPalindromicSubstringTest {
    @Test
    public void longestPalindrome() {
        LongestPalindromicSubstring.Solution solution = new LongestPalindromicSubstring().new Solution();
        assertEquals("cdc", solution.longestPalindrome("abcdc"));
        assertEquals("bcdcb", solution.longestPalindrome("abcdcb"));
        assertEquals("bcdcb", solution.longestPalindrome("aggjbcdcbnng"));
        assertEquals("a", solution.longestPalindrome("a"));
    }
}