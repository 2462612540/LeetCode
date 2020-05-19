/**
 * Copyright (C), 2018-2020
 * FileName: test20200430
 * Author:   xjl
 * Date:     2020/4/9 19:02
 * Description: 美团
 */
package CodingTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//删除链表中制定的元素
public class test20200430 {
    //定义为节点
    public class Node {
        public int value;
        public Node next;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public Node removeElements(Node head, int val) {
        Node p = head;
        Node pre = new Node(0);
        pre.next = head;
        Node curr = pre;
        while (p != null) {
            Node node = p.next;
            if (node != null) {
                if (p.value == val) {
                    curr.next = node;
                    curr = curr.next;
                }
            } else {
                break;
            }
            p = p.next;
        }
        return pre.next;
    }

    public Node removeElements3(Node head, int val) {
        Node result = null;
        Node last = null;   // 记录目前 result 中的最后一个结点
        Node cur = head;

        while (cur != null) {
            if (cur.value == val) {  //若遇到要移除的就跳过，继续判断下一个结点
                cur = cur.next;
                continue;
            }
            Node next = cur.next;
            if (result == null) {
                result = cur;
            } else {   //若result中不为空，则进行尾插
                last.next = cur;
            }
            cur.next = null;//让新链表中的最后一个结点为空，形成一个完整的链表
            last = cur;
            cur = next;
        }
        return result;
    }

    /**
     * 思路是将不需要移除的元素放入一个新的链表中
     *
     * @param head
     * @param val
     * @return
     */
    public Node removeElements2(Node head, int val) {
        Node result = new Node(0);
        Node curr = result;
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            if (head.value != val) {
                list.add(head.value);
            }
            head = head.next;
        }
        //创建一个链表并返回
        for (int i = 0; i < list.size(); i++) {
            curr.next = new Node(list.get(i));
            curr = curr.next;
        }
        return result.next;
    }

    @Test
    public void test2() {
        //制造节点
        Node s1 = new Node(10);
        Node s2 = new Node(10);
        Node s3 = new Node(7);
        Node s4 = new Node(8);
        Node s5 = new Node(9);
        Node s6 = new Node(10);
        Node s7 = new Node(10);
        Node s8 = new Node(10);
        Node s9 = new Node(10);
        Node s10 = null;
        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s5;
        s5.next = s6;
        s6.next = s7;
        s7.next = s8;
        s8.next = s9;
        s9.next = s10;

        //调用函数
        int target = 10;
        Node result = removeElements(s1, target);
        //展示结果
        while (result != null) {
            System.out.println(result.value);
            result = result.next;
        }
    }
}
