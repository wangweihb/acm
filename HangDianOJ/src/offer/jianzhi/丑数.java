package offer.jianzhi;


//***没有做  测试一下思路

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * 时间换空间，丑数生成数！！！把这个想到了，代码却不是很难，写起来很容易！！！
 * 丑数的定义！想好！以及三个数求最小值！！
 * */
public class 丑数 {
    static boolean isUgly(int number){
        while (number%2 ==0){
            number/= 2;
        }
        while (number%3 ==0){
            number/= 3;
        }
        while (number%5 ==0){
            number/= 5;
        }
        return number==1?true:false;
    }
    public static int GetUglyNumber_Solution(int n) {
        //判断一个数是不是丑数
        // isUglyNumver(n);
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        for(int j = 1; j<n;j++){
            int k = 1;
            int m = 1;
            int s = 1;
            int len = list.size()-1;
            for(int i = 0 ; i < list.size();i++ ){
                if(list.get(i)*2 > list.get(len)){
                    k = list.get(i)*2;
                    break;
                }
            }
            for(int i = 0 ; i < list.size();i++ ){
                if(list.get(i)*3 > list.get(len)){
                    m = list.get(i)*3;
                    break;
                }
            }
            for(int i = 0 ; i < list.size();i++ ){
                if(list.get(i)*5 > list.get(len)){
                    s = list.get(i)*5;
                    break;
                }
            }
            list.add(Math.min(k,Math.min(m,s)));

        }
        return list.get(list.size()-1);
    }
    public static int threeMin(int sum_2,int sum_3,int sum_5){
        if (sum_2<sum_3){
            if (sum_2<sum_5){
                return sum_2;
            }else
                return sum_5;
        }else {
            if (sum_3<sum_5){
                return sum_3;
            }else
                return sum_5;
        }
    }

    /**这种做法时间复杂度超了！！！
    public static int GetUglyNumber_Solution(int index) {
        int res = 0;
        int count = 1;
        while (res <index){
            boolean flag = isUgly(count);
            if (flag==true){
                res = res+1;
            }
            count = count+1;
        }
        return count-1;
    }*/
    public static void main(String [] args){
        int min = GetUglyNumber_Solution(8);
        System.out.println(min);
    }
}
