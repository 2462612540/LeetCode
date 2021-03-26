package 计算机程序算法分类.链表问题;

/**
 * @Classname 设计链表
 * @Description TODO
 * @Date 2021/3/26 19:51
 * @Created by xjl
 */
public class MyLinkedList {
    /**
     * @description TODO 使用的是的单链表的结构来实现这样的以一个原理的
     * @param: null
     * @date: 2021/3/26 20:04
     * @return:
     * @author: xjl
     */
    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    int size;
    ListNode head;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        // if index is invalid
        if (index < 0 || index >= size) return -1;
        ListNode curr = head;
        // index steps needed
        for (int i = 0; i < index + 1; ++i) {
            curr = curr.next;
        }
        return curr.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index < 0) index = 0;
        ++size;
        ListNode pred = head;
        for(int i = 0; i < index; ++i) pred = pred.next;
        ListNode toAdd = new ListNode(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        // if the index is invalid, do nothing
        if (index < 0 || index >= size) return;
        size--;
        // find predecessor of the node to be deleted
        ListNode pred = head;
        for(int i = 0; i < index; ++i) pred = pred.next;
        // delete pred.next
        pred.next = pred.next.next;
    }
}
