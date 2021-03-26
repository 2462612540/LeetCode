package leetode每日一题;

import org.junit.Test;

/**
 * @Classname 删除全部重复的节点元素
 * @Description TODO
 * @Date 2021/3/26 14:09
 * @Created by xjl
 */
public class 删除全部重复的节点元素 {

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteallDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {
            //如果是的cur.next的等于一下的话
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public ListNode deleteallDuplicates1(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dumpy = new ListNode(0);
        ListNode curr = dumpy;

        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val==curr.next.next.val){
                int x=curr.next.val;
                //遍历找到一个和节点值不相同的的节点
                while (curr.next!=null&&curr.next.val==x){
                    curr.next=curr.next.next;
                }
            }else {
                curr=curr.next;
            }
        }
        return dumpy.next;
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

        ListNode listNode = deleteallDuplicates(head);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
