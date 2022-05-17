class Solution {
    public int maxProfit(int[] prices) {
        
        int dp[][] = new int[2][prices.length];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);
            
        return helper(0, 1, prices, dp);
    }
    
    public int helper(int i, int buying, int p[], int dp[][]){
        if(i>=p.length) return 0;
        if(dp[buying][i]!=-1) return dp[buying][i];
        
        int cooldown = helper(i+1, buying, p, dp);
        if(buying==1){
            return dp[buying][i] = Math.max(helper(i+1, 1^buying, p, dp)-p[i],
                                            cooldown);
        }
        return dp[buying][i] = Math.max(helper(i+2, 1^buying, p, dp)+p[i], cooldown);
    }
}