package offer.jianzhi;

/**
 * 题目描述
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * */
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

/**
 * 这个是找的别人的代码  ，今天萎靡了一天    就调试一个代码。。。  2018年11月24
 *
 * * */
public class 二叉树的下一个节点 {
    public static TreeLinkNode  GetNext(TreeLinkNode node)
    {
        if(node==null) return null;
        if(node.right!=null){    //如果有右子树，则找右子树的最左节点
            node = node.right;
            while(node.left!=null) node = node.left;
            return node;
        }
        while(node.next!=null){ //没右子树，则找第一个当前节点是父节点左孩子的节点
            if(node.next.left==node) return node.next;
            node = node.next;
        }
        return null;   //退到了根节点仍没找到，则返回null
    }

    public static TreeLinkNode my(TreeLinkNode root){
        if (root!=null){
            TreeLinkNode left = my(root.left);
            if (left!=null){
                left.next  = root;
            }
            root.next = root.right;
            my(root.right);
        }
        return root;
    }

    public static void main(String [] args){
        TreeLinkNode t1  = new TreeLinkNode(10);
        TreeLinkNode t2  = new TreeLinkNode(8);
        TreeLinkNode t3  = new TreeLinkNode(12);
        TreeLinkNode t4  = new TreeLinkNode(5);
        //TreeLinkNode t1  = new TreeLinkNode(10);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        TreeLinkNode res = my(t1);
        System.out.println(res);
    }
}
