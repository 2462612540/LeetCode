package 计算机程序算法分类.链表问题;

/**
 * @Classname 删除链表的节点I
 * @Description TODO
 * @Date 2021/4/8 14:49
 * @Created by xjl
 */
public class 删除链表的节点I {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {

        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode curr = dump;

        while (curr.next != null) {
            //记录好下一个节点是什么
            ListNode future = curr.next;
            if (future.val == val) {
                curr.next = future.next;
            } else {
                curr = future;
            }
        }
        return dump.next;
    }
}
