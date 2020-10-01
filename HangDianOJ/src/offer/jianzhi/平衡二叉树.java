package offer.jianzhi;

/**
 * 题目描述
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 递归求 每个节点求它的左右子树的深度，然后判断是不是满足平衡二叉树的定义
 *
 * 递归这个东西解决很多实际问题很有效！！！   就是不好理解
 * */
public class 平衡二叉树 {

    public static boolean IsBalanced_Solution(TreeNode root) {
        if (root == null){
            return true;
        }
        else {
            return Math.abs(getDepth(root.left,0)-getDepth(root.right,0))<=1?true:false;
        }
    }
    public static int getDepth(TreeNode node,int depth){
        if (node == null){
            return depth;
        }else {
            depth = depth + 1;
            return getDepth(node.left,depth)>getDepth(node.right,depth)?getDepth(node.left,depth):getDepth(node.right,depth);
        }

    }
    public static void main(String [] args){

        TreeNode root = new TreeNode(5);
        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(2);
        TreeNode l3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(6);
        TreeNode l4 = new TreeNode(7);
        TreeNode r2 = new TreeNode(8);
        root.left = l1;
        root.right = r4;
        l1.left = l2;
        l1.right = l3;
        l3.left = l4;
        //r4.right = r2;
        boolean res = IsBalanced_Solution(root);
        System.out.println(res);

    }

}
