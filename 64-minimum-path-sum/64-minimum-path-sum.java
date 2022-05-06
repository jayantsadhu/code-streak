class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid[0].length;
        int cost[] = new int[n];
        cost[0] = grid[0][0];
        for(int i=1 ; i<n ; i++)
            cost[i] = cost[i-1] + grid[0][i];
        
        System.out.println(Arrays.toString(cost));
        for(int j=1 ; j<grid.length ; j++){
            cost[0] += grid[j][0]; 
            for(int i=1 ; i<n ; i++)
                cost[i] = grid[j][i] + Math.min(cost[i], cost[i-1]);
        }
        return cost[n-1];
    }
}