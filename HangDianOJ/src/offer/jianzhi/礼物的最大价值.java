package offer.jianzhi;

public class 礼物的最大价值 {
    //入门级的DP
    // dp[i][j] = grid[i][j] + Math.max(dp[i-1][j], dp[i][j-1]);
    public int maxValue(int[][] grid) {
        int row = grid.length;
        if(row < 0){
            return 0;
        }
        int col = grid[0].length;

        int [][] dp = new int[row+1][col+1];

        for(int i = 0 ; i < row; i++){
            for(int j = 0 ; j < col; j++){
                dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]) + grid[i][j];
            }
        }
        return dp[row][col];
    }

}
