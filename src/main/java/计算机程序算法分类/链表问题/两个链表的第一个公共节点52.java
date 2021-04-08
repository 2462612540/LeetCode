package 计算机程序算法分类.链表问题;

/**
 * @Classname 两个链表的第一个公共节点52
 * @Description TODO
 * @Date 2021/4/8 15:10
 * @Created by xjl
 */
public class 两个链表的第一个公共节点52 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
        /**
         * @description TODO 有点类似于是写这个链表的的环的一样
         * @param: headA
         * @param: headB
         * @date: 2021/4/8 15:11
         * @return: 计算机程序算法分类.链表问题.两个链表的第一个公共节点52.ListNode
         * @author: xjl
        */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode A = headA, B = headB;
            while (A != B) {
                A = A != null ? A.next : headB;
                B = B != null ? B.next : headA;
            }
            return A;
        }
    }
}
