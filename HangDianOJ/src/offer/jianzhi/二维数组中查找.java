package offer.jianzhi;

public class 二维数组中查找 {

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        //从左上角遍历整个数组
        int row = matrix.length-1;
         if(row < 0){
             return false;
         }
        int col = matrix[0].length-1;

        int i = 0;
        int j = col;

        boolean res = false;
        while (i <= row && j >= 0){
            if(matrix[i][j] == target){
                res = true;
                break;
            }else if(matrix[i][j] > target){
                j--;
            }else{
                i++;
            }
        }
        return res;
    }


    public static void main(String [] args){
        int [][] arr = new int[1][1];
        arr[0][0] = -5;


        findNumberIn2DArray(arr, -5);
    }
}
