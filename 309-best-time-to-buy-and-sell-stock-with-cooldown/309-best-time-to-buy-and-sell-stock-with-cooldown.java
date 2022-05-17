class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n<=0) return 0;
        int s0[] = new int[n];
        int s1[] = new int[n];
        int s2[] = new int[n];
        s0[0] = 0;          //no stock
        s1[0] = -prices[0];  //inhand
        s2[0] = 0;           //sold
        
        for(int i=1 ; i<n ; i++){
            s0[i] = Math.max(s0[i-1], s2[i-1]);
            s1[i] = Math.max(s1[i-1], s0[i-1]-prices[i]);
            s2[i] = s1[i] + prices[i];
        }
            
        return Math.max(s2[n-1], s0[n-1]);
    }
}