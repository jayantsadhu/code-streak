class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        helper(candidates, 0, target, new ArrayList(), res);
        return res;
    }
    public void helper(int[] c, int idx, int target, List<Integer> path, List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList(path));
            return;
        }
        for(int i=idx ; i<c.length ; i++) {
            if(c[i]<=target){
                path.add(c[i]);
                helper(c, i, target-c[i], path, res);
                path.remove(path.size()-1);
            }
        }
    }
}