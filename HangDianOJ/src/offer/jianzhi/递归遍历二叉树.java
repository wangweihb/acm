package offer.jianzhi;

/**
 * 递归遍历二叉树
 * */
public class 递归遍历二叉树 {
    /**
     * 二叉树的先序遍历
     * 递归遍历
     * */
    public static void firstOrder(TreeNode tree){
        if (tree!=null){
            System.out.print(tree.val);
            firstOrder(tree.left);
            firstOrder(tree.right);
        }
    }

    /**
     * 二叉树的中序遍历
     * 递归遍历
     * */
    public static void secOrder(TreeNode tree){
        if (tree!=null){
            secOrder(tree.left);
            System.out.print(tree.val);
            secOrder(tree.right);
        }
    }

    /**
     * 二叉树的中序遍历
     * 递归遍历
     * */
    public static void lastOrder(TreeNode tree){
        if (tree!=null){
            lastOrder(tree.left);
            lastOrder(tree.right);
            System.out.print(tree.val);
        }
    }

    public static void main(String [] args){
        TreeNode root = new TreeNode(5);
        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(2);
        TreeNode l3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(6);
        root.left = l1;
        root.right = r4;
        l1.left = l2;
        l1.right = l3;

        firstOrder(root);
        System.out.println();
        secOrder(root);
        System.out.println();
        lastOrder(root);
    }
}
