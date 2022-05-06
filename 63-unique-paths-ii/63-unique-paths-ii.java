class Solution {
    public int uniquePathsWithObstacles(int[][] o) {
        if(o[0][0]==1) return 0;
        
        int dp[] = new int[o[0].length];
        for(int j=0 ; j<o[0].length ; j++){
            if(o[0][j]!=1)
                dp[j] = 1;
            else 
                break;
        }
        for(int i=1 ; i<o.length ; i++){
            if(o[i][0]==1) dp[0] = 0;
            
            for(int j=1 ; j<o[0].length ; j++){
                if(o[i][j]!=1)
                    dp[j] += dp[j-1];
                else 
                    dp[j] = 0;
            }
        }
        return dp[o[0].length-1];
    }
}