class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int moves = 0;
        int l = 0;
        int h = nums.length-1;
        while(l<h){
            moves += nums[h]-nums[l];
            l++; h--;
        }
        return moves;
    }
}