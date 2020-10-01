package offer.jianzhi;

/**
 * 题目描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * */

/**
 class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }
 */
public class 树的子结构 {
    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        //root1和root2都不为空
        if (root1!=null&&root2!=null){
            if (root1.val == root1.val){
                result = r1HasR2(root1,root2);
            }
            //判断左子树是否包含
            if (result == false){
                result = HasSubtree(root1.left,root2);
            }
            if (result == false){
                result =  HasSubtree(root1.right,root2);
            }
        }
        return  result;
    }

    public static boolean r1HasR2(TreeNode root1,TreeNode root2){
        //如果在比较的时候，发现，节点的值不相等，返回false
        if (root2==null){
            return true;
        }
        if (root1==null){
            return false;
        }
        if (root1.val!=root2.val){
            return false;
        }
        boolean l = r1HasR2(root1.left,root2.left);
        boolean r = r1HasR2(root1.right,root2.right);
        boolean res = l&&r;
        return res;
    }
    public static void main(String[] args){
        TreeNode treeNode1_1 = new TreeNode(1);
        TreeNode treeNode1_2 = new TreeNode(2);
        TreeNode treeNode1_3 = new TreeNode(3);
        TreeNode treeNode1_4 = new TreeNode(4);
        treeNode1_1.left = treeNode1_2;
        treeNode1_1.right = treeNode1_3;
        treeNode1_2.left = treeNode1_4;

        TreeNode treeNode2_1 = new TreeNode(1);
        TreeNode treeNode2_2 = new TreeNode(2);
        TreeNode treeNode2_3 = new TreeNode(3);
        TreeNode treeNode2_4 = new TreeNode(4);
        treeNode2_1.left = treeNode2_2;
        treeNode2_1.right = treeNode2_3;
        treeNode2_2.left = treeNode2_4;

        System.out.println(HasSubtree(treeNode1_1,treeNode2_1));
    }

/**
 * 很好的解题思路，好好的理解一下递归的思想，感觉不是很会使用递归调用！！！！
 * */
    public static boolean HasSubtree2(TreeNode root1, TreeNode root2) {
        boolean result = false;
        //当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
        if (root2 != null && root1 != null) {
            //如果找到了对应Tree2的根节点的点
            if(root1.val == root2.val){
                //以这个根节点为为起点判断是否包含Tree2
                result = doesTree1HaveTree2(root1,root2);
            }
            //如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = HasSubtree(root1.left,root2);
            }

            //如果还找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = HasSubtree(root1.right,root2);
            }
        }
        //返回结果
        return result;
    }

    public static boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
        //如果Tree2已经遍历完了都能对应的上，返回true
        if (node2 == null) {
            return true;
        }
        //如果Tree2还没有遍历完，Tree1却遍历完了。返回false
        if (node1 == null) {
            return false;
        }
        //如果其中有一个点没有对应上，返回false
        if (node1.val != node2.val) {
            return false;
        }

        //如果根节点对应的上，那么就分别去子节点里面匹配
        return doesTree1HaveTree2(node1.left,node2.left) && doesTree1HaveTree2(node1.right,node2.right);
    }
}
