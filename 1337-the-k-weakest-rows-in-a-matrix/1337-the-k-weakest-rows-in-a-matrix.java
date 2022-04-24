class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length;
        int arr[][] = new int[n][2];
        for(int i=0 ; i<n ; i++){
            int j = 0;
            while(j<mat[0].length && mat[i][j]==1){
                arr[i][0]++;
                j++;
            }
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> (a[0]-b[0]));
        int res[] = new int[k];
        for(int i=0 ; i<k ; i++){
            res[i] = arr[i][1];
        }
        return res;
    }
}