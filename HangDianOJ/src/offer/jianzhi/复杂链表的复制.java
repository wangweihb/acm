package offer.jianzhi;

/**
 * 题目描述
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * 代码应该没有问题啊啊！？
 * 代码未通过！
 * */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class 复杂链表的复制 {
    public static  RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead==null){
            return null;
        }else {
            RandomListNode listNode = pHead;
            RandomListNode nHead = new RandomListNode(listNode.label);
            RandomListNode nlistNode = nHead;

            while (listNode.next!=null){
                listNode = listNode.next;
                nlistNode.next = new RandomListNode(listNode.label);
                nlistNode= nlistNode.next;
            }
            //开始遍历，找random指针
            listNode = pHead;
            nlistNode = nHead;
            RandomListNode curListNode = nHead;
            while (listNode.next!=null){
                while (nlistNode.next!=null){
                    if (listNode.random.label==nlistNode.label){
                        curListNode.random=nlistNode;
                    }
                    //妈的   又忘记指针往前移动了
                    nlistNode = nlistNode.next;
                }
                if (nlistNode.next==null){
                    if (listNode.random.label==nlistNode.label){
                        curListNode.random=nlistNode;
                    }
                }
                listNode = listNode.next;
                curListNode = curListNode.next;
                nlistNode = nHead;
            }
            return nHead;
        }
    }

    public static void main(String [] args){
        RandomListNode r1 = new RandomListNode(1);
        RandomListNode r2 = new RandomListNode(2);
        RandomListNode r3 = new RandomListNode(3);
        RandomListNode r4 = new RandomListNode(4);
        r1.next = r2;
        r2.next = r3;
        r3.next = r4;
        r1.random = r3;
        r2.random = r3;
        r3.random = r4;
        RandomListNode res =  Clone(r1);
        System.out.println(res);
    }
}
