class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length+1][amount+1];
        for(int i=0 ; i<coins.length ; i++)
            Arrays.fill(dp[i], -1);
        int val = helper(coins.length-1, coins, amount, dp);
        return val!=Integer.MAX_VALUE-1? val : -1;
    }
    public int helper(int i, int coins[], int amt, int dp[][]){
        if(amt==0) return 0;
        if(i<0) return Integer.MAX_VALUE-1;
        if(dp[i][amt]!=-1)
            return dp[i][amt];
        if(coins[i]>amt)
            return dp[i][amt] = helper(i-1, coins, amt, dp);
        return dp[i][amt] = Math.min(helper(i-1, coins, amt, dp), 
                                     helper(i, coins, amt-coins[i], dp)+1);
    }
}