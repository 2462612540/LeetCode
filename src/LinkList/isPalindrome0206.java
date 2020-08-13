/**
 * Copyright (C), 2018-2020
 * FileName: isPalindrome0206
 * Author:   xjl
 * Date:     2020/8/12 20:18
 * Description:
 */
package LinkList;

import org.junit.Test;

public class isPalindrome0206 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 反转链表比较
     *
     * @param head
     * @return
     */
    public boolean isPalindrome1(ListNode head) {
        // 使用快慢指针，慢指针在进行操作的时候，顺带的进行链表的翻转，在进行半个链表之间的比较
        if (head == null) {
            return true;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode slow = dummyNode;
        ListNode fast = dummyNode;
        ListNode prev = null;

        // 使用快慢指针找到链表的中间位置，并翻转慢指针前的链表
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            // 链表翻转
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        ListNode rigth;
        if (fast != null) {
            // 不为空，表示链表size为偶数
            // 0 -> 1 -> 2 -> 3, prev指向1，slow指向2，要比较prev与right，先确定位置1与2的val是不是一样的
            if (slow.val != slow.next.val) {
                return false;
            }
            // rigth从3开始
            rigth = slow.next.next;
        } else {
            // 为空，表示链表size为奇数
            // 0 -> 1 -> 2 -> 3 -> 4, prev指向1，slow指向2
            // rigth从3开始
            rigth = slow.next;
        }
        // 比较两个链表
        while (prev != null && rigth != null) {
            if (prev.val != rigth.val) {
                return false;
            }
            prev = prev.next;
            rigth = rigth.next;
        }
        return true;
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public ListNode test11(ListNode head) {
        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;

        ListNode pre = dumpy;
        ListNode curr = head;

        while (curr.next != null) {
            ListNode furtue = curr.next;
            curr.next = furtue.next;
            furtue.next = pre.next;
            pre.next = furtue;
        }
        return dumpy.next;
    }

    public boolean isPalindrome3(ListNode head) {
        if (head==null)return true;
        String result1 = "";
        ListNode curr = head;
        while (curr != null) {
            result1 += String.valueOf(curr.val);
            curr = curr.next;
        }
        ListNode node = test11(head);
        String result2 = "";
        while (node != null) {
            result2 += String.valueOf(node.val);
            node = node.next;
        }
        return result1.equals(result2);
    }

    @Test
    public void test() {
        ListNode s1 = new ListNode(1);
        boolean palindrome3 = isPalindrome3(s1);
        System.out.println(palindrome3);
    }


    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode midNode = findMidNode(head);
        ListNode secondHalfHead = reverseLinked(midNode.next);
        ListNode curr1 = head;
        ListNode curr2 = secondHalfHead;
        boolean palindrome = true;
        while(palindrome && curr2 != null){
            if(curr1.val != curr2.val) palindrome = false;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return palindrome;
    }

    /* 反转链表 */
    private ListNode reverseLinked(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        while(cur != null){
            ListNode nextTemp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextTemp;
        }
        return prev;
    }

    /* 快慢指针寻找中间节点 */
    private ListNode findMidNode(ListNode head){
        ListNode fast = head;
        ListNode low = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            low = low.next;
        }
        return low;
    }
}
