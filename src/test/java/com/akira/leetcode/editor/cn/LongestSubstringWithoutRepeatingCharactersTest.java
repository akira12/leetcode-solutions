package com.akira.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestSubstringWithoutRepeatingCharactersTest {
    @Test
    public void lengthOfLongestSubstring() {
        LongestSubstringWithoutRepeatingCharacters.Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"));
        assertEquals(4, solution.lengthOfLongestSubstring("abcdcba"));
        assertEquals(1, solution.lengthOfLongestSubstring("wwwwwwwwww"));
    }
}