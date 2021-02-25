/**
 * Copyright (C), 2018-2020
 * FileName: mergeTwoLists
 * Author:   xjl
 * Date:     2020/2/29 17:20
 * Description: 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
package leetcode练习题;

/**
 * 意思就是将链表2插入到链表1中
 * 先遍历链表2，然后取出来，在来遍历链表1
 *  如果链表2的数小于等于链表1的数据则将链表的数据插入到链表1的位置
 *  否则就
 */
public class mergeTwoLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 创建一个新的链表
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        // 任一为空，直接连接另一条链表
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return dummyHead.next;
    }
    public static void main(String[] args) {

    }
}

