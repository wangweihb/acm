package offer.jianzhi;

public class 二叉树的子树结构 {

//    这种递归的思路有问题
//    public static boolean isSubStructure(TreeNode A, TreeNode B) {
//        if(B == null){
//            return false;
//        }
//        return mySubStructure(A,B);
//    }
//
//    public static boolean mySubStructure(TreeNode A, TreeNode B) {
//        if(A != null && B != null && A.val == B.val){
//            return mySubStructure(A.left,B.left) && mySubStructure(A.right,B.right);
//        }else if(A != null && B != null && A.val != B.val){
//            return mySubStructure(A.left,B) || mySubStructure(A.right,B);
//        }else if((A == null && B == null) || (A!=null && B == null)){
//            return true;
//        }else{
//            return false;
//        }
//    }


    public static boolean mySubStructure(TreeNode A , TreeNode B)
    {
        if(A != null && B != null && A.val == B.val){
            return mySubStructure(A.left, B.left) && mySubStructure(A.right, B.right);
        }else if(B == null){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B == null || A == null){
            return false;
        }
        return mySubStructure(A,B) || isSubStructure(A.left, B)|| isSubStructure(A.right, B);
    }


    public static void main(String [] args){
//        isSubStructure(isSubStructure);
    }

}
