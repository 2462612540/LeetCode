/**
 * Copyright (C), 2018-2020
 * FileName: mergeKLists
 * Author:   xjl
 * Date:     2020/8/13 14:42
 * Description: 23. 合并K个排序链表
 */
package LinkList;

public class mergeKLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 依次去做链表的合并
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0){
            return null;
        }
        ListNode result = lists[0];
        for (int i = 1; i < lists.length; i++) {
            ListNode res = mergeTwoLists(result, lists[i]);
            result=res;
        }
        return result;
    }

    /**
     * 合并链表的数据
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 创建一个新的链表
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
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
