package offer.jianzhi;

/**
 * 题目描述
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * //使用栈遍历  或者  使用空间换时间，在遍历
 *
 * 递归好好的理解一下！！   极大的优化递归！！！
 *
 * 这块代码还是可以优化！！  从根节点递归效率很低，每个节点都会求一遍它的深度，如果从下而上求是不是满足条件，效率会高一些！！！
 * */
public class 二叉树的深度 {
    public static  int TreeDepth(TreeNode root) {
        if (root == null ){
            return 0;
        }else {
            int res = getDepth(root,0);
            return res;
        }
    }
    public static int getDepth(TreeNode node,int depth){
        if (node==null){
            return depth;
        }else {
            depth = depth + 1;
            return getDepth(node.left,depth)>getDepth(node.right,depth)?getDepth(node.left,depth):getDepth(node.right,depth);
        }
    }
/**前后比较一下，代码的差异，好好递归debug一下，理解一下！！！写代码前思路不是特别的清晰！！！*/
/*    public  int TreeDepth(TreeNode root) {
        if (root == null ){
            return 0;
        }else {
            int res = getDepth(root,0);
            return res;
        }
    }
    public int getDepth(TreeNode node,int depth){
        if (node==null){
            return depth;
        }else {
            depth = depth + 1;
            int max = depth;
            depth = getDepth(node.left,depth);
            if (depth>max){
                max = depth;
                depth = depth -1;
            }
            depth = getDepth(node.right,depth);
            if (depth>max){
                max = depth;
                depth = depth -1;
            }
            return max;
        }
    }*/

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
        r4.right = r2;
        int res = TreeDepth(root);
        System.out.println(res);

    }
}
