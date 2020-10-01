package offer.leetcode;

public class _07整数反转 {

    /**
     * 作者：wang_ni_ma
     * 链接：https://leetcode-cn.com/problems/reverse-integer/solution/tu-jie-7-zheng-shu-fan-zhuan-by-wang_ni_ma/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static int reverse(int x) {
        int res = 0;
        while(x!=0) {
            //每次取末尾数字
            int tmp = x%10;
            //判断是否 大于 最大32位整数
            if (res>214748364 || (res==214748364 && tmp>7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res<-214748364 || (res==-214748364 && tmp<-8)) {
                return 0;
            }
            res = res*10 + tmp;
            x /= 10;
        }
        return res;
    }


    /**
     * 将res 由int类型转化为long类型；  这样子很好判断数字是否越界了
     *
     * 在java中，负数取模的结果还是负数
     * * @param x
     * @return
     */
    public static int myReverse(int x) {
        long res = 0;
        while(x!=0){
            int temp = x % 10;

            //这儿就很精髓了。如果是结尾是0开头的话，0*10 还是0,；；；；
            res = res*10 + temp;
            x/=10;
            if(res > Integer.MAX_VALUE){
                res = 0;
                break;
            }
            if(res < Integer.MIN_VALUE){
                res = 0;
                break;
            }
        }
        return Integer.valueOf(String.valueOf(res));
    }


    public static void main(String [] args){


        int a = -2001;

        int res = reverse(a);

        System.out.println(res);
    }



}
