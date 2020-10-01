package offer.jianzhi;

import java.util.Arrays;

public class 数组中数据出现的次数Plus {

    public static void main(String [] args){
        singleNumber(new int[]{3,-4,3,3});
        System.out.println("abc".substring(0,1));
        String [] arr= "a good   example".split(" ");
        System.out.println(3>>1);
    }

    public static int singleNumber(int[] nums) {
        int [] k = new int[32];

        for(int i = 0 ; i < nums.length;i++){
            for(int j = 0 ; j <32;j++){
                k[j] += (nums[i]>>j & 1) == 1 ? 1 : 0;
            }
        }

        int res = 0;
        for(int i = 31;i>=0;i--){
            res = res << 1;
            if(k[i]%3 == 1){
                res = (res | 1);
            }

        }
        return res;

    }
}
