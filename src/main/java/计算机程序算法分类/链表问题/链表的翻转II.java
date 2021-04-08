package 计算机程序算法分类.链表问题;

/**
 * @Classname 链表的翻转II
 * @Description TODO
 * @Date 2021/4/8 14:41
 * @Created by xjl
 */
public class 链表的翻转II {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode dumy = new ListNode(-1);
        dumy.next = head;

        ListNode pre = dumy;
        ListNode curr = head;
        while (curr.next != null) {
            ListNode future=curr.next;
            curr.next=future.next;
            future.next=dumy.next;
            pre.next=future;
        }
        return dumy.next;
    }
}
