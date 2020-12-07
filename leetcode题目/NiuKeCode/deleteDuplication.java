/**
 * Copyright (C), 2018-2020
 * FileName: deleteDuplication
 * Author:   xjl
 * Date:     2020/5/9 14:48
 * Description: 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
package NiuKeCode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class deleteDuplication {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication1(ListNode pHead) {
        Set<Integer> set = new HashSet<>();
        while (pHead != null) {
            if (!set.contains(pHead.val)) {
                set.add(pHead.val);
            } else {
                set.remove(pHead.val);
            }
            pHead = pHead.next;
        }
        ListNode pre = new ListNode(0);
        ListNode curr = pre;
        for (int va : set) {
            curr.next = new ListNode(va);
            curr = curr.next;
        }
        return pre.next;
    }

    public ListNode deleteDuplication3(ListNode pHead) {
        ListNode pre = new ListNode(0);
        pre.next = pHead;
        ListNode curr = pre;
        while (pHead != null) {
            ListNode node = pHead.next;
            if (node != null) {
                if (pHead.val == node.val) {
                    curr.next = node;
                    curr = curr.next;
                } else {
                    curr = curr.next;
                }
            } else {
                break;
            }
            pHead = pHead.next;
        }
        return pre.next;
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) return null;

        ListNode n = new ListNode(0);
        ListNode p = pHead;
        ListNode pre = n;
        n.next = pHead;

        boolean flag = false;
        while (p != null) {
            ListNode q = p.next;
            if (q == null) break;
            if (q.val == p.val) {
                while (q != null && q.val == p.val) {
                    q = q.next;
                }
                pre.next = q;
                p = q;
            } else {
                if (!flag) {
                    n.next = p;
                    flag = true;
                }
                pre = p;
                p = q;
            }
        }
        return n.next;
    }

    public ListNode deleteDuplication2(ListNode pHead) {
        ListNode result;
        ListNode temp = pHead;
        ListNode index = new ListNode(1);
        index.next = pHead;
        result = index;
        while (temp != null) {
            if (temp.next != null && temp.next.val == temp.val) {
                while (temp.next != null && temp.next.val == temp.val) {
                    temp = temp.next;
                }
                temp = temp.next;
                index.next = temp;
            } else {
                index = index.next;
                temp = temp.next;
            }
        }
        return result.next;
    }

    @Test
    public void test() {
        ListNode s1 = new ListNode(1);
        ListNode s2 = new ListNode(2);
        ListNode s3 = new ListNode(3);
        ListNode s4 = new ListNode(3);
        ListNode s5 = new ListNode(4);
        ListNode s6 = new ListNode(4);
        ListNode s7 = new ListNode(5);

        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s5;
        s5.next = s6;
        s6.next = s7;

        ListNode res = deleteDuplication3(s1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

}
