class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for(int i=0 ; i<m ; i++)
            Arrays.fill(dp[i], -1);
        
        int res = grid[0][0] + solution(0, 0, m, n, grid, moveCost, dp);
        for(int j=0 ; j<n ; j++)
            res = Math.min(res, (grid[0][j] + solution(0, j, m, n, grid, moveCost, dp)));
        return res;
    }
    public int solution(int i, int j, int m, int n, int[][] g, int[][] move, int[][] dp){
        if(i==m-1) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int sum = move[g[i][j]][0] + g[i+1][0] + solution(i+1, 0, m, n, g, move, dp);
        for(int k=1; k<n ; k++)
            sum = Math.min(sum, (move[g[i][j]][k] + g[i+1][k] + solution(i+1, k, m, n, g, move, dp)));
        return dp[i][j] = sum;
    }
}