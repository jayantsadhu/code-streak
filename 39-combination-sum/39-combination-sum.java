class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        solve(candidates, 0, 0, target, new ArrayList<>(), res);
        return res;
    }
    public void solve(int[] c, int i, int s, int t, List<Integer> list,
                      List<List<Integer>> res){
        if(i>=c.length || s>t)
            return;
        if(s==t){
            res.add(new ArrayList(list));
            return;
        }
        list.add(c[i]);
        solve(c, i, s+c[i], t, list, res);
        list.remove(list.size()-1);
        solve(c, i+1, s, t, list, res); 
    }
}