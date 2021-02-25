/**
 * Copyright (C), 2018-2020
 * FileName: isPalindromeLink
 * Author:   xjl
 * Date:     2020/3/28 13:46
 * Description: 回文链表
 */
package leetcode练习题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class isPalindromeLink {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        int start = 0;
        int end = list.size() - 1;
        while (start <= end) {
            if (arr[start] != arr[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    @Test
    public void test() {
        ListNode n1 = new ListNode(-129);
        ListNode n2 = new ListNode(-129);
        ListNode n3 = null;
        n1.next = n2;
        n2.next = n3;
        System.out.println(isPalindrome(n1));
    }
}
