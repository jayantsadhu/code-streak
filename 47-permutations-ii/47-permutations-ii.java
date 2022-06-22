class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0)+1);
        int nms[][] = new int[map.size()][2];
        int i = 0;
        for(Integer key : map.keySet()){
            nms[i][0] = key;
            nms[i++][1] = map.get(key);
        }
        backTrack(nums.length, nms, ans, new ArrayList<>());
        return ans;
    }
    public void backTrack(int n, int[][] nms, List<List<Integer>> ans, List<Integer> list){
        if(list.size()==n){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0 ; i<nms.length ; i++){
            if(nms[i][1]==0) continue;
            list.add(nms[i][0]);
            nms[i][1]--;
            backTrack(n, nms, ans, list);
            nms[i][1]++;
            list.remove(list.size()-1);
        }
    }
}