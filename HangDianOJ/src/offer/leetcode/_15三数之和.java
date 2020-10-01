package offer.leetcode;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
public class _15三数之和 {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        for(int i = 0 ; i < len ;i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int target = -nums[i];
            int j = i+1;
            int k = len-1;
            while(j < k){
                if(target == (nums[j] + nums[k])){
                    List<Integer> curr = new ArrayList<>();
                    curr.add(nums[j]);
                    curr.add(nums[k]);
                    curr.add(-target);
                    res.add(curr);

                    while(j+1 < len && nums[j+1] == nums[j]) j++;
                    while(k-1 >= 0 && nums[k-1] == nums[k]) k--;
                    j++;
                    k--;

                }else if(target > (nums[j] + nums[k])){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return res;
    }

    public static void main(String [] arg){
        System.out.println(threeSum(new int[]{-2,0,1,1,2}));
    }


}
