package offer.jianzhi;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 * */
public class 和为S的两个数字 {
    public static  ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        List<Integer> res = new ArrayList<>();
/**     小伙子  头脑简单了啊！！！
        for (int i = 0 ; i< array.length;i++){
            if (array[i]+array[array.length-1-i] == sum){
                System.out.print(array[i]);
                System.out.print(array[array.length-1-i]);
                res.add(array[i]);
                res.add(array[array.length-1-i]);
                break;
            }
        }*/
        if (array.length == 0){
            return (ArrayList<Integer>) res;
        }
        int pre = 0;
        int tail =  array.length-1;
        while (tail!=pre){
            if (array[pre]+array[tail]==sum){
                res.add(array[pre]);
                res.add(array[tail]);
                return (ArrayList<Integer>) res;
            }
            if (array[pre]+array[tail]<sum){
                pre = pre + 1;
            }
            if (array[pre]+array[tail]>sum){
                tail = tail - 1;
            }
        }
        return (ArrayList<Integer>) res;
    }

    public static void main(String [] args){
        int [] array = {1,2,4,7,11,15};
        ArrayList<Integer> res = FindNumbersWithSum(array,15);
        System.out.println(res);
    }
}
