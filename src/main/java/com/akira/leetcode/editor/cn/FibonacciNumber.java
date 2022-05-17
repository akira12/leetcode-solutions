//The Fibonacci numbers, commonly denoted F(n) form a sequence, called the 
//Fibonacci sequence, such that each number is the sum of the two preceding ones, 
//starting from 0 and 1. That is, 
//
// 
//F(0) = 0, F(1) = 1
//F(n) = F(n - 1) + F(n - 2), for n > 1.
// 
//
// Given n, calculate F(n). 
//
// 
// Example 1: 
//
// 
//Input: n = 2
//Output: 1
//Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
// 
//
// Example 2: 
//
// 
//Input: n = 3
//Output: 2
//Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
// 
//
// Example 3: 
//
// 
//Input: n = 4
//Output: 3
//Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 30 
// 
// Related Topics 递归 记忆化搜索 数学 动态规划 👍 320 👎 0


package com.akira.leetcode.editor.cn;

/**
 * @author Zhao Liang
 * 2021-09-09 23:02:56
 */
public class FibonacciNumber {
    public static void main(String[] args) {
        Solution solution = new FibonacciNumber().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fib(int n) {
        return fib3(n);
    }

    // using the definition of Fibonacci sequence
    public int fib1(int n) {
        int a = 0, b = 1;

        if (n == 0) {
            return a;
        }

        for (int i = 0; i < n - 1; i++) {
            if (i % 2 == 0) {
                a += b;
            }
            else {
                b += a;
            }
        }

        return Math.max(a, b);
    }

    // recursive
    public int fib2(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fib2(n - 2) + fib2(n - 1);
    }

    // recursive with memo
    public int fib3(int n) {
        int[] memos = new int[n + 2];
        for (int i = 0; i < memos.length; i++) {
            memos[i] = -1;
        }

        memos[0] = 0;
        memos[1] = 1;
        return fibHelper(n, memos);
    }

    public int fibHelper(int n, int[] memos) {
        if (memos[n] < 0) {
            memos[n] = fibHelper(n - 2, memos) + fibHelper(n - 1, memos);
        }
        return memos[n];
    }

    // another implementation using the definition of Fibonacci sequence
    public int fib4(int n) {
        int a = 0, b = 1;

        if (n == 0) {
            return 0;
        }

        for (int i = 0; i < n - 1; i++) {
            if (a > b) {
                b += a;
            }
            else {
                a += b;
            }
        }

        return Math.max(a, b);
    }

    // dynamic programming
    public int fib5(int n) {
        int result = 0;


        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
