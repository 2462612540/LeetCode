/**
 * Copyright (C), 2018-2020
 * FileName: copyRandomList35
 * Author:   xjl
 * Date:     2020/8/12 16:30
 * Description: 剑指 Offer 35. 复杂链表的复制
 */
package leetcode;

import java.util.HashMap;

public class copyRandomList35 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        //创建HashMap集合
        HashMap<Node,Node> map = new HashMap<>();
        Node cur=head;
        //复制结点值 存放在map中
        while(cur!=null){
            //存储put:<key,value1>
            map.put(cur,new Node(cur.val)); //顺序遍历，存储老结点和新结点(先存储新创建的结点值)
            cur=cur.next;
        }
        //遍历原来的结果 获取指针
        cur = head;
        while(cur!=null){
            //得到get:<key>.value2,3
            map.get(cur).next = map.get(cur.next); //新结点next指向同旧结点的next指向
            map.get(cur).random = map.get(cur.random); //新结点random指向同旧结点的random指向
            cur = cur.next;
        }
        //返回复制的链表
        return map.get(head);
    }
}
