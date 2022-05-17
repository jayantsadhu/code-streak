class Solution {
    public int maximalSquare(char[][] matrix) {
        int size = 0;
        int l = matrix.length;
        int n = matrix[0].length;
        int m[][] = new int[l][n];
        for(int i=0 ; i<l ; i++)
            for(int j=0 ; j<n ; j++)
                m[i][j] = matrix[i][j]-'0';
        
        for(int i=0 ; i<l ; i++){
            for(int j=0 ; j<n ; j++){
                if(m[i][j]==1 && i>0 && j>0){
                    m[i][j] = Math.min(m[i-1][j-1], 
                                Math.min(m[i-1][j], m[i][j-1]))+1;
                }
                size = Math.max(size, m[i][j]);
            }
        }
        return size*size;
    }
}