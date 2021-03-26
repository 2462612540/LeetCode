package 计算机程序算法分类.链表问题;

/**
 * @Classname 两个链表的公共交点  这个题目也是可以里一共的两个栈来实现 因为的栈的特点是先进后出 所以能够保证的后面的出来的是一样的 记录最后一相同的就行
 * @Description TODO
 * @Date 2021/3/26 19:41
 * @Created by xjl
 */
public class 两个链表的公共交点 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * @description TODO  公共的第一个点  有点像判断的是否又环的一个特征的表现
     * @param: headA
     * @param: headB
     * @date: 2021/3/26 19:42
     * @return: 计算机程序算法分类.链表问题.两个链表的公共交点.ListNode
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
