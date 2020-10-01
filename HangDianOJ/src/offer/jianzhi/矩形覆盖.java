package offer.jianzhi;

/**
 * 题目描述:
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 0->0
 * 1->1
 * 2->2
 * 3->3
 * 4->5
 * 5->8
 * ..->..
 * */
public class 矩形覆盖 {
    public static  int RectCover(int target) {
        if (target == 1|| target == 0){
            return target == 1?1:0;
        }else if (target ==2){
            return 2;
        }else {
            int k = 0;
            int p = 1;
            int q = 2;
            for(int i = 2;i<target;i++){
                k = p+q;
                p = q;
                q = k;
            }
            return k;
        }
    }
    public static void main(String [] args){
        System.out.println(RectCover(0));
        System.out.println(RectCover(1));
        System.out.println(RectCover(2));
        System.out.println(RectCover(3));
        System.out.println(RectCover(4));
    }
}
