class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        boolean dp[][] = new boolean[grid.length][grid[0].length];
        
        for(int i=0 ; i<grid.length; i++){
            for(int j=0 ; j<grid[0].length ; j++){
                if(grid[i][j]==1){
                    max = Math.max(max, maxArea(i,j,grid, dp));
                }
            }
        }
        return max;
    }
    private int maxArea(int i, int j, int grid[][], boolean dp[][]){
        if(dp[i][j])
            return 0;
        dp[i][j] = true;
        int max = 1;
        if(j>0 && grid[i][j-1]==1)
             max += maxArea(i,j-1,grid,dp);
        
        if(j+1<grid[0].length && grid[i][j+1]==1)
             max += maxArea(i,j+1,grid,dp);
        
        if(i>0 && grid[i-1][j]==1)
             max += maxArea(i-1,j,grid,dp);
        
        if(i+1<grid.length && grid[i+1][j]==1)
             max += maxArea(i+1,j,grid,dp);
        return max;
    }
}