package offer.jianzhi;

import java.util.ArrayList;

/**
 * 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * */
public class 顺时针打印矩阵没写完 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix == null){

        }
        ArrayList<Integer> list = new ArrayList<>();
        int width = matrix[0].length;
        int lenth = matrix.length;
        for (int i =0 ;i<lenth;i++){
            list.add(matrix[0][i]);
        }
        //判断如果不是1*n的数组，遍历
        if (width>2){
            for (int i = 1; i<width-1;i++){
                list.add(matrix[i][width-1]);
            }
            for (int i = lenth-2 ;i>=0;i--){
                list.add(matrix[width-1][i]);
            }
            for (int i = width-1;width>0;width--){
                list.add(matrix[i][0]);
            }
        }
        //width =2
        if (width==2){
            for (int i = lenth-2 ;i>=0;i--){
                list.add(matrix[width-1][i]);
            }
        }
        return list;
    }
//    public static ArrayList<Integer> getList(int [][] matrix,int width,int lenth,ArrayList<Integer> list){
//
//    }
    public static void main(String [] args){

    }
}
