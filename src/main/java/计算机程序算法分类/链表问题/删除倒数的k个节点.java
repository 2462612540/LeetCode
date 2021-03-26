package 计算机程序算法分类.链表问题;

/**
 * @Classname 删除倒数的k个节点
 * @Description TODO
 * @Date 2021/3/26 19:35
 * @Created by xjl
 */
public class 删除倒数的k个节点 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * @description TODO  双指针 然后让这个保持的一样的速度移动就可以保持的了
     * @param: head
     * @param: k
     * @date: 2021/3/26 19:36
     * @return: 计算机程序算法分类.链表问题.删除倒数的k个节点.ListNode
     * @author: xjl
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head, latter = head;
        for (int i = 0; i < k; i++)
            former = former.next;
        while (former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }
}
