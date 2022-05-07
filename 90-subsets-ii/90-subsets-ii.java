class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int keyVal[][] = new int[map.size()][2];
        int l = 0;
        for(Integer key : map.keySet()){
            keyVal[l][0] = key;
            keyVal[l++][1] = map.get(key);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for(int k=0; k<=nums.length ; k++){
            backtrack(0, k, keyVal, new ArrayList<>(), res);
        }
        return res;
    }
    public void backtrack(int idx, int k, int keyVal[][], List<Integer> list,
                                                    List<List<Integer>> res){
        
        if(list.size()==k){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=idx ; i<keyVal.length ; i++){
            if(keyVal[i][1]==0) continue;
            list.add(keyVal[i][0]);
            keyVal[i][1]--;
            backtrack(i, k, keyVal, list, res);
            list.remove(list.size()-1);
            keyVal[i][1]++;
        }
    }
}