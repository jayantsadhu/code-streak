class Solution {
    public boolean isValidSudoku(char[][] b) {
        if(!areRowsValid(b) || !areColumnsValid(b))
            return false;
        for(int i=0 ; i<b.length ; i+=3){
            for(int j=0 ; j<b[0].length ; j+=3){
                Set<Character> set = new HashSet<>();
                for(int r=i ; r<i+3 ; r++){
                    for(int c=j ; c<j+3 ; c++){
                        if(b[r][c]=='.') continue;
                        if(set.contains(b[r][c]))
                            return false;
                        else 
                            set.add(b[r][c]);
                    }
                }
            }
        }
        return true;
    }
    public boolean areRowsValid(char [][]b){
        for(int i=0 ; i<b.length ; i++){
            Set<Character> set = new HashSet<>();
            for(int j=0 ; j<b[0].length ; j++){
                if(b[i][j]=='.') continue;
                if(set.contains(b[i][j]))
                    return false;
                else 
                    set.add(b[i][j]);
            }
        }
        return true;
    }
    public boolean areColumnsValid(char [][]b){
        for(int j=0 ; j<b[0].length ; j++){
            Set<Character> set = new HashSet<>();
            for(int i=0 ; i<b.length ; i++){
                if(b[i][j]=='.') continue;
                if(set.contains(b[i][j]))
                    return false;
                else 
                    set.add(b[i][j]);
            }
        }
        return true;
    }
}