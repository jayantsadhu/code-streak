class Solution {
    public boolean isValidSudoku(char[][] b) {
        Set<String> set = new HashSet<>();
        for(int i=0 ; i<b.length ; i++){
            for(int j=0 ; j<b[0].length ; j++){
                if(b[i][j]=='.') continue;
                String str = ","+b[i][j]+",";
                if(!set.add(i+str) || !set.add(str+j) || !set.add(i/3+str+j/3))
                    return false;
            }
        }
        return true;
    }
}