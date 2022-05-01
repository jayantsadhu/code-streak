class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer val : candidates)
            map.put(val, map.getOrDefault(val, 0)+1);
        int c[][] = new int[map.size()][2];
        int i = 0;
        for(Integer key : map.keySet()){
            c[i][0] = key;
            c[i++][1] = map.get(key);
        }
        getCombinations(c, 0, target, new ArrayList<>(), res);
        return res;
    }
    public void getCombinations(int c[][], int idx, int target, List<Integer> path, 
                                                            List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=idx ; i<c.length ; i++){
            if(c[i][1]==0) continue;
            if(c[i][0]<=target){
                path.add(c[i][0]);
                c[i][1] -= 1;
                getCombinations(c, i, target-c[i][0], path, res);
                c[i][1] += 1;
                path.remove(path.size()-1);
            }
        }
    }
}