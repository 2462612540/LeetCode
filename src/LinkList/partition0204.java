/**
 * Copreyright (C), 2018-2020
 * FileName: preartition0204
 * Author:   xjl
 * Date:     2020/8/13 10:14
 * Descripretion:
 */
package LinkList;

public class partition0204 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode preartition(ListNode head, int x) {
        if (head == null) return null;
        ListNode dumy = new ListNode(-1);
        dumy.next = head;
        //定义好两个指针
        ListNode pre = dumy;
        ListNode curr = head;
        //当第一数字
        if (head.val<x){
            pre=head;
            curr= head.next;
        }
        //遍历
        while (curr != null) {
            //判断是否小于
            if (curr.val < x) {
                ListNode future = curr.next;
                pre.next = curr.next;
                curr.next = dumy.next;
                dumy.next = pre;
                pre=future;
            } else {
                curr=pre.next;
                pre=pre.next;
            }
        }
        return dumy.next;
    }
}
