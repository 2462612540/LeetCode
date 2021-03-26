package 计算机程序算法分类.链表问题;

import org.junit.Test;

/**
 * @Classname 删除指定的节点
 * @Description TODO
 * @Date 2021/3/26 16:36
 * @Created by xjl
 */
public class 删除指定的节点 {

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode curr = dump;

        while (curr.next != null) {
            ListNode future = curr.next;
            if (future.val==val){
                curr.next=future.next;
            }else {
                curr=future;
            }
        }
        return dump.next;
    }

    @Test
    public void test() {
        ListNode s1 = new ListNode(1);
        ListNode s2 = new ListNode(2);
        ListNode s3 = new ListNode(3);
        ListNode s4 = new ListNode(4);
        ListNode s5 = new ListNode(5);
        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s5;
        ListNode res = deleteNode(s1, 5);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
