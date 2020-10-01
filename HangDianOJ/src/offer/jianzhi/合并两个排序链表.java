package offer.jianzhi;


/**
 * 题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调递增规则。
 * 使用了三个指针，以第一行链表为标准，将第二个链表插入到第一个链表里面去！！！
 * //看了别人写的代码，自己写的代码好麻烦！！！
 * 一次性AC
 * */

public class 合并两个排序链表 {
/*
    算法的思路就是剑指Offer上面的解题思路
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next = Merge(list1.next, list2);
            return list1;
        }else{
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }*/

    public static ListNode Merge(ListNode list1,ListNode list2) {
        if (list1== null || list2 == null){
            return list1==null?list2:list1;
        }else if (list1 == null && list2==null){
            return list1;
        }else {
            ListNode l1_f = list1;
            ListNode l2_cur = list2;
            ListNode l2_next = list2.next;
            while (l2_next!=null){
                if (l1_f.next!=null){
                    //1 3之间插入2
                    if (l1_f.val<=l2_cur.val && l1_f.next.val>=l2_cur.val){
                        l2_cur.next = l1_f.next;
                        l1_f.next = l2_cur;
                        //指针后移
                        l1_f = l1_f.next.next;
                        l2_cur = l2_next;
                        l2_next = l2_next.next;
                    }
                    //表示在2、3前面插入1
                    else if (l1_f.val>=l2_cur.val){
                        l2_cur.next= l1_f;
                        l2_cur = l2_next;
                        l2_next = l2_next.next;
                    }
                }
                //说明第二条链后面的数都比第一条链上的除了最后一个数都大
                else {
                    //第一条链的最后一个数是两条链中最大的，因此第二条链会往第一条链中增加数据
                    if (l1_f.val>=l2_cur.val){
                        l2_cur.next= l1_f;
                        l2_cur = l2_next;
                        l2_next = l2_next.next;
                    }
                    return l1_f;
                }
            }
            if (l2_cur.val>=l1_f.val){
                if (l1_f.next!=null){
                    l2_cur.next=l1_f.next;
                }
                l1_f.next=l2_cur;
            }
            return list1;
        }
    }
    public static void main(String [] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(5);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        //listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode res = Merge(listNode1,listNode4);
        while (res.next!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
