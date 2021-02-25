/**
 * Copyright (C), 2018-2020
 * FileName: ReverseList001
 * Author:   xjl
 * Date:     2020/6/4 10:26
 * Description: 链表的翻转
 */
package leetcode练习题;

import org.junit.Test;

public class ReverseList001 {
    public ListNode reverselist(ListNode head) {
        //实现单链表的翻转
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode ListNode = curr.next;
            curr.next = pre;
            pre = curr;
            curr = ListNode;
        }
        return pre;
    }

    //删除掉当前的节点的目标的值
    public ListNode deletdone(ListNode head, int target) {
        ListNode node = new ListNode(3);
        node.next = head;
        ListNode pre = node;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == target) {
                ListNode next = curr.next;
                pre.next = next;
            }
            pre = curr;
            curr = curr.next;
        }
        return node.next;
    }

    //删除重复的数据所有的
    public ListNode deletrepate(ListNode head) {
        ListNode result;
        ListNode index = new ListNode(1);
        ListNode temp = head;
        index.next = head;
        result = index;

        while (temp != null) {
            if (temp.next != null && temp.val == temp.next.val) {
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

    public ListNode deletrepate22(ListNode head) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode pre = node;
        ListNode curr = head;
        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                curr = curr.next;
                pre.next = curr;
            } else {
                pre = pre.next;
                curr = curr.next;
            }
        }
        return node.next;
    }

    //删除重复的数据的数字只保留一个
    public ListNode deletrepate2(ListNode head) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode pre = node;
        ListNode curr = head;
        while (curr != null) {
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            pre.next = curr;
            pre = pre.next;
            curr = curr.next;
        }
        return node.next;
    }

    @Test
    public void test() {
        ListNode s1 = new ListNode(1);
        ListNode s2 = new ListNode(1);
        ListNode s3 = new ListNode(2);
        ListNode s4 = new ListNode(3);
        ListNode s5 = new ListNode(3);

        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s5;

//        System.out.println("==============单链表的翻转======================");
//        ListNode node = reverselist(s1);
//        while (node != null) {
//            System.out.print(node.val + "===");
//            node = node.next;
//        }

//        System.out.println("==============链表删除指定的元素======================");
//        //删除后的结果是
//        ListNode deletdone = deletdone(s1, 3);
//        while (deletdone != null) {
//            System.out.println(deletdone.val);
//            deletdone = deletdone.next;
//        }
//
//        System.out.println("===============链表删除重复的元素=====================");
//        ListNode deletrepate1 = deletrepate22(s1);
//        while (deletrepate1 != null) {
//            System.out.println(deletrepate1.val);
//            deletrepate1 = deletrepate1.next;
//        }

        System.out.println("==============链表删除重复保留一个的元素======================");
        ListNode ListNode = deletrepate2(s1);
        while (ListNode != null) {
            System.out.println(ListNode.val);
            ListNode = ListNode.next;
        }
    }

    private class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
