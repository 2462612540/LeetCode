/**
 * Copyright (C), 2018-2020
 * FileName: DeleteNodeII
 * Author:   xjl
 * Date:     2020/8/28 9:20
 * Description: 删除链表的
 */
package leetcode练习题;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * created by Ethan-Walker on 2018/12/25
 */
public class DeleteNodeII {
    /**
     * 定义链表的节点
     */
    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 只给出待删除节点，要求在 O(1)时间内删除
     *
     * @param toDelete
     * @return
     */
    public void deleteSpecNode(ListNode toDelete) {
        if (toDelete.next == null) {
            // 不能删除尾结点
            throw new RuntimeException("尾结点无法删除");
        }
        toDelete.val = toDelete.next.val;
        toDelete.next = toDelete.next.next;
    }

    /**
     * 给出待删除节点和 头结点 顶一个新的节点来指向这个链表 这样就可以实现了
     * 要求在 O(1)时间内删除
     * <p>
     * 如果待删除节点是头结点，直接返回 head.next
     * 如果待删除节点不是尾结点，则可以在O(1)时间内删除
     * 是尾结点，必须从头结点遍历找到 倒数第二个节点,将其后继节点置为  null
     *
     * @param head
     * @param toDelete
     * @return
     */
    public ListNode deleteSpecNode(ListNode head, ListNode toDelete) {
        if (head == null) return null;
        // head = toDelete 的情况，特殊处理(包括两种情况，只有一个节点/多个节点)
        if (head == toDelete) return head.next;

        if (toDelete.next != null) {
            // 非尾结点
            toDelete.val = toDelete.next.val;
            toDelete.next = toDelete.next.next;
        } else {
            ListNode prev = head;
            while (prev != null && prev.next != toDelete) {
                prev = prev.next;
            }
            if (prev == null) {
                throw new RuntimeException("未找到待删除节点");
            }
            prev.next = null;
        }
        return head;
    }

    /**
     * 删除无序链表中所有值等于 val 的节点
     * 头结点可能会被删除
     * <p>
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteSpecNode(ListNode head, int val) {
        if (head == null) return null;
        ListNode prev = null, cur = head;  //prev 为上一个不等于 val 值的节点
        ListNode newHead = null;  // 用新的 newHead 变量，防止链表中所有元素都需要删除时，返回 head 出错
        while (cur != null) {
            // 判断 cur 是否等于 val
            if (cur.val == val) {
                // cur 需要删除
                if (newHead != null) {
                    prev.next = cur.next;
                }
            } else {
                // cur 保留
                if (newHead == null) {
                    newHead = cur;
                }
                prev = cur;
            }
            cur = cur.next;
        }
        return newHead;
    }

    /**
     * 删除无序链表的重复节点（重复节点只保留一个）
     * 要求空间复杂度 O(1)
     * 头结点不需要删除
     * <p>
     * 不能用哈希表，只能双重循环了
     * 时间复杂度:O(n^2)
     *
     * @param head
     * @return
     */
    public ListNode deleteDupNode0(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = head;
        ListNode first = head, second = head.next;
        while (first.next != null) {
            // 以 first 作为参照，删除 first 后面所有和 first.val 相同的节点
            prev = first;
            second = first.next;
            //采用了二次的链表的遍历
            while (second != null) {
                if (second.val == first.val) {
                    // 需要删除
                    prev.next = second.next;
                } else {
                    prev = second;
                }
                second = second.next;
            }
            first = first.next;
        }
        return head;
    }

    /**
     * 删除无序链表中的重复节点（重复节点只保留第一个）
     * 头结点一定会保留（即便是重复节点，也需要保留一个）
     * 如何判断当前节点是否是重复出现的呢？hash 表
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     *
     * @param head
     * @return
     */
    public ListNode deleteDupNode1(ListNode head) {
        if (head == null || head.next == null) return head;
        //储存每一个结果的值和出现的次数
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(head.val);
        ListNode prev = head, cur = head.next; // prev 指向当前构造的链表的最后节点
        while (cur != null) {
            if (hashSet.contains(cur.val)) {
                // 当前节点要删除
                prev.next = cur.next;
            } else {
                hashSet.add(cur.val);
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * 删除无序链表中的所有重复节点（重复节点不保留）
     * 头结点可能会被删除（如果其是重复节点的话）
     * <p>
     * 要求空间复杂度: O(1)
     * <p>
     * 时间复杂度: O(n^2)
     *
     * @param head
     * @return
     */
    public ListNode deleteDupNode2(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode first = head, second = head.next;
        ListNode newHead = null;
        ListNode prev = null;

        // 为了能保证验证每个节点是否是重复节点，不能破坏原链表的结构！！！

        while (first != null) {
            // 判断 first 是否是重复节点
            // 注意这里second 必须从头结点head开始遍历，而不是从 first /newHead 之后遍历
            second = head;
            while (second != null) {
                if (second != first && second.val == first.val) {
                    break;
                }
                second = second.next;
            }
            if (second == null) {
                // first 是非重复节点
                if (newHead != null) {
                    // 已经有头结点了
                    prev.next = new ListNode(first.val);
                    prev = prev.next;
                } else {
                    // 新的头结点
                    newHead = new ListNode(first.val);
                    prev = newHead;
                }
            }
            first = first.next;
        }
        return newHead;
    }

    /**
     * 删除无序链表中的所有重复节点（重复节点不保留）
     * 头结点可能会被删除（如果其是重复节点的话）
     * 由于遍历到一个节点，无法判断该节点是否需要删除，所以需要先遍历一遍 hashMap 统计每个数值对应的节点个数
     * 重新遍历一次，当某个数值对应的节点个数大于1 表示当前节点需要删除
     * <p>
     * 时间复杂度:O(n) 2n
     * 空间复杂度:O(n)
     *
     * @param head
     * @return
     */
    public ListNode deleteDupNode3(ListNode head) {
        if (head == null || head.next == null) return head;
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode cur = head;
        while (cur != null) {
//          map.put(cur.val,map.getOrDefault(cur.val,0)+1);// 累计+1
            map.merge(cur.val, 1, Integer::sum); //更简洁的写法，取出 map 中对应于 cur.val的值count，没有设为0; 再和 1相加存入
            cur = cur.next;
        }

        ListNode prev = null;
        cur = head.next;
        while (cur != null) {
            if (map.get(cur.val) > 1) {
                if (prev != null) {
                    // 当前节点需要删除
                    prev.next = cur.next;
                }
            } else {
                // 当前节点保留
                if (prev == null) {
                    head = cur;
                }
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * 删除排序链表中的重复节点（重复节点只保留一个）
     * 头结点可以直接保留
     * <p>
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     *
     * @param head
     * @return
     */
    public ListNode deleteSortedDupNode(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = head, cur = head.next;

        while (cur != null) {
            // 判断 cur 是否是重复节点
            if (cur.val == prev.val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        // 这里不需要再手动断开 prev ，因为prev.next = cur.next 直接将重复节点 cur 删除了
        return head;
    }

    /**
     * 删除排序链表中的所有重复节点（重复节点不保留）
     * 头结点可能需要删除
     *
     * @param head
     * @return
     */
    public ListNode deleteSortedDupNode2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = null, newHead = null;
        ListNode cur = head, follow = null;

        while (cur != null) {
            // 判断 cur 是否是重复节点
            follow = cur.next;
            while (follow != null && follow.val == cur.val) {
                follow = follow.next;
            }
            // follow 要么指向第一个不等于 cur 的节点, 要么等于 null

            if (cur.next == follow) {
                // 说明 cur 不是重复节点(无论 follow是否为 null)
                if (newHead == null) {
                    newHead = cur;
                } else {
                    prev.next = cur;
                }
                prev = cur;
            }
            cur = follow; // 继续判断下一个节点是否是重复节点
        }
        // 这里涉及到的可能是需要一次删除多个重复节点，没有进行删除跳过（prev.next= follow）
        // 而是找到一个非重复节点才链接到 prev 后 prev.next= cur
        // 这就埋下一个隐患，当结束后 prev指向最后一个非重复节点
        // 如果prev 原先链接的后面的节点是重复节点时，并没有断开与prev的连接. 所以最后这里必须手动断开
        if (prev != null) {  // 示例 1 2 2
            prev.next = null;
        }
        return newHead;
    }

    // 另一种写法，上面的写法其实更高效一点（当有大量重复节点时）
    public ListNode deleteSortedDupNode2Another(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = null, newHead = null;
        ListNode cur = head, follow = null;

        while (cur != null) {
            // 判断 cur 是否是重复节点
            follow = cur.next;
            while (follow != null && follow.val == cur.val) {
                follow = follow.next;
            }
            // follow 要么指向第一个不等于 cur 的节点, 要么等于 null

            if (cur.next == follow) {
                // 说明 cur 不是重复节点(无论 follow是否为 null)
                if (newHead == null) {
                    newHead = cur;
                } else {
                    prev.next = cur;
                }
                prev = cur;
            } else {
                // cur 是重复节点
                if (prev != null) {
                    prev.next = follow; // 删除中间所有的重复节点，链接到下一个比较的节点
                }
            }
            cur = follow; // 继续判断下一个节点是否是重复节点
        }
        return newHead;
    }

    @Test
    public void test() {
        ListNode a0 = new ListNode(0);
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(0);
        ListNode a3 = new ListNode(0);
        ListNode a4 = new ListNode(3);
        ListNode a5 = new ListNode(0);
        ListNode a6 = new ListNode(0);
        ListNode a7 = new ListNode(5);

        a0.next = a1;
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a7;

        ListNode ans = deletenodevalue2(a0, 5);
        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }

    @Test
    public void test1() {
        Map<String, String> map = new HashMap<>();
        map.put("C", "C");
        map.put("A", "A");
        map.put("B", "B");
        /**
         * hashmap是输出的有序的 因为是的按照key的大小的实现的
         */
        for (String s : map.keySet()) {
            System.out.println(s+"--"+map.get(s)+"--");
        }


    }

    /**
     * 删除的指定的元素 利用一个指针来实现
     *
     * @param head
     * @return
     */
    public ListNode deletenodevalue(ListNode head, int targe) {
        ListNode dumy = new ListNode(0);
        dumy.next = head;
        ListNode curr = dumy;

        while (curr.next != null) {
            if (curr.next.val == targe) {
                curr.next = curr.next.next;
                continue;
            }
            curr = curr.next;
        }

        return dumy.next;

    }

    /**
     * 删除的指定的元素 利用两个指针来实现
     *
     * @param head
     * @return
     */
    public ListNode deletenodevalue2(ListNode head, int targe) {
        //初始化一个虚拟节点
        ListNode dummy = new ListNode(0);
        //让虚拟节点指向头结点
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        while (cur != null) {
            if (cur.val == targe) {
                cur = cur.next;
                pre.next = cur;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        //最后返回虚拟节点的下一个结点即可
        return dummy.next;
    }

    public static void print(ListNode node) {
        if (node == null) {
            System.out.println("链表为空");
            return;
        }
        while (node != null) {
            System.out.print(node.val + ", ");
            node = node.next;
        }
        System.out.println();
    }

}


