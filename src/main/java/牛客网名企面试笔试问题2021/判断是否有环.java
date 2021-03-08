package 牛客网名企面试笔试问题2021;

/**
 * @Classname 判断是否有环
 * @Description TODO
 * @Date 2021/3/8 12:31
 * @Created by xjl
 */
public class 判断是否有环 {
    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public boolean cycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head;
        ListNode low = head;
        while (fast != null && fast.next != null) {
            //快慢指针的效果
            fast = fast.next.next;
            low = low.next;
            if (low == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * @description TODO  判断环的入口在哪里
     * @param: head
     * @date: 2021/3/8 12:34
     * @return: 牛客网名企面试笔试问题2021.判断是否有环.ListNode
     * @author: xjl
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode low = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            low = low.next;
            if (fast == low) {
                //表示有环了 去判断环的入口
                fast = head;
                while (fast != low) {
                    fast = fast.next;
                    low = low.next;
                }
                return fast;
            }
        }
        //表示没有环
        return null;
    }
}
