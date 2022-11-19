class Solution {
    public int minimizeArrayValue(int[] nums) {
        long sum = 0;
        int n = nums.length;
        for(int i=0 ; i<n ; i++){
            sum += nums[i];
        }
        long lo = (sum + n - 1)/n;
        long hi = sum;
        long res = 0;
        while(lo<=hi){
            long mi = (lo+hi)>>1;
            if(isPossible(nums, mi)){
                res = mi;
                hi = mi-1;
            }
            else
                lo = mi+1;
                
        }
        return (int)res;
    }
    private boolean isPossible(int[] nums, long mi){
        long space = 0;
        for(int i=0 ; i<nums.length ; i++){
            if(nums[i]-space>mi) return false;
            else {
                long extra = mi - nums[i];
                space += extra;
            }
        }
        return true;
    }
}