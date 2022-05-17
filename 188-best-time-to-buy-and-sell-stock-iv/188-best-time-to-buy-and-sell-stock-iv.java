class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(k>=n/2){
            int profit = 0;
            for(int i=0 ; i<n-1 ; ){
                while(i<n-1 && prices[i+1]<=prices[i]) i++;
                int buy = prices[i];
                while(i<n-1 && prices[i+1]>=prices[i]) i++;
                profit += prices[i]-buy;
            }
            return profit;
        }
        int dp[][][] = new int[2][n+1][k+1];
        for(int i=0; i<=prices.length ; i++){
            Arrays.fill(dp[0][i], -1);
            Arrays.fill(dp[1][i], -1);
        }
        return helper(0, k, 0, prices, dp);
    }
    public int helper(int i, int k, int isBought, int[] prices, int dp[][][]) {
        if(i==prices.length || k==0) return 0;
        if(dp[isBought][i][k]!=-1)
            return dp[isBought][i][k];
        int x = helper(i+1, k, isBought, prices, dp);
        if(isBought==1){
            return dp[isBought][i][k] = Math.max(x, 
                            helper(i+1, k-1, 0, prices, dp)+prices[i]);
        }
        return dp[isBought][i][k] = Math.max(x, 
                            helper(i+1, k, 1, prices, dp)-prices[i]);
    }
}