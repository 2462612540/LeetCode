package 牛客网名企高频面试题复现代码2020;

/**
 * @Classname 删除链表的全部重复元素
 * @Description TODO
 * @Date 2020/12/21 15:29
 * @Created by xjl
 */
public class 删除链表的全部重复元素 {

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteallDuplicates1(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dumpy = new ListNode(0);
        ListNode curr = dumpy;

        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val==curr.next.next.val){
                int x=curr.next.val;
                //遍历找到一个和节点值不相同的的节点
                while (curr.next!=null&&curr.next.val==x){
                    curr.next=curr.next.next;
                }
            }else {
                curr=curr.next;
            }
        }
        return dumpy.next;
    }
}
