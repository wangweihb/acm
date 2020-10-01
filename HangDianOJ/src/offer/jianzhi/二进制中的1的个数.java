package offer.jianzhi;

/**
 * 题目描述
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * */
public class 二进制中的1的个数 {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;

        //注意  整数 和负数都有1
        while(n != 0){
            count+= n & 1;
            //>>> 无符号右移
            n= n>>>1;
        }
        return count;
    }


    public static  void main(String [] args){
        //左移运算 相当于除以2
        System.out.println(1>>1);

        //右移运算 相当于乘以2
        System.out.println(2<<1);

        //与运算
        System.out.println(1&2);

        //或运算 101
        System.out.println(1|2);

        //非运算 1010
        System.out.println(~3);




    }

}
