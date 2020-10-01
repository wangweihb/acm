package offer.jianzhi;


public class 斐波拉契数列 {
    /**从上往下递归来解，数据大量的重复计算！！！*/
    public static int Fibonacci1(int n) {
        if (n==1||n==2){
            return 1;
        }else {
            return Fibonacci1(n-1)+Fibonacci1(n-2);
        }
    }

    /**
     * 用一个数组保存f(1)~f(n-1)的值，最后计算即可
     * 从下面往上面计算，每个只计算一次*/
    public static int Fibonacci2(int n){
        if (n==1||n==2){
            return 1;
        }else if (n==0){
            return 0;
        }else {
            //构造数组
            int[] arr = new int[n-1];
            arr[0]=1;
            arr[1]=1;
            for (int i = 2;i<n-1;i++){
                arr[i] = arr[i-1]+arr[i-2];
            }
            //开始计算值
            return arr[n-2]+arr[n-3];
        }
    }
    /**
     * 直接使用变量来整
     * 效率最高
     * */
    public static int Fibonacci3(int n){
        if (n==1||n==2){
            return 1;
        }else if (n==0){
            return 0;
        }else {
            int p = 1;
            int q = 1;
            int k = 0;
            for (int i = 2;i<n;i++){
                k = p+q;
                p =  q;
                q = k;
            }
            return k;
        }
    }
    public static void main(String [] args){
        System.out.println(Fibonacci1(4));
        System.out.println(Fibonacci1(5));
        //---------------
        System.out.println(Fibonacci2(0));
        System.out.println(Fibonacci2(14));
        //---------------
        System.out.println(Fibonacci3(0));
        System.out.println(Fibonacci3(14));
    }
}
