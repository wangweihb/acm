package offer.jianzhi;
/**
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * */
public class 二叉树的镜像 {
    public static void Mirror(TreeNode root) {
        //这样的情况,为空如何处理
        if (root == null){
            System.out.println("输入为空。。。");
        }
        TreeNode my = switchNode(root);
        System.out.println(my.val);
    }
    public static TreeNode switchNode(TreeNode treeNode){
        if (treeNode == null){
            return treeNode;
        }
        TreeNode left = treeNode.left;
        TreeNode right = treeNode.right;
        treeNode.right = left;
        treeNode.left = right;
        if (treeNode.right!=null){
            switchNode(treeNode.right);
        }
        //这儿不能使用else if，使用else if当上一个if为true时候，就不会执行了！！！注意
        if (treeNode.left!=null){
            switchNode(treeNode.left);
        }
        return treeNode;
    }

    public static void main(String [] args){
        TreeNode treeNode1_1 = new TreeNode(8);
        TreeNode treeNode1_2 = new TreeNode(6);
        TreeNode treeNode1_3 = new TreeNode(10);
        TreeNode treeNode1_4 = new TreeNode(5);
        TreeNode treeNode1_5 = new TreeNode(7);
        TreeNode treeNode1_6 = new TreeNode(9);
        TreeNode treeNode1_7 = new TreeNode(11);
        treeNode1_1.left = treeNode1_2;
        treeNode1_1.right = treeNode1_3;
        treeNode1_2.left = treeNode1_4;
        treeNode1_2.right = treeNode1_5;
        treeNode1_3.left = treeNode1_6;
        treeNode1_3.right = treeNode1_7;
        Mirror(treeNode1_1);
    }
}
