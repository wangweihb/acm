package offer.jianzhi;

public class 数值的整数次方 {

    //推倒一下
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        //画一下流程！！！！
        while(b > 0) {
            if((b & 1) == 1){
                //只有当b为奇数的时候res才乘x
                res *= x;
            }

            x*=x;

            b >>= 1;

        }
        return res;
    }




}
