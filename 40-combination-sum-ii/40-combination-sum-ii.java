class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int m[] = new int[51];
        for(Integer num : candidates)
            m[num]++;
        List<List<Integer>> res = new ArrayList<>();
        solve(m, 1, target, new ArrayList<>(), res);
        return res;
    }
    public void solve(int[] m, int i, int t, List<Integer> path, 
                      List<List<Integer>> res)
    {
        if(t<0) return;
        if(t==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int idx=i ;  idx<=50 ; idx++){
            if(m[idx]==0) continue;
            m[idx]--;
            path.add(idx);
            solve(m, idx, t-idx, path, res);
            m[idx]++;
            path.remove(path.size()-1);
        }
    }
}