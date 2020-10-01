package offer.jianzhi;

/**
 * 完美AC
 * 0->0
 * 1->1
 * 2->2
 * 3->3
 * 4->5
 * 5->8
 * ..->..
 * */
/**
 * 题目描述
 *一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * */
public class 青蛙跳台阶 {

    public static int JumpFloor(int target) {
        if (target==0||target==1){
            return target==0?0:1;
        }
        if (target ==2){
            return 2;
        }else {
            int p = 1;
            int q = 2;
            int k = 0;
            for (int i = 2;i<target;i++){
                k = p+q;
                p = q;
                q = k;
            }
            return k;
        }
    }
    public static void main(String [] args){
        System.out.println(JumpFloor(1));
        System.out.println(JumpFloor(2));
        System.out.println(JumpFloor(3));
        System.out.println(JumpFloor(4));
        System.out.println(JumpFloor(5));
    }
}
