/**
 * Copyright (C), 2018-2020
 * FileName: 设计LRU的设计
 * Author:   xjl
 * Date:     2020/9/24 13:50
 * Description:
 */
package 牛客面试必会100题;

import java.util.HashMap;
import java.util.Map;

/**
 * 采用的是的双向链表的设计
 */
public class 设计LRU的设计 {
    //定义好一个节点
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    //表示的是元素的个数
    private int size;
    //初始化的容量
    private int capacity;
    //包括前后的两个指针
    private DLinkedNode head, tail;

    //数据结构的初始化的操作
    public 设计LRU的设计(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    //获取元素的操作
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    //添加元素操作 注意判断是否超过容量  一种是超过容量后扩容的 一种是超过后删除不怎么用的元素
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        } else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }
    //添加到头结点
    private void addToHead(DLinkedNode node) {
        //修改指针的指向
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    //删除节点的操作
    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    //移动到头部结点的
    private void moveToHead(DLinkedNode node) {
        //先删除这个节点后
        removeNode(node);
        //在将这个节点添加到头部
        addToHead(node);
    }
    //删除尾部为的节点
    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}
