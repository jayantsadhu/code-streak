class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0 ; i<nums.length ; i++){
            map.put(nums[i], i);
        }
        int idx = -1;
        for(int i=0; i<operations.length ; i++){
            idx = map.get(operations[i][0]);
            map.put(operations[i][1], idx);
            map.remove(operations[i][0]);
        }
        for(Integer key : map.keySet())
            nums[map.get(key)] = key;
        return nums;
    }
}