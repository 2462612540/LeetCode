package 名企高频面试题143;

import org.junit.Test;

/**
 * @Classname 链表的排序
 * @Description TODO
 * @Date 2020/12/19 15:53
 * @Created by xjl
 */
public class 链表的排序 {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        //快慢指针，找到中间节点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        ListNode start = head;
        ListNode end1 = mid.next;
        mid.next = null;//断链
        ListNode end = reverList(end1);
        //插入
        while (start != null && end != null) {
            ListNode next1 = start.next;
            ListNode next2 = end.next;
            start.next = end;
            end.next = next1;
            start = next1;
            end = next2;
        }
        return;
    }

    private ListNode reverList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    @Test
    public void test() {
        ListNode root = new ListNode(1);
        ListNode s1 = new ListNode(2);
        ListNode s2 = new ListNode(3);
        ListNode s3 = new ListNode(4);
//        ListNode s4 = new ListNode(5);

        root.next = s1;
        s1.next = s2;
        s2.next = s3;
//        s3.next = s4;

        reorderList(root);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
