/**
 * Copyright (C), 2018-2020
 * FileName: Node
 * Author:   xjl
 * Date:     2020/3/6 16:01
 * Description: 链表中的节点
 */
package JAVA_sort_arithmetic.src.Link;

public class Node<T> {
    //成员变量
    public T item;//表示的是存储的元素
    public Node next; //表示的是下一个节点

    //构造函数

    public Node(T item, Node next) {
        this.item = item;
        this.next = next;
    }

    //成员函数
    public static void main(String[] args) {
        //构造节点
        Node<Integer> f1 = new Node<>(11, null);
        Node<Integer> f2 = new Node<>(12, null);
        Node<Integer> f3 = new Node<>(13, null);
        Node<Integer> f4 = new Node<>(14, null);
        Node<Integer> f5 = new Node<>(15, null);
        //生成链表
        f1.next = f2;
        f2.next = f3;
        f3.next = f4;
        f4.next = f5;
    }
}
