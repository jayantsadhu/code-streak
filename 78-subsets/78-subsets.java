class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int max = (1<<n) - 1;
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0 ; i<=max ; i++){
            List<Integer> list = new ArrayList<>();
            int j = 0;
            while(j<n){
                if(((i>>j) & 1)==1)
                    list.add(nums[j]);
                j++;
            }
            res.add(list);
        }
        return res;
    }
}