package 计算机程序算法分类.链表问题;

/**
 * @Classname 从尾到头打印链表06
 * @Description TODO
 * @Date 2021/4/8 14:50
 * @Created by xjl
 */
public class 从尾到头打印链表06 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * @description TODO  先统计的数字的个数 再然后将遍历后将数组从后面开始存储的 倒序存储的原理
     * @param: head
     * @date: 2021/4/8 14:51
     * @return: int[]
     * @author: xjl
     */
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        int count = 0;
        ListNode curr = head;

        while (curr != null) {
            count++;
            curr = curr.next;
        }
        int[] num = new int[count];

        while (head != null) {
            num[--count] = head.val;
            head = head.next;
        }
        return num;
    }
}
