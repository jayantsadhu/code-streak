class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> grid = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<n ; i++) sb.append('.');
        for(int i=0 ; i<n ; i++) grid.add(sb.toString());
        solve(0, n, grid, res, sb);
        return res;
    }
    public void solve(int row, int n, List<String> grid, List<List<String>> res, 
                        StringBuilder sb){
        if(row==n){
            System.out.println(grid);
            res.add(new ArrayList<>(grid));
            return;
        }
        for(int j=0 ; j<n ; j++){
            if(!isValid(grid, row, j, n)) continue;
            
            grid.set(row, sb.replace(j, j+1, "Q").toString());
            sb.replace(j, j+1, ".");
            solve(row+1, n, grid, res, sb);
            grid.set(row, sb.toString());
        }
    }
    public boolean isValid(List<String> grid, int i, int j, int n){
        for(int k=0 ; k<i ; k++)
            if(grid.get(k).charAt(j)=='Q')
                return false;
        for(int k=1 ; k<n ; k++){
            if(i>=k && j>=k && grid.get(i-k).charAt(j-k)=='Q')
                return false;
            if(i>=k && j+k<n && grid.get(i-k).charAt(j+k)=='Q')
                return false;
        }
        return true;
    }
}