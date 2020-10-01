package offer.leetcode;

import java.util.Arrays;

public class _16最接近的三数之和 {


    /**
     * 和三数之和的思路是一样的哈
     * @param nums
     * @param target
     * @return
     */

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int [] arr = new int[3];

        int flag = Integer.MAX_VALUE;
        if(len == 0) return -1;

        for(int i = 0 ; i < len ; i++){
            int j = i+ 1;
            int k = len - 1;
            while(j < k){
                int temp = target - (nums[i] + nums[j] + nums[k]);
                if(Math.abs(temp) < Math.abs(flag)){
                    flag = temp;
                    arr[0] = nums[i];
                    arr[1] = nums[j];
                    arr[2] = nums[k];
                }
                if(temp == 0){
                    return target;
                }
                if(temp <0){
                    k--;
                }else{
                    j++;
                }

            }
        }
        return arr[0] + arr[1] + arr[2];
    }


    public static void main(String [] args){
        int a = threeSumClosest(new int[]{-1,0,1,1,85}, 3);
        System.out.println(a);
    }

}
