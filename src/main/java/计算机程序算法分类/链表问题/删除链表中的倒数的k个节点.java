package 计算机程序算法分类.链表问题;

/**
 * @Classname 删除链表中的倒数的k个节点
 * @Description TODO
 * @Date 2021/4/8 14:55
 * @Created by xjl
 */
public class 删除链表中的倒数的k个节点 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    /**
     * @description TODO 找到的k-1的节点 然后k-1的节点只想k+1的节点的就可以
     * @param: head
     * @param: k
     * @date: 2021/4/8 14:55
     * @return: 计算机程序算法分类.链表问题.删除链表中的倒数的k个节点.ListNode
     * @author: xjl
    */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode node = head;
        ListNode res = new ListNode(0);
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        for (int i = 0; i < (count - k); i++) {
            node = node.next;
        }
        return node;
    }
}
