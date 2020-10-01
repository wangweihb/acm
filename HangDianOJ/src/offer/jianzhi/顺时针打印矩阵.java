package offer.jianzhi;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

// 遍历顺序
//         step1
//         -------->              //每一行遍历完了，需要判断开始行是否等于结束行 (原因是避免step3下面从右往左再次遍历一遍)
//       | 1 2  3  4  |   step2   //同理当第一列遍历完了，需要判断开始列是否等于结束列(原始是避免step4从下向上再次遍历一遍)
//step4  | 5 6  7  8  |
//         9 10 11 12
//         <--------
//            step3
//
public class 顺时针打印矩阵 {

    public static int[] spiralOrder(int[][] matrix) {
        int row = matrix.length;
        if(row == 0){
            return null;
        }

        int col = matrix[0].length;
        int startRow = 0;
        int endRow = row-1;
        int startCol = 0;
        int endCol = col-1;
        int res [] = new int[row*col];
        int index = 0;

        while(startRow <= endRow && startCol <= endCol){
            //上面行
            for(int i = startCol; i <= endCol; i++){
                res[index] = matrix[startRow][i];
                index+=1;
            }
            if(startRow == endRow){
                break;
            }

            //右边列
            for(int i = startRow+1; i < endRow; i++){
                res[index] = matrix[i][endCol];
                index+=1;
            }

            //下面行
            for(int i = endCol; i >= startCol;i--){
                res[index] = matrix[endRow][i];
                index +=1;
            }
            if(startCol == endCol){
                break;
            }

            //左边列
            for(int i = endRow-1; i > startRow;i--){
                res[index] = matrix[i][startCol];
                index+=1;
            }

            startRow+=1;
            endRow-=1;
            startCol+=1;
            endCol-=1;
        }
        return res;
    }

    public static  void main(String [] args
    ){
        int [][] arr = new int[][]{{7},{9},{6}};
        int[] res = spiralOrder(arr);
        for(int i = 0 ; i < res.length;i++){
            System.out.println(res[i]);
        }
    }
}
