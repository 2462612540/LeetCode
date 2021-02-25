/**
 * Copyright (C), 2018-2020
 * FileName: splitListToParts725
 * Author:   xjl
 * Date:     2020/8/13 9:00
 * Description: 分个链表
 */
package leetcode练习题;

public class splitListToParts725 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] ans = new ListNode[k];
        //统计链表的长度
        int len = 0;
        ListNode curr = root;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        //计算有多少组 和多余的个数
        int l = len / k;
        int r = len % k;

        ListNode head = root;
        ListNode pre = null;

        for (int i = 0; i < k; i++, --r) {
            ans[i] = head;
            int part_len = l + (r > 0 ? 1 : 0);
            for (int j = 0; j < part_len; j++) {
                pre = head;
                head = head.next;
            }
            //设置节点断开
            if (pre != null) {
                pre.next = null;
            }
        }
        return ans;
    }
}
