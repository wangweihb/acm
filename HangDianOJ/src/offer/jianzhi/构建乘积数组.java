package offer.jianzhi;


/**
 * 题目描述
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * 题目理解错了！！！！炸了   我是说好奇怪！！！
 * 时间复杂度O（n）  空间复杂度O（n）
 *
 * 具体思路看剑指offer这本书，思路和书上的一样的！！
 * */
public class 构建乘积数组 {
    public static int[] multiply(int[] A) {
        int length = A.length;
        if (length == 0 || length ==1){
            return A;
        }
        int [] nextArr = new int[length-1];
        int [] preArr = new int[length-1];
        int next = 1;
        int pre = 1;
        for (int i = 0;i<length-1;i++){
            next = next * A[i];
            nextArr[i] = next;
            pre = pre * A[length-i-1];
            preArr[i] = pre;
        }
        //拼接组合返回数组
        int [] res = new int[length];
        for (int i = 0 ;i<length;i++){
            if (i == 0){
                res[i] = preArr[preArr.length-1];
            }
            if (i == length-1){
                res[i] = nextArr[nextArr.length-1];
            }
            if (i>0&&i<length-1)
            {
                res[i] = preArr[preArr.length-1-i] * nextArr[i-1];
            }
        }
         return res;
    }

    public static void main(String [] args){
        int [] arr = {1,2,3,4,5};
        int [] res = multiply(arr);
        System.out.println(res);
    }
}
