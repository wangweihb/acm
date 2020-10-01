package offer.leetcode;

public class _24两两交换链表中的节点 {

    // https://leetcode-cn.com/problems/swap-nodes-in-pairs/solution/bi-jiao-zhi-jie-gao-xiao-de-zuo-fa-han-tu-jie-by-w/
    //画图理解
    public static ListNode reverseNode(ListNode node){
        ListNode pHead = new ListNode(-1);
        ListNode pre = pHead;
        pre.next = node;
        if(node == null) return node;
        ListNode next = node.next;
        while(next != null) {
            pre.next = next;
            node.next = next.next;
            next.next = node;
            //交换指针
            pre = node;
            node = node.next;
            if (node!=null) {
                next = node.next;
            }else{
                next = null;
            }
        }
        return pHead.next;
    }


    /**
     * 递归解法
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
         if(head == null || head.next == null) {
             return head;
         }
         ListNode next = head.next;
         head.next = swapPairs(next.next);
         next.next = head;
         return next;
    }


    public static void main(String [] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;


        ListNode cc = reverseNode(node1);
        System.out.println(cc.val);
    }

}
