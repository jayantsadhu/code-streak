class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for(int num : nums)
            set.add(num);
        for(Integer ele : set){
            if(set.contains(ele-1)) continue;
            int count = 1;
            while(set.contains(ele+1)){
                count++;
                ele++;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}