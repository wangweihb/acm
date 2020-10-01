package offer.jianzhi;

import java.util.Stack;

/**
 * 想好了【思路
 * 手撕一个代码  要准确   写的时候仔细一点   避免后面又开始debug。
 *
 *
 * 存在的问题有两个：
 * 一、没有对空指针进行验证；
 * 二、遍历链表的时候  指针没有后移；
 *
 * 写程序的思路出来了，但是漏洞百出，应该怎么处理？！
 * */
public class 两个链表的第一个公共节点 {


    //双指针
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while(nodeA!=null){
            lenA++;
            nodeA = nodeA.next;
        }
        while(nodeB!=null){
            lenB++;
            nodeB = nodeB.next;
        }
        nodeA = headA;
        nodeB = headB;

        if(lenA>lenB){
            for(int i = 0 ; i < lenA-lenB;i++){
                nodeA = nodeA.next;
            }
        }else{
            for(int i = 0 ; i < lenB-lenA;i++){
                nodeB = nodeB.next;
            }
        }

        while(nodeA!=null && nodeB!=null && nodeA != nodeB){
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }

        return nodeA;
    }


    /**
     * 你走过我的路，我走过你的路，最后我们相遇了。。。
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode h1 = headA, h2 = headB;
        while (h1 != h2) {

            h1 = h1 == null ? headB : h1.next;
            h2 = h2 == null ? headA : h2.next;
        }

        return h1;
    }

    public static void main(String [] args){

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(6);
        ListNode l4 = new ListNode(7);
        ListNode r1 = new ListNode(4);
        ListNode r2 = new ListNode(5);
        ListNode r3 = new ListNode(6);
        ListNode r4 = new ListNode(7);

        ListNode l11 = new ListNode(1);
        System.out.println(l1.equals(l11));

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        r1.next = r2;
        r2.next = r3;
        r3.next = r4;
        System.out.println(getIntersectionNode2(l1,r1).val);
    }

}
