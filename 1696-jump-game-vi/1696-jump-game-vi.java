import java.util.*;
class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        
        Deque<Integer> dq = new LinkedList<>();
        
        dp[0] = nums[0];
        dq.add(0);
        for(int i=1 ; i<n ; i++){
            if(dq.peekFirst()<i-k) 
                dq.pollFirst();
            dp[i] = dp[dq.peekFirst()] + nums[i];
            while(!dq.isEmpty() && dp[dq.peekLast()]<=dp[i])
                dq.pollLast();
            dq.add(i);
            
        }
        return dp[n-1];
    }
}