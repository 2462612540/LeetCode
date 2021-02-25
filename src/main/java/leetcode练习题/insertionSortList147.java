/**
 * Copyright (C), 2018-2020
 * FileName: insertionSortList147
 * Author:   xjl
 * Date:     2020/5/26 9:45
 * Description: 插入排序算法：      插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。     每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。     重复直到所有输入数据插入完为止。  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/insertion-sort-list 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package leetcode练习题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class insertionSortList147 {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        List<Integer> list = new ArrayList();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Collections.sort(list);
        ListNode pre = new ListNode(0);
        ListNode curr = pre;
        for (int val : list) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return pre.next;
    }

    public ListNode insertionSortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode pre = head;
        ListNode cur = head.next;
        dummy.next = head;
        while (cur != null) {
            if (pre.val <= cur.val) {
                // 本来就有序
                pre = cur;
                cur = cur.next;
            } else {
                ListNode p = dummy;
                // 找到一个位置使得p < cur < p.next
                while (p.next != cur && p.next.val < cur.val) {
                    p = p.next;
                }
                // 将cur插入到p和p.next之间
                // 因为cur被插到前面，pre的指针需要跳过cur
                pre.next = cur.next;
                cur.next = p.next;
                p.next = cur;
                // 完成插入后，cur回到pre前面
                cur = pre.next;
            }
        }
        return dummy.next;
    }

    @Test
    public void test() {
        ListNode s1 = new ListNode(4);
        ListNode s2 = new ListNode(1);
        ListNode s3 = new ListNode(1);
        ListNode s4 = new ListNode(-3);

        s1.next = s2;
        s2.next = s3;
        s3.next = s4;

        ListNode listNode = insertionSortList(s1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}
