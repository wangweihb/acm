package offer.jianzhi;

//定义二叉树类
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
//标准答案
class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {

        if(startPre>endPre||startIn>endIn)
            return null;
        TreeNode root=new TreeNode(pre[startPre]);

        for(int i=startIn;i<=endIn;i++)
            if(in[i]==pre[startPre]){
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
                break;
            }

        return root;
    }
}
//这个浪费空间，并且不好判断，
public class 重建二叉树 {
    //递归调用，构造root以及left\rigth
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        //需要对中序遍历数组和先序遍历数组进行验证
        if (pre.length<2){
            return null;
        }
        //找到root
        int root;
        int l_pre[] = new int[100];
        int r_pre[] = new int[100];
        int l_in[]  = new int[100];
        int r_in[] =  new int[100];
        int i;
        root = pre[0];
        //找到以root为根的左子树的中序遍历和以root为根的右子树中序遍历
        for (i = 0;i<in.length;i++)
        {
            l_in[i] = in[i];
        }
        for (i = root;i<in.length;i++)
        {
            r_in[i] = in[i];
        }
        //找到以root为根的左子树的先序遍历和右子树的先序遍历
        for (i =1;i<l_in.length;i++)
        {
            l_pre[i] = pre[i];
        }
        for (i =root+1;i<pre.length;i++)
        {
            r_pre[i] = pre[i];
        }
        TreeNode t = new TreeNode(root);
        t.left= reConstructBinaryTree(l_pre,l_in);
        t.right = reConstructBinaryTree(r_pre,r_in);
        return t;
    }


}
