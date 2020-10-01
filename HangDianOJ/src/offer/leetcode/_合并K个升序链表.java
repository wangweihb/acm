package offer.leetcode;

public class _合并K个升序链表 {
//    https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/he-bing-kge-pai-xu-lian-biao-by-leetcode-solutio-2/

    public static ListNode mergeKLists(ListNode[] lists){
        if(lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];
        if(lists.length == 2) {
            return mergeTwoLists(lists[0],lists[1]);
        }
        int mid = lists.length/2;
        ListNode[] l1 = new ListNode[mid];
        for(int i = 0; i < mid; i++){
            l1[i] = lists[i];
        }
        ListNode[] l2 = new ListNode[lists.length-mid];
        for(int i = mid,j=0; i < lists.length; i++,j++){
            l2[j] = lists[i];
        }
        return mergeTwoLists(mergeKLists(l1),mergeKLists(l2));
    }

    //使用递归的方式merge两个链表！！！
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = null;
        if (l1.val <= l2.val){
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;
    }


    /**
     * 很经典的写法，注意这样子的写法
     * @param l1 l1
     * @param l2 l2
     * @return head
     */
//    public static ListNode mergeListNode(ListNode l1, ListNode l2){
//        if(l1 == null) return l2;
//        if(l2 == null) return l1;
//
//        ListNode head = null;
//        if(l1.val < l2.val){
//            head = l1;
//            head.next = mergeListNode(l1.next, l2);
//        }else{
//            head = l2;
//            head.next = mergeListNode(l1, l2.next);
//        }
//        return head;
//    }

    public static void main(String [] arg){
//        mergeKLists();
    }


}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
