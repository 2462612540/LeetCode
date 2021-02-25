package 牛客网名企高频面试题143复现代码;

/**
 * @Classname 删除指定的节点
 * @Description TODO
 * @Date 2020/12/22 15:01
 * @Created by xjl
 */
public class 删除指定的节点 {

    /**
     * @description TODO  删除的是倒数的第n节点  先计算是的个数 然后在的前一个停下来 在将前一个指向下一个的下一个的节点
     * @param: val
     * @date: 2020/12/22 15:19
     * @return:
     * @author: xjl
     */
    public ListNode deone(ListNode head, int n) {
        //计算右多少个节点
        ListNode n1 = head;
        int count = 0;
        while (n1 != null) {
            count++;
            n1 = n1.next;
        }

        ListNode dumy = new ListNode(0);
        dumy.next = head;
        ListNode curr = dumy;
        //在删除一个节点
        count = count - n;
        while (count > 0) {
            curr = curr.next;
            count--;
        }
        curr.next = curr.next.next;
        return dumy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
