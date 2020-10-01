package offer.jianzhi;
//ucloud面试题
//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
// 使用位运算
// 同或运算  (A   ^   B)   ^  1
// 异或运算 ^ 相同为0 相异为1
// 与运算 &
// 或运算 |
// 非运算 !
public class 数组中数据出现的次数 {


    public static void main(String [] args){
        testBite();
    }

    public static void testBite(){
        System.out.println(1&1);
        System.out.println(1|1);
        System.out.println(2|1);
    }
}


