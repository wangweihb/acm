package offer.jianzhi;


/**
 * 题目描述
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323
 *
 * 注意这个题有点小坑的就是，Integer长度太小，不够放足够大的数，报错的!!
 * Integer的范围：4个字节，32位，取值范围，正数最大为2的31次方-1 , 负数最小为负  2的31次方
 * Long的范围：8个字节，64位，取值范围，（-9223372036854774808~9223372036854774807），占用8个字节（-2的63次方到2的63次方-1）
 * byte的范围：一个字节是8位，-127到128
 * */
public class 把数组排成最小的数 {
    public static String PrintMinNumber(int [] numbers) {
        //使用冒泡排序，按照自己定义的排序，来排序！
        for (int i = 0 ; i<numbers.length-1;i++){
            for (int j = 0;j<numbers.length-i-1;j++ ){
                String cur = String.valueOf(numbers[j]);
                String next = String.valueOf(numbers[j+1]);
                if (Long.valueOf(cur+next)>Long.valueOf(next+cur)){
                    long temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = (int) temp;
                }
            }
        }
        String res = "";
        for (int i = 0;i<numbers.length;i++){
            res = res+ numbers[i];
        }
        return res;
    }

    public static void main(String [] args){

        int []arr = {3334,3,3333332};
        String res = PrintMinNumber(arr);
        System.out.println(res);

    }
}
