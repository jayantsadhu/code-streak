class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(k==1) return true;
        int n = nums.length;
        boolean vis[] = new boolean[n];
        Arrays.sort(nums);
        int sum = 0;
        for(int length : nums)
            sum += length;
        if(sum % k != 0 || nums[n-1]>sum/k)
            return false;
        
        return helper(0, n, k, nums, 0, sum/k, vis);
    }
    
    public boolean helper(int idx, int n, int k, int[] m, int curSum, int sum,
                          boolean[] vis){
        
        if(curSum == sum){
            if(k==2) return true;
            return helper(0, n, k-1, m, 0, sum, vis);
        }
        
        for(int i=idx ; i<n ; i++){
            if(vis[i] || curSum+m[i]>sum || (i>0&&m[i-1]==m[i]&&!vis[i-1]))
                continue;
            vis[i] = true;
            if(helper(i+1, n, k, m, curSum+m[i], sum, vis))
                return true;
            vis[i] = false;
        }
        return false;
    }
}