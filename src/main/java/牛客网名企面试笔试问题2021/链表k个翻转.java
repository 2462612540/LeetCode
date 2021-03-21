package 牛客网名企面试笔试问题2021;

/**
 * @Classname 链表k个翻转
 * @Description TODO
 * @Date 2021/2/25 22:20
 * @Created by xjl
 */
public class 链表k个翻转 {

    public class ListNode{
        int val;
        ListNode next;
        public ListNode (int val){
            this.val=val;
        }
    }
    /**
     * @description TODO  将给出的链表中的节点每 k\ k k 个一组翻转，返回翻转后的链表  如果链表中的节点数不是 k\ k k 的倍数，将最后剩下的节点保持原样  你不能更改节点中的值，只能更改节点本身
     *
      * @param: head
     * @param: k
     * @date: 2021/2/25 22:24
     * @return: 牛客网名气面试笔试问题2021.链表k个翻转.ListNode
     * @author: xjl
    */
    public ListNode reverseKGroup (ListNode head, int k) {
        //边界情况的
        if (head==null||head.next==null||k<=1)return head;
        //创建新的及诶单
        ListNode dumpy=new ListNode(-1);
        dumpy.next=head;
        //前继节点
        ListNode prve=dumpy;
        while (prve!=null){
            //组内的开始节点和结束节点
            ListNode start=prve.next;
            ListNode end=prve.next;
            //定位本组的结束对的节点
            for (int i=0;i<k-1&&end!=null;i++){
                end=end.next;
            }
            //如果是的不足一組
            if (end==null){break;}
            //缓存本组的后的节点
            ListNode follow=end.next;
            //切断后面的分组
            end.next=null;
            //翻转完成
            prve.next=reverse(start);
            //接起来
            start.next=follow;
            //并设置的将pre的指针向后移动
            prve=start;
        }
        return dumpy.next;
    }

    /**
     * @description TODO  链表的翻转
      * @param: head
     * @date: 2021/2/25 22:42
     * @return: 牛客网名气面试笔试问题2021.链表k个翻转.ListNode
     * @author: xjl
    */
    private ListNode reverse(ListNode head) {
        ListNode prve=null;
        ListNode curr=head;

        while (curr!=null){
            ListNode furture=curr.next;
            curr.next=prve;
            prve=curr;
            curr=furture;
        }
        return prve;
    }


    private ListNode reverse2(ListNode head) {
        //连起来
        ListNode dumpy=new ListNode(-1);
        dumpy.next=head;
        //设置两个指针
        ListNode prve=dumpy;
        ListNode curr=head;

        while (curr!=null&&curr.next!=null){
            ListNode furture=curr.next;
            curr.next=furture.next;
            furture.next=dumpy.next;
            prve.next=furture;
        }
        return dumpy.next;
    }
}
