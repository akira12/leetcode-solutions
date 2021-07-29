package com.akira.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestSubstringWithoutRepeatingCharactersTest {
    @Test
    public void lengthOfLongestSubstring() {
        LongestSubstringWithoutRepeatingCharacters.Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"));
    }
}