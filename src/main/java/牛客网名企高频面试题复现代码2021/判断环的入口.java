package 牛客网名企高频面试题复现代码2021;

/**
 * @Classname 判断环的入口
 * @Description TODO
 * @Date 2020/12/21 14:44
 * @Created by xjl
 */
public class 判断环的入口 {

    public ListNode test(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                //表示有环
                ListNode start = head;
                ListNode end = slow;
                while (start != end) {
                    start = start.next;
                    end = end.next;
                }
                return start;
            }
        }
        return null;
    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
