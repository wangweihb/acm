package offer.jianzhi;

/**
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 这类题目现在知道了怎么样写递归，但是不知道怎么写结束条件，以及不能很好的判断边界条件
 * java中最好不要定义一个指针变量等于-1，否则的话   后面会有一堆的判断，很复杂啦！！！
 * */
public class 二叉搜索树的后续遍历 {
    public static  boolean VerifySquenceOfBST(int [] sequence) {
        //代码还需要进行一个验证
        if (sequence.length==0){
            return false;
        }else {
            return myVerifySquenceOfBST(sequence,0,sequence.length-1);
        }
    }
    public static boolean myVerifySquenceOfBST(int [] sequence,int start,int end){
        if(end <= start) return true;
        int i = start;
        for (; i < end; i++) {
            if(sequence[i] > sequence[end]) break;
        }
        for (int j = i; j < end; j++) {
            if(sequence[j] < sequence[end]) return false;
        }
        return myVerifySquenceOfBST(sequence, start, i-1) && myVerifySquenceOfBST(sequence, i, end-1);
    }


    public static void main(String [] args){
        int arr [] = {5,7,6,9,11,10,8};
        boolean result = VerifySquenceOfBST(arr);
        System.out.println(result);
    }
}
