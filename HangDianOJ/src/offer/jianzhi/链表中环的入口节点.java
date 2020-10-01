package offer.jianzhi;

/**
 * 题目描述
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * 思路：分三步进行、
 * 1、先判断链表是否有环（使用一快一慢指针）
 * 2、判断环的长度（使用指针遍历一遍到原点）
 * 3、找环的入口（两指针从头节点开始遍历，快指针先移动环的长度，接着两个指针同时遍历，指到遇到为止）
 * */
public class 链表中环的入口节点 {
    public static ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead==null){
            System.out.println(pHead);
            return pHead;
        }
        ListNode fast = pHead;
        ListNode nomal = pHead;
        boolean isRing = false;
        //判断是不是有环，这一块注意代码的顺序
        while (true){
            if (fast.next==null){
                System.out.println(fast.next);
                return fast.next;
            }
            fast = fast.next.next;
            nomal = nomal.next;
            if (fast == nomal){
                isRing = true;
                break;
            }
            if (fast == null){
                System.out.println(fast);
                return fast;
            }
        }
        //对有环，找出环的长度
        int ringLen  = 1;
        if (isRing==true){
            ListNode cur = nomal.next;
            while (cur!=nomal){
                ringLen = ringLen +1;
                cur = cur.next;
            }
        }
        //现在找出了环的长度，然后将fast指针向前移环的长度
        fast = pHead;
        nomal = pHead;
        for (int i = 0 ;i<ringLen;i++){
            fast = fast.next;
        }
        while (fast!=nomal){
            fast = fast.next;
            nomal = nomal.next;
        }
        return fast;
    }


    public static void main(String [] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;
//        node7.next = node8;
//        node8.next = node4;
        ListNode res = EntryNodeOfLoop(node1);
        System.out.println(res);
    }

}
