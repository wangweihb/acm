package offer.jianzhi;

/**
 * 题目描述:
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 *
 * 0->0
 * 1->1
 * 2->2
 * 3->4
 * 4->8
 * 5->16
 * ..->..
 */
public class 青蛙跳台阶变态 {
    public static  int JumpFloorII(int target) {
        if (target ==1||target ==0){
            return target==1?1:0;
        }else if (target == 2){
            return 2;
        }else {
            int k = 0;
            int p = 2;
            for (int i = 2 ;i<target;i++){
                k = p*2;
                p = k;
            }
            return k;
        }
    }
    public static void main(String [] args){
        System.out.println(JumpFloorII(0));
        System.out.println(JumpFloorII(1));
        System.out.println(JumpFloorII(2));
        System.out.println(JumpFloorII(3));
        System.out.println(JumpFloorII(4));
    }
}
