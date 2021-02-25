/**
 * Copyright (C), 2018-2020
 * FileName: hasCycle141
 * Author:   xjl
 * Date:     2020/5/26 8:52
 * Description: 给定一个链表，判断链表中是否有环。  为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/linked-list-cycle 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package leetcode练习题;

import org.junit.Test;

public class hasCycle141 {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode curr = head;
        ListNode low = curr;
        ListNode fast = curr.next;
        while (low != fast) {
            //如果是没有环的话则返回flase
            if (fast == null || fast.next == null) {
                return false;
            }
            low = low.next;
            fast = fast.next.next;
        }
        return true;
    }

    @Test
    public void test() {
        ListNode s1 = new ListNode(3);
        ListNode s2 = new ListNode(2);
        ListNode s3 = new ListNode(0);
        ListNode s4 = new ListNode(-4);
    }
}
