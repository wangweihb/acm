package offer.jianzhi;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 题目描述
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 * 设置两个变量，一个是记录下一行的节点数、另外一个变量是记录当前行节点还在队列中的数量
 *
 * 这个做起来还是比较的顺利的   哈哈哈哈   说明这段时间没白写   哈哈哈哈
 * */
public class 把二叉树打印多行 {
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> rowList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (pRoot == null){
            return res;
        }
        queue.add(pRoot);
        //开始循环
        int nextRowNumber = 0;
        int curRowNumber = 1;
        while (queue.size()!=0){
            //删除队列的头结点并且返回该节点
            TreeNode node = queue.poll();
            curRowNumber = curRowNumber - 1;
            rowList.add(node.val);
            if (curRowNumber == 0){
                res.add(rowList);
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
