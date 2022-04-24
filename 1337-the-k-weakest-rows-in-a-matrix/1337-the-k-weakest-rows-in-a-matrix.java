class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length;
        int arr[][] = new int[n][2];
        for(int i=0 ; i<n ; i++){
            arr[i][0] = numOfOnes(mat[i]);
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> (a[0]-b[0]));
        int res[] = new int[k];
        for(int i=0 ; i<k ; i++){
            res[i] = arr[i][1];
        }
        return res;
    }
    public int numOfOnes(int arr[]){
        int l = 0;
        int r = arr.length-1;
        int count = 0;
        while(l<=r){
            int m = l + (r-l)/2;
            if(arr[m]==1){
                count = m+1;
                l = m+1;
            }
            else
                r = m-1;
        }
        return count;
    }
}