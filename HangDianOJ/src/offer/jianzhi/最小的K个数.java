package offer.jianzhi;

import java.util.ArrayList;
/**
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *
 * 还是之前的问题，循环中判断条件的问题！！！一旦写错了，程序异常运行！
 * 写判断条件的时候，仔细一点。越简单的问题，越要注意程序的稳定性！
 * */
public class 最小的K个数 {
    public static  ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (k>input.length||k==0){
            return arrayList;
        }
        int []arr = new int[k];
        for (int i = 0; i<input.length;i++){
            if (i<k){
                arr[i] = input[i];
            }else {
                int max = arr[0];
                int maxIndex = 0;
                //得到最大值
                for (int j = 0;j<arr.length;j++){
                    if (arr[j]>=max){
                        max = arr[j];
                        maxIndex = j;
                    }
                }
                if (max>input[i]){
                    arr[maxIndex] = input[i];
                }
            }
        }
        for (int i = 0 ; i<arr.length;i++){
            arrayList.add(arr[i]);
        }
        return arrayList;
    }

    public static void main(String [] args){
        int [] arr={4,5,1,6,2,7,3,8};
        ArrayList<Integer> res = GetLeastNumbers_Solution(arr,4);
        System.out.println(res);
    }
}
