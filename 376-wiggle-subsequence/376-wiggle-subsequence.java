class Solution {
    public int wiggleMaxLength(int[] nums) {
        int i1;
        int n = nums.length;
        int count = 1;
        int i = 0;
        while(i<n-1 && nums[i+1]==nums[i]) i++;
        for( ; i<n-1 ;){
            i1 = i;
            while(i<n-1 && nums[i+1]>=nums[i]) i++;
            if(i!=i1) count++;
            i1 = i;
            while(i<n-1 && nums[i+1]<=nums[i]) i++;
            if(i!=i1) count++;
        }
        return count;
    }
}