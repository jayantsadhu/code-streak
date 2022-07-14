class Solution {
    public boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length;
        boolean vis[] = new boolean[n];
        int sum = 0;
        for(int length : matchsticks)
            sum += length;
        if(sum % 4 != 0)
            return false;
        
        return helper(0, n, 0, matchsticks, 0, sum/4, vis);
    }
    
    public boolean helper(int idx, int n, int k, int[] m, int curSum, int sum,
                          boolean[] vis){
        
        if(curSum == sum){
            k++;
            if(k==4) return true;
            return helper(0, n, k, m, 0, sum, vis);
        }
        
        for(int i=idx ; i<n ; i++){
            if(vis[i] || curSum+m[i]>sum) continue;
            vis[i] = true;
            if(helper(i+1, n, k, m, curSum+m[i], sum, vis))
                return true;
            vis[i] = false;
        }
        return false;
    }
}