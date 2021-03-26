package 计算机程序算法分类.链表问题;

import java.util.LinkedList;

/**
 * @Classname 合并两个有序链表
 * @Description TODO
 * @Date 2021/3/26 19:08
 * @Created by xjl
 */
public class 合并两个有序链表 {

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * @description TODO  采用的归并的思想来实现的这样的一个方法
     * @param: l1
     * @param: l2
     * @date: 2021/3/26 19:09
     * @return: 计算机程序算法分类.链表问题.合并两个有序链表.ListNode
     * @author: xjl
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dumpy = new ListNode(-1);
        ListNode curr = dumpy;
        while (l1 != null && l2 != null) {
            //计算小的开始
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 != null ? l1 : l2;
        return dumpy.next;
    }
}
