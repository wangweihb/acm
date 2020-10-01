package offer.jianzhi;

/**
 * 一点资讯三面面试题
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 *
 * 对于临界条件，画图好好分析一下！遍历的过程中，临界条件，结束条件，判断条件仔细思考！
 *
 * 写了好久才AC，有了思路还搞了这么久！！！
 * */
public class 数组中出现次数超过一半的数字 {
//    public static  int MoreThanHalfNum_Solution(int [] array) {
//        if (array.length==0){
//            return -1;
//        }else {
//            int res = array[0];
//            int count = 1;
//            for (int i = 0;i<array.length;i++){
//                if (i<array.length-1){
//                    //这个地方出现了错误，写成了array[i+1]==array[i]   很明显的问题！！！
//                    if (array[i+1]==res){
//                        count=count+1;
//                    }else {
//                        count= count -1;
//                    }
//                    //临界条件的判断！！！老是搞得不是很清楚
//                    if (i!=array.length-2&&count==0){
//                        res = array[i+1];
//                        count = 1;
//                    }
//                }
//            }
//            return count<=0?0:res;
//        }
//    }

    /**
     * 大神解法，简单干净
     * @param nums
     * @return
     */
    public static int MoreThanHalfNum_Solution(int[] nums) {

        //摩尔投票
        int count = 0;
        Integer card = null;
        for(int num:nums){
            if(count == 0) card = num;
            count += (card == num)?1:-1;
        }
        return card;

    }

    public static void main(String [] args){
        int [] array = {1,2,3,2,4,2,5,2,3};
        int res = MoreThanHalfNum_Solution(array);
        System.out.println(res);
    }
}
