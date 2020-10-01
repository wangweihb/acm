package offer.jianzhi;

import java.util.ArrayList;

/**
 * 题目描述
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 *
 * 注意代码中的list链表保存的对象的时候，是保存的对象的地址，而不是对象的值！！！
 *
 * 写代码之前，把思路理清楚点，不要出一些小的bug，不然调试起来很复杂，注意思路的清晰
 * */
public class 二叉树中和为某一值的路径 {
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root!=null){
            myFindPath(root,target,list,res);
            return res;
        }else {
            return res;
        }
    }
    public static ArrayList<ArrayList<Integer>> myFindPath(TreeNode treeNode,int tartet,ArrayList<Integer> list,ArrayList<ArrayList<Integer>> res){
        if (treeNode.left!=null||treeNode.right!=null){
            list.add(treeNode.val);
            if (treeNode.left!=null){
                myFindPath(treeNode.left,tartet,list,res);
                //删除
                for (int i = 0;i<list.size();i++){
                    if (list.get(i)==treeNode.val){
                        for (int j = i+1;j<list.size();j++){
                            list.remove(j);
                        }
                    }
                }
            }
            //写递归代码的时候，少用else语句，因为很多时候，一出现递归，出现的情况比较的多，会出现考虑漏掉的情况。因此少用递归
            if (treeNode.right!=null){
                myFindPath(treeNode.right,tartet,list,res);
                //删除
                for (int i = 0;i<list.size();i++){
                    if (list.get(i)==treeNode.val){
                        for (int j = i+1;j<list.size();j++){
                            list.remove(j);
                        }
                    }
                }
            }
        }else {
            //判断结果是不是为目标的值，如果是的话，将结果加入到结果的链表中
            int sum = 0;
            //将叶节点的值加入到list中
            list.add(treeNode.val);
            for (int i = 0;i<list.size();i++){
                sum= sum + list.get(i);
            }
            if (sum == tartet){
                ArrayList<Integer> list1 = new ArrayList<>();
                for (int i = 0;i<list.size();i++){
                    list1.add(list.get(i));
                }
                res.add(list1);
            }
        }
        return res;
    }

    public static void main(String [] args){
        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(7);
        TreeNode treeNode5 = new TreeNode(12);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(9);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode5;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
//        treeNode5.left = treeNode6;
//        treeNode5.right = treeNode7;
        ArrayList<ArrayList<Integer>> res  = FindPath(treeNode1,22);
        System.out.println(res);
    }
}
