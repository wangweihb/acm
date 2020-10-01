package offer.jianzhi;

import java.util.ArrayList;

/**
 * 题目描述
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 输出描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *
 * 一大一小的指针开始遍历，这些代码都不是很难，但是实现思路很难思考。怎么样遍历才能到达这样的效果！
 * */
public class 和为S的连续正数序列 {

    public static  ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum == 0 || sum == 1 || sum == 2){
            return res;
        }
        int pre = 1;
        int tail = 2;
        while (pre!=tail){
            int j= pre;
            int mysum = 0;
            while (j<=tail){
                mysum = mysum+j;
                j = j+1;
            }
            if (mysum == sum){
                ArrayList<Integer> arr = new ArrayList<>();
                int i= pre;
                while (i<=tail){
                    arr.add(i);
                    i = i+1;
                }
                res.add(arr);
                tail = tail+1;
            }
            if (mysum<sum){
                tail = tail+1;
            }
            if (mysum>sum){
                pre = pre+1;
            }
        }
        return res;
    }

    public static void main(String [] args){

        ArrayList<ArrayList<Integer>> res = FindContinuousSequence(100);
        System.out.println(res);
    }
}
