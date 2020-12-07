/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package 秋招笔试问题集合;

import java.util.ArrayList;

public class 字符串中是否有环 {
    static class ListNode {
        Character val;
        ListNode next;

        public ListNode(Character val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        String str = "{(A->B),(B->C),(C->A)}";
        int res = test11(str);
        System.out.println(res);
    }

    private static int test11(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                list.add(str.charAt(i));
            }
        }
        ArrayList<Character> ans = new ArrayList<>();
        ans.add(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) != list.get(i - 1)) {
                ans.add(list.get(i));
            }
        }
        ListNode node = new ListNode(' ');
        ListNode curr = node;
        for (Character c : ans) {
            curr.next = new ListNode(c);
            curr = curr.next;
        }
        if (curr.val==node.next.val){
            curr.next=node.next;
        }
        if (test12(node.next)) {
            return 1;
        } else {
            return -1;
        }
    }

    private static boolean test12(ListNode head) {
        if (head == null) return false;
        ListNode fast = head;
        ListNode low = head;
        while (fast != null && fast.next != null) {
            //快慢指针的效果
            fast = fast.next.next;
            low = low.next;
            if (low == fast) {
                return true;
            }
        }
        return false;
    }
}
