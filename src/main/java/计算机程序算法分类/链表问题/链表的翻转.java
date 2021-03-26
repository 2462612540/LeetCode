package 计算机程序算法分类.链表问题;

import com.sun.org.apache.xpath.internal.FoundIndex;

/**
 * @Classname 链表的翻转
 * @Description TODO
 * @Date 2021/3/26 15:58
 * @Created by xjl
 */
public class 链表的翻转 {

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

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

    /**
     * @description TODO  采用的是单指针的算法进行遍历
     * @param: head
     * @date: 2021/3/26 16:33
     * @return: 计算机程序算法分类.链表问题.链表的翻转.ListNode
     * @author: xjl
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null) {
            return head;
        }
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

    /**
     * @description TODO  采用的是的一个两个指针算法
     * @param: head
     * @date: 2021/3/26 16:32
     * @return: 计算机程序算法分类.链表问题.链表的翻转.ListNode
     * @author: xjl
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dump = new ListNode(1);
        dump.next = head;

        ListNode pre = dump;
        ListNode curr = head;

        while (curr.next != null) {
            ListNode future = curr.next;
            curr.next = future.next;
            future.next = dump.next;
            pre.next = future;
        }
        return dump.next;
    }

}
