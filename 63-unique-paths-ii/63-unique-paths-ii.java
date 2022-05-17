class Solution {
    public int uniquePathsWithObstacles(int[][] o) {
        int n = o.length;
        int m = o[0].length;
        if(o[n-1][m-1]==1 || o[0][0]==1) return 0;
        
        int res[][] = new int[n][m];
        int i;
        for(i=0 ; i<n && o[i][0]==0 ; i++)
                res[i][0] = 1;
        
        if(m==1 && i<n) return 0;
        
        for(i=0 ; i<m && o[0][i]==0 ; i++)
                res[0][i] = 1;
        
        if(n==1 && i<m) return 0;
        
        for(i=1 ; i<n ; i++){
            for(int j=1 ; j<m ; j++){
                if(o[i][j]==1)
                    res[i][j] = 0;
                else 
                    res[i][j] = res[i-1][j] + res[i][j-1];
            }
        }
        return res[n-1][m-1];
    }
}