package offer.jianzhi;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * 快速排序
 */
public class 把数组排成最小的数2 {
    public static String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
         for(int i = 0; i < nums.length; i++)
             strs[i] = String.valueOf(nums[i]);
        // Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        quickSort(strs, 0, nums.length-1);

        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }

    //使用快排写一下，最主要是使用str.compareTo(str1)

    public static void quickSort(String[] str, int start, int end){
        if(start<end){
            int partition = getPartition(str, start, end);
            quickSort(str, start, partition-1);
            quickSort(str, partition+1, end);
        }
    }


    public static int getPartition(String[] str, int start, int end){
        int i = start;
        int j = end;
        int p = start;
        String temp = str[start];
        while(i < j){
            while(i < j && str[j].compareTo(temp) >=0 ) j--;
            while(i < j && str[i].compareTo(temp) <=0 ) i++;
            if(i < j)  {
                swap(str, i , j);
            }

        }

        str[start] = str[i];
        str[i] = temp;
        return i;
    }

    public static void swap(String[] str, int i, int j){
        String temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
    public static void main(String [] arsg){
        minNumber(new int []{3,30,34,5,9});
        System.out.println("30".compareTo("3"));
    }
}
