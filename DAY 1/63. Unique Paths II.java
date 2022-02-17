class Solution {
    
    //     Recursion
    public int path(int[][] grid, int sr, int sc, int er, int ec)
    {
        if(sr == er && sc== ec)
        {
            return 1;
        }
        
        int[][] dirs = {{0,1},{1,0}};
        int count =0;
        for(int[] dir : dirs)
        {
            int r = dir[0]+ sr;
            int c = dir[1]+ sc;
            
            if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c] != 1)
            {
                count += path(grid,r,c,er,ec);
            }
        }
        
        return count;
    }
    
    

    //     Memoization
    public int path_memo(int[][] grid, int sr, int sc, int er, int ec,int[][] dp)
    {
        if(sr == er && sc== ec)
        {
            return dp[er][ec] = 1;
        }
        
        if(dp[sr][sc] > 0 )
            return dp[sr][sc];
        
        int[][] dirs = {{0,1},{1,0}};
        int count =0;
        for(int[] dir : dirs)
        {
            int r = dir[0]+ sr;
            int c = dir[1]+ sc;
            
            if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c] != 1)
            {
                count += path_memo(grid,r,c,er,ec,dp);
            }
        }
        
        return dp[sr][sc] = count;
    }
    
    
    
//     Tabulation
    public int path_tab(int[][] grid, int SR, int SC, int ER, int EC,int[][] dp)
    {
        
        for(int sr = ER;sr>=0;sr--)
        {
            for(int sc = EC; sc>=0;sc--)
            {
                if(sr == ER && sc == EC)
                {
                    dp[sr][sc] = 1;
                    continue;
                }
                
                 int[][] dirs = {{0,1},{1,0}};
                int count =0;
                for(int[] dir : dirs)
                {
                    int r = dir[0]+ sr;
                    int c = dir[1]+ sc;

                    if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c] != 1)
                    {
                        count += dp[r][c];  //path_tab(grid,r,c,er,ec,dp);
                    }
                }
        
                dp[sr][sc] = count;  
            }
        }
        
        return dp[SR][SC];       
    }
    

    
    
    
    
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] dp = new int[m][n];
        
        
        int ans = 0;
        if(obstacleGrid[0][0] != 1)
            // ans = path(obstacleGrid,0,0,m-1,n-1);
            // ans = path_memo(obstacleGrid,0,0,m-1,n-1,dp);
            ans = path_tab(obstacleGrid,0,0,m-1,n-1,dp);
        
        return ans;
    }
}