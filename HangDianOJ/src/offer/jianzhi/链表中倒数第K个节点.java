package offer.jianzhi;

/**
 *
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 *
 * 提交了三遍才AC
 * 代码逻辑不是很好，很杂，看一下别人怎么写的代码！！！
 *
 * 代码的鲁棒性
 * FindKthToTail2()这个方法里面的代码清洗明了，简洁。有可读性！！！好好研究一下
 * */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class 链表中倒数第K个节点 {

    public static ListNode FindKthToTail2(ListNode head,int k) {
        ListNode pre=null,p=null;
        //两个指针都指向头结点
        p=head;
        pre=head;
        //记录k值
        int a=k;
        //记录节点的个数
        int count=0;
        //p指针先跑，并且记录节点数，当p指针跑了k-1个节点后，pre指针开始跑，
        //当p指针跑到最后时，pre所指指针就是倒数第k个节点
        while(p!=null){
            p=p.next;
            count++;
            if(k<1){
                pre=pre.next;
            }
            k--;
        }
        //如果节点个数小于所求的倒数第k个节点，则返回空
        if(count<a) return null;
        return pre;

    }

    public static ListNode FindKthToTail(ListNode head,int k) {
        //判断k是不是太大，导致越界。
        //判断k是不是为0

        if (k==0||head == null){
            return null;
        }
        boolean flag = false;
        int flag1 = 1;
        int flag2 = 0;
        ListNode currentNode = head;
        ListNode resultNode = null;
        while(currentNode.next!=null) {
            currentNode = currentNode.next;
            if (k-1 == 0){
                resultNode = currentNode;
                flag = true;
                flag2++;
            }else {
                if (flag1-flag2 == k-1) {
                    if (resultNode == null){
                        resultNode = head;
                    }else {
                        resultNode = resultNode.next;
                    }
                    flag2++;
                    flag = true;
                }
            }

            flag1++;
        }
        if (flag==true){
            return resultNode;
        }else {
            return null;
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
        System.out.println(FindKthToTail2(listNode1,1).val);
    }
}
