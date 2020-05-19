/**
 * Copyright (C), 2018-2020
 * FileName: test20200430
 * Author:   xjl
 * Date:     2020/4/9 19:02
 * Description: 美团
 */
package CodingTest;

import org.junit.Test;

//删除链表中制定的元素
public class test20200431 {
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

    public Node ExchangeOddEvenNode(Node input) {
       Node curr=input;
       while (curr.next!=null){

       }

        return null;
    }

    @Test
    public void test2() {
        //制造节点
        Node s1 = new Node(1);
        Node s2 = new Node(2);
        Node s3 = new Node(3);
        Node s4 = new Node(4);
        Node s5 = new Node(5);
        Node s6 = new Node(6);
        Node s7 = new Node(7);
        Node s8 = new Node(8);
        Node s9 = new Node(9);

        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s5;
        s5.next = s6;
        s6.next = s7;
        s7.next = s8;
        s8.next = s9;


        //调用函数

        Node result = ExchangeOddEvenNode(s1);
        //展示结果
        while (result != null) {
            System.out.println(result.value);
            result = result.next;
        }
    }
}
