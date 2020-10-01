package offer.jianzhi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//BFS 遍历，每一层打印一行结果
public class 二叉树的层次遍历TWO {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 方法一：使用两个队列来做，不必记录每层有多少个节点
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        if(root != null){
            queue1.offer(root);
        }
        while(queue1.peek() != null || queue2.peek() != null){
            List<Integer> clist = new ArrayList<>();
            if(queue1.peek() != null){
                while(queue1.peek() != null){
                    TreeNode node = queue1.poll();
                    clist.add(node.val);
                    if(node.left != null){
                        queue2.add(node.left);
                    }
                    if(node.right != null){
                        queue2.add(node.right);
                    }
                }
                res.add(clist);
                continue;
            }

            while(queue2.peek() != null){
                TreeNode node = queue2.poll();
                clist.add(node.val);
                if(node.left != null){
                    queue1.add(node.left);
                }
                if(node.right != null){
                    queue1.add(node.right);
                }
            }
            res.add(clist);

        }
        return res;

        // 方法二:
        //使用queue的size   是直接使用queue的size来记录每层节点数
//        Queue<TreeNode> queue = new LinkedList<>();
//        List<List<Integer>> res = new ArrayList<>();
//        if(root != null) queue.add(root);
//        while(!queue.isEmpty()) {
//            List<Integer> tmp = new ArrayList<>();
//            for(int i = queue.size(); i > 0; i--) {
//                TreeNode node = queue.poll();
//                tmp.add(node.val);
//                if(node.left != null) queue.add(node.left);
//                if(node.right != null) queue.add(node.right);
//            }
//            res.add(tmp);
//        }
//        return res;
    }
}
