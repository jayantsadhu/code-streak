import java.util.*;
class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        SortedMap<Integer, Integer> set = new TreeMap<>(Collections.reverseOrder());
        set.put(nums[n-1], 1);
        dp[n-1] = nums[n-1];
        for(int i=n-2 ; i>=0 ; i--){
            if(i>=n-k){
                dp[i] = set.firstKey() + nums[i];
                set.put(dp[i], set.getOrDefault(dp[i], 0)+1);
            }
            else {
                dp[i] = nums[i] + set.firstKey();
                if(set.get(dp[i+k])>1)
                    set.put(dp[i+k], set.get(dp[i+k])-1);
                else set.remove(dp[i+k]);
                set.put(dp[i], set.getOrDefault(dp[i], 0)+1);
                
            }
        }
        return dp[0];
    }
}