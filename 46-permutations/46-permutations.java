class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, new ArrayList<>(), res, new HashSet<>());
        return res;
    }
    public void helper(int nums[], List<Integer> list, 
                       List<List<Integer>> res, Set<Integer> set){
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0 ; i<nums.length ; i++){
            if(set.contains(i)) continue;
            set.add(i);
            list.add(nums[i]);
            helper(nums, list, res, set);
            list.remove(list.size()-1);
            set.remove(i);
        }
    }
}