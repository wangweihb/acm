package offer.jianzhi;


import java.util.*;

/**
 * 题目描述
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * */
public class 二叉树的层次遍历 {
    public static ArrayList<Integer> getlist(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        if (root!=null){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (queue.size()>0){
                //删除队列的头结点并且返回该节点
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left!=null){
                    //往队列中添加节点
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            return list;
        }else {
            return list;
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
        root = null;
        List<Integer> list = getlist(root);
        System.out.println(list);
    }
}
