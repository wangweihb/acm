package offer.jianzhi;

public class 二叉搜索树的后续遍历2 {
    //找到一个位置，前面的值都比根节点小（可以没有），后面的值都比根节点大（可以没有）
    public static boolean verifyPostorder(int[] postorder) {
        return isPostorder(postorder, 0, postorder.length-1);
    }

    public static boolean isPostorder(int[] postorder, int startIndex, int endIndex){
        if(startIndex >= endIndex){
            return true;
        }
        int midIndex = startIndex;
        for(int i = endIndex-1; i>= startIndex;i--){
            if(postorder[endIndex]>postorder[i]){
                for(int j = i ; j >=startIndex;j--){
                    if(postorder[endIndex] < postorder[j] ){
                        return false;
                    }
                }
                return isPostorder(postorder, startIndex, i) && isPostorder(postorder, i+1, endIndex-1);
            }
        }
        return true;
    }

    public static void main(String [] args){
        System.out.println(verifyPostorder(new int[]{7,4,6,5}));
    }
}
