package offer.jianzhi;

import java.util.LinkedList;
import java.util.List;


//主要的思想是先序遍历的思想，然后遍历一个节点的时候，将路径保留下来，然后在比较哈
//官方的解释，回溯法
//https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/solution/mian-shi-ti-34-er-cha-shu-zhong-he-wei-mou-yi-zh-5/

public class 二叉树中和为某一值的路径2 {
    List<List<Integer>> res = new LinkedList<>();

    LinkedList<Integer> memberPath = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        obtainPath(root, sum);
        return res;
    }

    public void obtainPath(TreeNode node, int target){
        if(node != null){
            memberPath.add(node.val);
            target -= node.val;
            if(target == 0 && node.left == null && node.right == null){
                //注意深拷贝与浅拷贝
                res.add(new LinkedList(memberPath));
            }
            obtainPath(node.left, target);
            obtainPath(node.right, target);
            memberPath.removeLast();
        }
    }

    public static void main(String [] args){

    }
}
