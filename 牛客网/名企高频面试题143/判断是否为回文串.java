package 名企高频面试题143; /**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.判断是否为回文串
 * Author:   xjl
 * Date:     2020/10/1 11:33
 * Description:
 */


import org.junit.Test;

import java.util.ArrayList;

public class 判断是否为回文串 {

    public class ListNode {
        int val;
        ListNode next = null;
    }

    public boolean isPail(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            if (!list.get(i).equals(list.get(list.size() - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    public boolean isPail2(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int l = 0, r = list.size() - 1;
        while (l < r) {
            if (!list.get(l).equals(list.get(r))) {
                return false;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }

    @Test
    public void test() {

    }
}
