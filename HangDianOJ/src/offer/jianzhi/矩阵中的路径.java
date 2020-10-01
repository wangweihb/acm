package offer.jianzhi;

public class 矩阵中的路径 {

    public static boolean exist(char[][] board, String word) {
        int row = board.length;
        //判断数组是不是二维数组
        if(row<0){
            return false;
        }
        int col = board[0].length;
        int [][] flag = new int[row][col];

        char[] words = word.toCharArray();
        boolean res = false ;
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col; j++){
                res = isExist(board, flag, words, 0, i , j);
                if(res){
                    return res;
                }
            }
        }
        return res;
    }

    public static boolean isExist(char[][] board, int [][] flag, char[] words, int index, int i, int j){

        if(index > words.length -1){
            return true;
        }
        char word = words[index];
        int row = board.length;
        int col = board[0].length;
        if(i>=0 && i< row && j >=0 && j<col &&  flag[i][j] != 1 && word == board[i][j]){
            flag[i][j] = 1;
            //向左遍历
            boolean l = isExist(board, flag, words, index+1, i, j-1);
            if (l){
                return l;
            }
            //向右遍历
            boolean r = isExist(board, flag, words, index+1, i, j+1);
            if (r){
                return r;
            }
            //向上遍历
            boolean up = isExist(board, flag, words, index+1, i-1, j);
            if (up){
                return up;
            }

            //向下遍历
            boolean d = isExist(board, flag, words, index+1, i+1, j);
            if (d){
                return d;
            }
            flag[i][j] = 0;
            return false;
        }else{
            return false;
        }
    }

    public static void main(String [] args){



        char [][] arr = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};

        String words = "ABCCED";
       boolean res =  exist(arr, words);
        System.out.println(res);
    }
}
