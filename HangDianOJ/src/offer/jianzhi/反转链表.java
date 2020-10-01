package offer.jianzhi;

//class ListNode {
//    int val;
//    ListNode next = null;
//
//    ListNode(int val) {
//        this.val = val;
//    }
//}
/**
 * 题目描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 * 面试老是考这样的题，好好思考一下！！！
 * */
public class 反转链表 {
    public static ListNode ReverseList(ListNode head) {
        //判断head是不是为null
        if (head == null||head.next == null){
            return  head;
        }else if (head.next.next == null){
            ListNode pre = head;
            ListNode cur = pre.next;
            cur.next=head;
            pre.next = null;
            return cur;
        }else{
            ListNode pre = head;
            ListNode cur = pre.next;
            ListNode next = pre.next.next;
            pre.next = null;
            //开始反转
            while (next!=null){
                cur.next = pre;
                pre = cur;
                cur = next;
                next = next.next;
            }
            //注意这条语句的重要性！！！
            cur.next = pre;
            return cur;
        }
    }

    public static void main(String [] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNode res = ReverseList(listNode1);
        while (res!=null){
            System.out.println(res.val);
            res = res.next;
        }

    }
}
