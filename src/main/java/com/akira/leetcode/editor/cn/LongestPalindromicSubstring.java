//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// Example 3: 
//
// 
//Input: s = "a"
//Output: "a"
// 
//
// Example 4: 
//
// 
//Input: s = "ac"
//Output: "a"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters. 
// 
// Related Topics 字符串 动态规划 
// 👍 3947 👎 0


package com.akira.leetcode.editor.cn;

/**
 * @author Zhao Liang
 * 2021-08-12 23:53:14
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        String result = null;

        // traverse all substrings
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                String ss = s.substring(i, i + j + 1);
                int len = lengthOfPalindrome(ss);
                if (len > max) {
                    result = ss;
                    max = len;
                }
            }
        }

        return result;
    }

    /**
     * test and calculate the length of a palindrome
     * @param s
     * @return the length of the palindrome, if not palindrome returns 0
     */
    private int lengthOfPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return 0;
            }
        }

        return s.length();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
