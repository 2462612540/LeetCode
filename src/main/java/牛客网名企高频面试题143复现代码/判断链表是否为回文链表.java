package 牛客网名企高频面试题143复现代码;

/**
 * @Classname 判断链表是否为回文链表
 * @Description TODO
 * @Date 2020/12/22 18:27
 * @Created by xjl
 */
public class 判断链表是否为回文链表 {
    public boolean isPail(ListNode head) {
        String res = "";
        while (head != null) {
            res += String.valueOf(head.val);
            head = head.next;
        }
        for (int i = 0; i < res.length() / 2; i++) {
            if (res.charAt(i) == res.charAt(res.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @description TODO  将链表反转的 遍历可以  但是的这是的一个将会超时的一个代码
     * @param: head
     * @date: 2020/12/22 18:28
     * @return: boolean
     * @author: xjl
     */
    public boolean isPail2(ListNode head) {
        ListNode second = rever(head);
        while (head != null && second != null) {
            if (head.val != second.val) {
                return false;
            }
            head = head.next;
            second = second.next;
        }
        return true;
    }

    private ListNode rever(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode future = curr.next;
            curr.next = pre;
            pre = curr;
            curr = future;
        }
        return pre;
    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
