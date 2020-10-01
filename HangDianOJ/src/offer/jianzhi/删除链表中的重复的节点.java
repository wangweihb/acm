package offer.jianzhi;


/**
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * 思路混乱，三个指针。。。变量有点多，指针一多，判断条件就多。第二遍研究一下简单的方法。
 * */
public class 删除链表中的重复的节点 {
    public static  ListNode deleteDuplication(ListNode pHead)
    {
        //输入为空进行验证
        if (pHead == null||pHead.next == null){
            return pHead;
        }
        //三个指针
        ListNode cur = null;
        ListNode is_next = pHead;
        ListNode is_cur = pHead;
        ListNode res = null;
        while (is_next != null){
            if (is_next.next!=null){
                is_next = is_next.next;
                if ((is_next.val != is_cur.val)){
                    if (cur==null){
                        cur = is_cur;
                        res = cur;
                    }else {
                        cur.next = is_cur;
                        cur = cur.next;
                    }
                    is_cur = is_next;
                    //is_next = is_next.next;
                }else {
                    while (is_next.val==is_cur.val){
                        if (is_next.next!=null){
                            is_next = is_next.next;
                        }
                        else {
                            //有两种可能
                            //第一种，后面接着几个相同的数，需要过滤掉
                            System.out.println(is_next);
                            if (cur!=null) {
                                cur.next = null;
                                return res;
                            }else {
                                return cur;
                            }
                        }
                    }
                    is_cur = is_next;
                }
            }
            else {
                if (cur == null){
                    cur = is_cur;
                    res = cur;
                }else
                    if (cur.next.val != cur.val)
                        cur.next = is_cur;
                break;
            }
        }
        return res;
    }

    public static void main(String [] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(6);
        ListNode node8 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        //node7.next = node8;
        ListNode res = deleteDuplication(null);
        System.out.println(res);
    }
}
