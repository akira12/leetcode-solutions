//Given two sorted arrays nums1 and nums2 of size m and n respectively, return t
//he median of the two sorted arrays. 
//
// The overall run time complexity should be O(log (m+n)). 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,3], nums2 = [2]
//Output: 2.00000
//Explanation: merged array = [1,2,3] and median is 2.
// 
//
// Example 2: 
//
// 
//Input: nums1 = [1,2], nums2 = [3,4]
//Output: 2.50000
//Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
// 
//
// Example 3: 
//
// 
//Input: nums1 = [0,0], nums2 = [0,0]
//Output: 0.00000
// 
//
// Example 4: 
//
// 
//Input: nums1 = [], nums2 = [1]
//Output: 1.00000
// 
//
// Example 5: 
//
// 
//Input: nums1 = [2], nums2 = []
//Output: 2.00000
// 
//
// 
// Constraints: 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
// Related Topics 数组 二分查找 分治 
// 👍 4315 👎 0


package com.akira.leetcode.editor.cn;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author Zhao Liang
 * 2021-08-05 01:05:24
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return findMedianSortedArrays2(nums1, nums2);
    }

    // use Stream
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int[] all = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2)).sorted().toArray();
        if (all.length % 2 != 0) {
            return all[all.length / 2];
        }
        else {
            return (all[all.length / 2 - 1] + all[all.length / 2]) / 2.0;
        }
    }

    // two pointers
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int[] median = new int[] {-1, -1};

        int i = 0, j = 0;
        for (int count = 0; count <= (nums1.length + nums2.length) / 2; count++) {
            int n1 = i < nums1.length ? nums1[i] : Integer.MAX_VALUE;
            int n2 = j < nums2.length ? nums2[j] : Integer.MAX_VALUE;

            if (n1 <= n2) {
                median[count % 2] = n1;
                i++;
            }
            else {
                median[count % 2] = n2;
                j++;
            }
        }

        if ((nums1.length + nums2.length) % 2 != 0) {
            return Math.max(median[0], median[1]);
        }
        else {
            return (median[0] + median[1]) / 2.0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
