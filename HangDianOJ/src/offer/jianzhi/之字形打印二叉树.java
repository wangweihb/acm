package offer.jianzhi;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，
 *   第二层按照从右至左的顺序打印，
 *   第三行按照从左到右的顺序打印，其他行以此类推。
 * */
public class 之字形打印二叉树 {
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> rowList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (pRoot == null){
            return res;
        }
        queue.add(pRoot);
        //开始循环
        boolean flag = true;
        int nextRowNumber = 0;
        int curRowNumber = 1;
        while (queue.size() !=0 ){
            //删除队列的头结点并且返回该节点
            TreeNode node = queue.poll();
            curRowNumber = curRowNumber - 1;
            rowList.add(node.val);
            if (curRowNumber == 0){
                //只要在之字形打印二叉树的基础上小修改一下
                if (flag == true){
                    res.add(rowList);
                    flag = false;
                }else {
                    Collections.reverse(rowList);
                    res.add(rowList);
                    flag = true;
                }
            }
            if (node.left!=null){
                nextRowNumber = nextRowNumber + 1;
                queue.add(node.left);
            }
            if (node.right!=null){
                nextRowNumber = nextRowNumber + 1;
                queue.add(node.right);
            }
            if (curRowNumber == 0){
                rowList = new ArrayList<>();
                curRowNumber = nextRowNumber;
                nextRowNumber = 0;
            }
        }
        return res;
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
        ArrayList<ArrayList<Integer>> res = Print(root);
        System.out.println(res);
    }
}
