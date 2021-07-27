//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order, and each of their nodes contains a si
//ngle digit. Add the two numbers and return the sum as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// 
// Example 1: 
//
// 
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
// 
//
// Example 2: 
//
// 
//Input: l1 = [0], l2 = [0]
//Output: [0]
// 
//
// Example 3: 
//
// 
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in each linked list is in the range [1, 100]. 
// 0 <= Node.val <= 9 
// It is guaranteed that the list represents a number that does not have leading
// zeros. 
// 
// Related Topics 递归 链表 数学 
// 👍 6486 👎 0


package com.akira.leetcode.editor.cn;

/**
 * @author Zhao Liang
 * 2021-07-24 09:53:50
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();

        //ListNode l1 = createList(new int[] {9 ,2 ,3});
        //ListNode l2 = createList(new int[] {1 ,2 ,3});
        //ListNode l1 = createList(new int[] {0});
        //ListNode l2 = createList(new int[] {0});
        ListNode l1 = createList(new int[] {9});
        ListNode l2 = createList(new int[] {1, 9, 9, 9});
        ListNode result = solution.addTwoNumbers(l1, l2);
        printResult(result);
    }

    private static ListNode createList(int[] array) {
        ListNode headNode = new ListNode(array[0], null);
        ListNode node = headNode;
        for (int i = 1; i < array.length; i++) {
            node.next = new ListNode(array[i], null);
            node = node.next;
        }
        return headNode;
    }

    private static void printResult(ListNode listNode) {
        ListNode node = listNode;
        StringBuilder sb = new StringBuilder();

        do {
            sb.append(node.val);
            node = node.next;
            if (node != null) {
                sb.append("->");
            }
        } while (node != null);

        System.out.println(sb.toString());
    }

// Definition for singly-linked list.
static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // add the nodes one by one
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;

        ListNode curL1Node = l1;
        ListNode curL2Node = l2;
        ListNode curResultNode = null;
        boolean add = false;
        do {
            int sum = (curL1Node != null ? curL1Node.val : 0) + (curL2Node != null ? curL2Node.val : 0) + (add ? 1 : 0);
            ListNode node = new ListNode(sum % 10, null);
            add = sum >= 10;

            if (curResultNode == null) {
                // the first node
                result = node;
            }
            else {
                curResultNode.next = node;
            }

            curResultNode = node;

            if (curL1Node != null) {
                curL1Node = curL1Node.next;
            }

            if (curL2Node != null) {
                curL2Node = curL2Node.next;
            }
        } while (curL1Node != null || curL2Node != null);

        // deal with the last add
        if (add) {
            curResultNode.next = new ListNode(1, null);
        }

        return result;
    }

    // convert to number to add, but can not handle big number
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        long num1 = convertListNodeToInt(l1);
        long num2 = convertListNodeToInt(l2);
        return convertIntToListNode(num1 + num2);
    }

    private long convertListNodeToInt(ListNode listNode) {
        long result = 0;

        ListNode node = listNode;
        int count = 0;
        while (node != null) {
            result += node.val * Math.pow(10, count);
            node = node.next;
            count++;
        }

        return result;
    }

    private ListNode convertIntToListNode(long num) {
        if (num == 0) {
            return new ListNode(0, null);
        }

        ListNode head = null;
        ListNode tail = null;
        long div = num;
        while (div > 0) {
            int remain = (int)(div % 10);
            div /= 10;

            ListNode newNode = new ListNode(remain, null);
            if (head == null) {
                head = newNode;
            }
            else {
                tail.next = newNode;
            }
            tail = newNode;
        }

        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
