package 计算机程序算法分类.链表问题;

/**
 * @Classname 合并两个链表
 * @Description TODO
 * @Date 2021/4/8 14:52
 * @Created by xjl
 */
public class 合并两个链表 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dumpy = new ListNode(-1);
        ListNode curr = dumpy;
        //遍历两个链表
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        //判断最后的 当然也可以使用的if 来判断
        curr.next = l1 != null ? l1 : l2;
        return dumpy.next;
    }

}
