package offer.jianzhi;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Stack;

/**
 * 题目描述
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 *
 *         while (!stack.empty()){
 //返会栈顶元素，但是不移除它
 TreeNode top = stack.peek();
 if (top.left!=null){
 stack.push(top.left);
 }else {
 TreeNode pop = stack.pop();
 pop.left = null;
 count = count + 1;
 if (count == k){
 return pop;
 }
 if (pop.right!=null){
 stack.push(pop.right);
 }else {
 continue;
 }
 }
 }
 * //使用栈在遍历二叉搜索树
 * */
public class 二叉搜索树的第K个节点 {
    //先使用栈把二叉树遍历出来，然后再打印第K个数、
    public static Stack<TreeNode> stack = new Stack<>();
    static int k = 0;
    public static TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot == null || k == 0){
            return null;
        }
        二叉搜索树的第K个节点.k = k;
        return KthNodeCore(pRoot);
    }
    public static TreeNode KthNodeCore(TreeNode root){
        TreeNode target = null;
        if (root.left!=null){
            target = KthNodeCore(root.left);
        }
        if (target == null){
            if (k == 1){
                target = root;
            }
            k--;
        }
        if (target == null && root.right!=null){
            target = KthNodeCore(root.right);
        }
        return  target;
    }
    public static  void main(String [] args){
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(8);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        TreeNode res = KthNode(node1,6);
        System.out.println(res);
    }
}
