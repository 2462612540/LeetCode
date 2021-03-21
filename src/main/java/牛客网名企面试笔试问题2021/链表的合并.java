package 牛客网名企面试笔试问题2021;

/**
 * @Classname 链表的合并
 * @Description TODO
 * @Date 2021/3/8 12:35
 * @Created by xjl
 */
public class 链表的合并 {

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        // 创建一个新的链表
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        // 任一为空，直接连接另一条链表
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return pre.next;
    }
}
