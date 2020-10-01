package offer.jianzhi;

public class 从尾到头打印链表 {

    static int  count = 0;
    public static int[] reversePrint(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode node = reverseList(head);
        int [] res = new int[count+1];
        int index = 0;
        while(node != null){
            res[index] = node.val;
            index++;
            node = node.next;
        }
        return res;
    }


    //链表反转
    public static ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            count+=1;
        }
        return pre;
    }


    public static void main(String [] args){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;
        reversePrint(a);
    }
}
