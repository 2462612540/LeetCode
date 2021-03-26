package leetode每日一题;

import org.junit.Test;

/**
 * @Classname 删除链表的重复元素
 * @Description TODO
 * @Date 2021/3/26 13:54
 * @Created by xjl
 */
public class 删除链表多余的元素节点 {

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        ListNode no1 = new ListNode(1);
        ListNode no2 = new ListNode(2);
        ListNode no3 = new ListNode(3);
        ListNode no4 = new ListNode(3);

        head.next = no1;
        no1.next = no2;
        no2.next = no3;
        no3.next = no4;

        ListNode listNode = deleteDuplicates(head);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }

    }
}
