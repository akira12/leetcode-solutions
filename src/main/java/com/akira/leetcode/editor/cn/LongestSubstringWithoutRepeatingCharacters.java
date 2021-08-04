//Given a string s, find the length of the longest substring without repeating c
//haracters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// Example 4: 
//
// 
//Input: s = ""
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 104 
// s consists of English letters, digits, symbols and spaces. 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 5819 👎 0


package com.akira.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Zhao Liang
 * 2021-07-28 22:35:53
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        return lengthOfLongestSubstring3(s);
    }

    // bubble sort alike
    public int lengthOfLongestSubstring1(String s) {
        int result = 0;

        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            charSet.clear();
            for (int j = 0; i + j < s.length() && !charSet.contains(s.charAt(i + j)); j++) {
                charSet.add(s.charAt(i + j));
                if (charSet.size() > result) {
                    result = charSet.size();
                }
            }
        }

        return result;
    }

    // optimized
    public int lengthOfLongestSubstring2(String s) {
        int result = 0;

        Map<Character, Integer> charMap = new HashMap<>();
        int i = 0;
        int j = 0;
        while (i < s.length()) {
            charMap.clear();
            while (i + j < s.length()) {
                if (!charMap.containsKey(s.charAt(i + j))) {
                    charMap.put(s.charAt(i + j), i + j);
                    result = Math.max(result, charMap.size());
                    j++;
                } else {
                    // i is set to the next character of the repeated character
                    i = charMap.get(s.charAt(i + j)) + 1;
                    j = 0;
                    break;
                }
            }

            // j has reached the end
            if (i + j == s.length()) {
                break;
            }
        }

        return result;
    }

    // sliding window
    public int lengthOfLongestSubstring3(String s) {
        int result = 0;

        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        while (left < s.length()) {
            if (right == s.length()) {
                break;
            }

            while (right < s.length()) {
                if (!map.containsKey(s.charAt(right))) {
                    map.put(s.charAt(right), right);
                    result = Math.max(result, map.size());
                    right++;
                }
                else {
                    // remove skipped characters from map
                    int next = map.get(s.charAt(right)) + 1;
                    for (int i = left; i < next; i++) {
                        map.remove(s.charAt(i));
                    }

                    // add current character to map
                    map.put(s.charAt(right), right);

                    left = next;
                    right++;
                    break;
                }
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
