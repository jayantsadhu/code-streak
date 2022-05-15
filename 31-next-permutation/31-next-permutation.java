class Solution {
    public static void nextPermutation(int[] nums) {
        
        int i = nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1])
            i--;
        revSubArray(nums,i+1,nums.length-1);
        
        if(i<0)
            return;
        
        int j=i+1;
        while(nums[i]>=nums[j])
                j++;
        swap(nums,i,j);
                
    }
    static void revSubArray(int[] arr, int first, int last){
        
        int i=first,j=last;
        while(i<j){
            swap(arr,i,j);
            i++;j--;
        }
    }
    static void swap(int[] arr,int i, int j){
        
        int ele = arr[i];
        arr[i] = arr[j];
        arr[j] = ele;
    }
}