//Given an integer array nums, find the contiguous subarray (containing at least
// one number) which has the largest sum and return its sum. 
//
// A subarray is a contiguous part of an array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [1]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: nums = [5,4,-1,7,8]
//Output: 23
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 104 
// -105 <= nums[i] <= 105 
// 
//
// 
// Follow up: If you have figured out the O(n) solution, try coding another solu
//tion using the divide and conquer approach, which is more subtle. 
// Related Topics 数组 分治 动态规划 
// 👍 3560 👎 0


package com.akira.leetcode.editor.cn;

/**
 * @author Zhao Liang
 * 2021-08-14 21:04:58
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        return maxSubArray2(nums);
    }

    // traverse all subarray
    public int maxSubArray1(int[] nums) {
        int sum = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = 0; j < nums.length - i; j++) {
                sum += nums[i + j];
                max = Math.max(max, sum);
            }
        }

        return max;
    }

    // dynamic programming
    // https://leetcode.com/problems/maximum-subarray/discuss/20193/DP-solution-and-some-thoughts
    // dp[n] = maxSubArrayMustIncludeNth(nums[1..n])
    // a[n] = nums[n]
    // dp[n] = dp[n-1] > 0 ? dp[n-1] : 0 + a[n]
    public int maxSubArray2(int[] nums) {
        int dp = 0, max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            dp = Math.max(dp, 0) + nums[i];
            max = Math.max(dp, max);
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
