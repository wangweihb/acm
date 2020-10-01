package offer.jianzhi;


/**
 * 题目描述
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * 根据这个特性，解题思路。使用两次遍历，两次先序遍历（根左右）和（根右左）
 *
 * 已经AC了。好好思考一下怎么递归调用！！！
 * */
public class 对称二叉树 {
    public static boolean isSymmetrical(TreeNode pRoot)
    {
        String s1 = getlr(pRoot).toString();
        String s2 = getrl(pRoot).toString();
        System.out.println(s1);
        System.out.println(s2);
        return s1.equals(s2);
    }
    /**根左右遍历pRoot，当节点没有左右孩子，则使用null代替，排除数字全是一样的情况*/
    public static StringBuffer getlr(TreeNode root){
        StringBuffer buffer = new StringBuffer();
        return myscan(root,"lr",buffer);
    }
    /**根右左遍历pRoot*/
    public static StringBuffer getrl(TreeNode root){
        StringBuffer buffer = new StringBuffer();
        return myscan(root,"rl",buffer);
    }
    public static StringBuffer myscan(TreeNode treeNode,String param,StringBuffer buffer){
        if (treeNode!=null){
            buffer.append(treeNode.val);
            //根左右遍历
            if ("lr".equals(param)){
                myscan(treeNode.left,param,buffer);
                //这个地方有问题，当buffer中已经有了很多数据,已经把buffer传进去了，递归调用里面添加了数据，返回回来，又给buffer中重复添加了一遍。
                //因此不能这样写buffer.append(myscan(treeNode.right,param,buffer));
                myscan(treeNode.right,param,buffer);
            }
            //根右左遍历
            if ("rl".equals(param)){
                myscan(treeNode.right,param,buffer);
                myscan(treeNode.left,param,buffer);
            }
        }else {
            buffer.append("null");
        }
        return buffer;
    }
    public static void main(String [] args){
        TreeNode treeNode1_1 = new TreeNode(8);
        TreeNode treeNode1_2 = new TreeNode(6);
        TreeNode treeNode1_3 = new TreeNode(6);
        TreeNode treeNode1_4 = new TreeNode(5);
        TreeNode treeNode1_5 = new TreeNode(7);
        TreeNode treeNode1_6 = new TreeNode(7);
        TreeNode treeNode1_7 = new TreeNode(5);
        treeNode1_1.left = treeNode1_2;
        treeNode1_1.right = treeNode1_3;
        treeNode1_2.left = treeNode1_4;
        treeNode1_2.right = treeNode1_5;
        treeNode1_3.left = treeNode1_6;
        treeNode1_3.right = treeNode1_7;
        isSymmetrical(treeNode1_1);
    }
}
