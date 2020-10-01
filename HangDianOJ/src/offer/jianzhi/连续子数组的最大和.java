package offer.jianzhi;



/**
 * 题目描述：
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:
 * 在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 *
 * 应该好好理解这个题目的意思！！找一个合适的规律出来！
 * 写代码还是不注意值的问题，老是返回错误的值，判断比较错了值！！！！
 * 思路出来了，但是代码写不出来，不知道如何构造这个代码，有正数解决了   妈的  还有负数！！！
 * */
public class 连续子数组的最大和 {
    public  static   int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int flag = 0;
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            flag = 0;
            for (int a = i; a < array.length; a++) {
                flag += array[a];
                if ( max < flag) {
                    max = flag;
                }
            }
        }
        return max;
    }


     /**for (int i = 1;i<array.length;i++){
        if (array[i]<0){
            continue;
        }
        sum = sum+array[i];
        if (sum>res){
            res = sum;
        }
    }*/
    public static void main(String [] args){
        int arr [] = {-2,-8,-1,-5,-9};

        int res = FindGreatestSumOfSubArray(arr);
        System.out.println(res);

//        System.out.println(7+(-15));
    }
}
