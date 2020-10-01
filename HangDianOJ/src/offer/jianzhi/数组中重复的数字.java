package offer.jianzhi;

/**
 * 题目描述
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 *
 *
 * */
public class 数组中重复的数字 {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false

    /**使用一个简单的hash表的原理，对数据进行归位！
     * Tips:注意，在归位的时候会出现这种情况{1,2,0,3,5}
     * 3的下标就是三，当指针指向3的时候，发现当前3的位置已经有一个3了，程序误认为找到重复值了！
     * */
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        boolean flag = false;
        for (int i = 0; i<length;i++){
            if (numbers[i] == i){
                continue;
            }
            if (numbers[i] == numbers[numbers[i]]){
                flag = true;
                duplication[0] = numbers[i];
                break;
            }else {
                int temp = numbers[numbers[i]];
                numbers[numbers[i]] = numbers[i];
                numbers[i] = temp;
            }
        }
       return flag==true?true:false;
    }

    public static void main(String [] args){
        int [] numbus = {2,1,3,1,4};
        int [] duplication = {0};
        //System.out.println(duplication.length);
        boolean res = duplicate(numbus,5,duplication);
        System.out.println(res);
    }
}
