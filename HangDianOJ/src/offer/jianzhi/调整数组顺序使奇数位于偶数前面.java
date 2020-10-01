package offer.jianzhi;

/**
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * 三次AC
 * 解题思路
 * */
public class 调整数组顺序使奇数位于偶数前面 {
    public static  int[] reOrderArray(int [] array) {
        //初始化
        int j_flag = getFJ(array);
        int o_flag = getFO(array);
        if (j_flag==-1 || o_flag==-1){
            return array;
        }
        if (j_flag > o_flag){
            array = movef(array,j_flag,o_flag);
            o_flag = j_flag;
            j_flag = 0;
        }
        //开始循环将奇数往前移
        for (int i = o_flag;i<array.length;i++){
            if (!isJi(array[i])){
                o_flag= i;
            }else {
                array = move(array,j_flag,i);
                j_flag++;
                o_flag++;
            }
        }
        return array;
    }

    public static boolean isJi(int num){
        return num%2==1?true:false;
    }
    public static int[] movef(int [] array,int j_flag,int o_flag){
        int temp = array[j_flag];
        for (int i = j_flag;i>0;i-- ){
            array[i] = array[i-1];
        }
        array[0] = temp;
        return array;
    }
    public static int[] move(int [] array,int j_flag,int k){
        int temp = array[k];
        for (int i = k;k>j_flag;k-- ){
            array[k] = array[k-1];
        }
        array[j_flag+1] = temp;
        return array;
    }
    public static int getFJ(int [] array){
        for (int i = 0;i<array.length;i++){
            if (isJi(array[i])){return i;}
        }
        return -1;
    }
    public static int getFO(int [] array){
        for (int i = 0;i<array.length;i++){
            if (!isJi(array[i])){return i;}
        }
        return -1;
    }
    public static void main(String [] args){
        int array[] ={2};
        int arr[] = reOrderArray(array);
        for (int i = 0;i<arr.length;i++){
            System.out.print((arr[i]));
        }
    }
}


//在牛客网上这样写
//public class Solution {
//    public void reOrderArray(int [] array) {
//        //初始化
//        int j_flag = getFJ(array);
//        int o_flag = getFO(array);
//        if (!(j_flag==-1 || o_flag==-1)){
//            if (j_flag > o_flag){
//                array = movef(array,j_flag,o_flag);
//                o_flag = j_flag;
//                j_flag = 0;
//            }
//            //开始循环将奇数往前移
//            for (int i = o_flag;i<array.length;i++){
//                if (!isJi(array[i])){
//                    o_flag= i;
//                }else {
//                    array = move(array,j_flag,i);
//                    j_flag++;
//                    o_flag++;
//                }
//            }
//        }
//    }
//    public  boolean isJi(int num){
//        return num%2==1?true:false;
//    }
//    public  int[] movef(int [] array,int j_flag,int o_flag){
//        int temp = array[j_flag];
//        for (int i = j_flag;i>0;i-- ){
//            array[i] = array[i-1];
//        }
//        array[0] = temp;
//        return array;
//    }
//    public  int[] move(int [] array,int j_flag,int k){
//        int temp = array[k];
//        for (int i = k;k>j_flag;k-- ){
//            array[k] = array[k-1];
//        }
//        array[j_flag+1] = temp;
//        return array;
//    }
//    public  int getFJ(int [] array){
//        for (int i = 0;i<array.length;i++){
//            if (isJi(array[i])){return i;}
//        }
//        return -1;
//    }
//    public  int getFO(int [] array){
//        for (int i = 0;i<array.length;i++){
//            if (!isJi(array[i])){return i;}
//        }
//        return -1;
//    }
//}