/**
 * Copyright (C), 2018-2020
 * FileName: LinkedListDemo
 * Author:   xjl
 * Date:     2020/5/7 15:27
 * Description: 测试
 */
package CodingTest;

import java.util.HashSet;
import java.util.Stack;

public class LinkedListDemo {
    LinkNode head;

    class LinkNode {
        public int val;
        public LinkNode next;

        public LinkNode(int val) {
            this.val = val;
        }
    }

    //list:1->2->6->3->4->5->6        val=6
    //list:1->2->3->4->5
    //链表中删除了所有数值等于6的节点
    public LinkNode removeElements(LinkNode head, int val) {
        //这个判断很巧妙，是用来删除头结点的
        //因为不排除头结点是要删除的节点的可能，所以需要从头结点这里判断
        //1、如果头结点不是要删除的节点，那么直接跳出循环
        //2、如果头结点是要删除的节点，直接head=head.next就删除了，
        //这个删除很简单，就是切断了头结点与下一个节点之间的指针，并且指定下一个节点为新的头结点
        while (head != null) {
            if (head.val != val) {
                break;
            }
            head = head.next;
        }
        //上面的循环跳出之后，说明新的头结点不可能是要删除的
        //因此可以不用再考虑头结点的删除问题
        LinkNode cur = head;
        LinkNode pre = head;
        while (cur != null) {
            //这个相等的判断在第一次循环时不会成立
            //所以在第一次循环结束时,pre=head,cur=head.next
            //pre和cur是相差了一个指针的节点，相当于cur节点的的前一个结点
            //使用pre作为指针节点是为了删除当前(如果值满足条件)节点的
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    //这种办法是通过栈来实现的，很直观：一次遍历链表，把不等于val的节点加入栈里面，然后依次取出站里面的元素，
    //直到最后一个元素就是链表的头节点，返回这个头节点
    //只是不明白这里的stack.peek().next = head是什么意思。
    public LinkNode removeElementsByStack(LinkNode head, int val) {
        Stack<LinkNode> stack = new Stack<LinkNode>();
        while (head != null) {
            if (head.val != val) {
                stack.push(head);
            }
            head = head.next;
        }
        while (!stack.isEmpty()) {
            stack.peek().next = head;
            head = stack.pop();
        }
        return head;
    }

    public LinkNode removeRepeat(LinkNode head) {
        if (head == null) {
            return null;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(head.val);
        LinkNode pre = head;
        LinkNode cur = head.next;
        while (cur != null) {
            if (set.contains(cur.val)) {
                pre.next = cur.next;
            } else {
                set.add(cur.val);
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public void display(LinkNode head) {
        System.out.print("list:");
        LinkNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public void insert(int val) {
        if (head == null) {
            head = new LinkNode(val);
        } else {
            LinkNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new LinkNode(val);
        }
    }

    public static void main(String[] args) {
        LinkedListDemo list = new LinkedListDemo();
        list.insert(1);
        list.insert(2);
        list.insert(6);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.display(list.head);
        LinkNode head = list.removeElements(list.head, 6);
        //LinkNode head = list.removeElementsByStack(list.head, 6);
        //LinkNode head = list.removeRepeat(list.head);
        list.display(head);
    }

}
