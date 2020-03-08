/**
 * Copyright (C), 2018-2020
 * FileName: LinkList
 * Author:   xjl
 * Date:     2020/3/6 16:09
 * Description: 单向链表
 */
package JAVA_sort_arithmetic.src.Link;

public class LinkList<T> {
    private Node head; //表示的头节点
    private int N;     //表示链表的大小

    //node属于的是内部类
    private class Node<T> {
        //成员变量
        public T item;//表示的是存储的元素
        public Node next; //表示的是下一个节点

        //构造函数
        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    //属于构造函数
    public LinkList() {
        //初始化头结点
        this.head = new Node(null, null);
        //初始化元素的个数
        this.N = 0;
    }

    public void clear() {
        head.next = null;
        this.N = 0;
    }

    public int length() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public T get(int i) {
        //通过循环头结点一次去找到对应的元素
        Node n = head.next;
        for (int index = 0; index < i; index++) {
            n = n.next;
        }
        return (T) n.item;
    }

    public void insert(T t) {
        //找到当前的最后的一个节点
        Node n = head;
        while (n.next != null) {
            n = n.next;
        }
        //创建新的节点 保存元素
        Node newnode = new Node<>(t, null);
        //让当前的最后的一个节点指向新的节点
        n.next = newnode;
        //元素的个数加1
        N++;
    }

    public void insert(int i, T t) {

    }

    public T remove(int i) {
        return null;
    }

    public int indexOf(T t) {
        return -1;
    }
}

