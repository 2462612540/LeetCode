/**
 * Copyright (C), 2018-2020
 * FileName: getDecimalValue1290
 * Author:   xjl
 * Date:     2020/8/13 15:33
 * Description:
 */
package LinkList;

public class getDecimalValue1290 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int getDecimalValue(ListNode head) {
        if (head==null){
            return 0;
        }
        int sum = 0;
        while (head != null) {
            sum = sum * 2 + head.val;
            head=head.next;
        }
        return sum;
    }
}
