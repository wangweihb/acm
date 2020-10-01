package offer.jianzhi;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
public class 二叉搜索树与双向链表 {
    //方法一
    //中序遍历二叉树，然后将节点保存到链表中，最后遍历链表构建
    //记录头结点还有 尾节点
    //left 指向小的，right指向大的
//    static List<Node> lists = new ArrayList<>();
//    public static Node treeToDoublyList(Node root) {
//        obtainNode(root);
//        Node pre = null;
//        Node next = null;
//        Node node = null;
//        for(int i = 0 ; i < lists.size(); i++){
//
//            node = lists.get(i);
//            if(i < lists.size() - 1){
//                next = lists.get(i+1);
//                node.right = next;
//            }
//
//            node.left = pre;
//            pre = node;
//        }
//
//        Node head = lists.get(0);
//        Node tail = lists.get(lists.size()-1);
//        head.left = tail;
//        tail.right = head;
//        return head;
//
//    }
//
//    public static void obtainNode(Node node){
//        if(node != null){
//            obtainNode(node.left);
//            lists.add(node);
//            obtainNode(node.right);
//        }
//    }

    //方法二:也是中序遍历，找到当前节点和当前节点的前一个节点，构建链表。
    // 最后构建第一个节点和最后一个节点的链接，简单明了。大神牛皮
    static Node pre, head;
    public static Node treeToDoublyList(Node root) {
        if(root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    static void  dfs(Node cur) {
        if(cur == null) return;
        dfs(cur.left);
        if(pre != null) pre.right = cur;
        else head = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }


    public static void  main(String [] args){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);


        node4.left = node2;
        node4.right = node5;

        node2.left = node1;
        node2.right = node3;
        node4.right = node5;
        treeToDoublyList(node4);


    }

}
