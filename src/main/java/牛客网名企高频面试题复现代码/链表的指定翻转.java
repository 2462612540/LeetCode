package 牛客网名企高频面试题复现代码;

/**
 * @Classname 链表的指定翻转
 * @Description TODO
 * @Date 2020/12/22 15:49
 * @Created by xjl
 */
public class 链表的指定翻转 {

    /**
     * @description TODO  第一步是就是的找到的是m-1的位置  然后利用的是的翻转链表的第二种的方式来实现这样样的执行就是的是n-m次就结束
     * @param: head
     * @param: m
     * @param: n
     * @date: 2020/12/22 15:51
     * @return: 复现代码.链表的指定翻转.ListNode
     * @author: xjl
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }
        ListNode dumpy = new ListNode(0);
        dumpy.next = head;

        ListNode pre = dumpy;//第一段最后的一个节点
        //找到第m个节点
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;

        for (int i = m; i < n; i++) {
            ListNode future = cur.next;
            cur.next = future.next;
            future.next = pre.next;
            pre.next = future;
        }
        return dumpy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
