class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0);
    }
    public boolean solve(char[][] b, int i){
        for(int x=0 ; x<b.length ; x++){
            for(int y=0 ; y<b[0].length ; y++){
                if(b[x][y]=='.'){
                    for(char c='1' ; c<='9' ; c++){
                        if(isValid(b, x, y, c)){
                            b[x][y] = c;
                            if(solve(b, x))
                                return true;
                            else 
                                b[x][y] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValid(char[][] b, int i, int j, char c){
        int x, y;
        for(x=0 ; x<b.length ; x++)
            if(b[x][j]!='.' && b[x][j]==c)
                return false;
        for(y=0 ; y<b[0].length ; y++)
            if(b[i][y]!='.' && b[i][y]==c)
                return false;
        
        x = (i/3)*3;
        for(; x<(i/3+1)*3 ; x++){
            y = (j/3)*3;
            for(; y<(j/3+1)*3 ; y++){
                if(b[x][y]!='.' && b[x][y]==c)
                    return false;
            }
        }
        return true;
    }
}
