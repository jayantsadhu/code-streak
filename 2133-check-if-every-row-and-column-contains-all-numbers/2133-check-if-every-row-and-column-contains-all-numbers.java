class Solution {
    public boolean checkValid(int[][] m) {
        for(int i=0 ; i<m.length ; i++){
            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();
            for(int j=0 ; j<m[0].length ; j++){
                if(!row.add(m[i][j]) || !col.add(m[j][i]))
                    return false;
            }
        }
        return true;
    }
}