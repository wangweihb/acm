package offer.jianzhi;

public class 旋转数组中的最小数字 {
    public static int minArray(int[] numbers) {

        int low = 0;
        int len = numbers.length;
        int high = len -1;
        if(high < 0){
            return 0;
        }

        //注意  mid 要和high比较，不能和low比较，因为完全递增的序列mid 也大于low

        while(low < high){
            int mid = (low + high)/2;
            if(numbers[mid] > numbers[high]){
                low = mid+1;
            }else if(numbers[mid] < numbers[high]){
                high = mid;
            }else{
                high--;
            }
        }
        return numbers[high];

    }


    public static void main(String [] args){
        int [] arr  = new int []{1,3,3};
        minArray(arr);
    }

}
