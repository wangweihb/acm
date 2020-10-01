package offer.jianzhi;

public class 二叉树中和为某一值的路径升级版 {
//    int num = 0;
//    public int pathSum(TreeNode root, int sum) {
//        dsp(root, 0, sum);
//        return num;
//    }
//
//    public void dsp(TreeNode node, int  sum,int target){
//        if(node != null){
//            sum=sum + node.val;
//            if( sum == target){
//                num +=1;
//            }
//            //这样写有点问题哦
////            dsp(node.left, node.val, target);
////            dsp(node.right, node.val, target);
//            dsp(node.left, sum, target);
//            dsp(node.right, sum, target);
//        }
//    }

//    将上面的代码小改一下，使用双重递归
//    写代码前想清楚，
    int num = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        dsp(root, 0, sum);
        pathSum(root.left, sum);
        pathSum(root.right , sum);
        return num;
    }

    public void dsp(TreeNode node, int  sum,int target){
        if(node != null){
            sum=sum + node.val;
            if( sum == target){
                num +=1;
            }
            // dsp(node.left, node.val, target);
            // dsp(node.right, node.val, target);
            dsp(node.left, sum, target);
            dsp(node.right, sum, target);
        }
    }

}
