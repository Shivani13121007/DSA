class Solution {
    
    //     Recursion
        public int path(int m, int n, int i, int j)
        {
            if( i== m-1 && j== n-1) // instead of making recursive calls from 0,0 we can also make the recursive calls from m-1 and n-1 till 0,0. then base case will be if(m==0 && n==0) while decreamenting.
            {
                return 1;
            }
            
            int[][] dirs = {{0,1},{1,0}};
            int count= 0;
            for(int[] dir : dirs)
            {
                int r = dir[0] + i;
                int c = dir[1] + j;
                
                if(r>=0 && r<m && c>=0 && c<n)
                {
                    count += path(m,n,r,c);
                }
            }
            
            return count;
        }
        
        
    //     Memoization
        public int path_memo(int m, int n, int i, int j,int[][] dp)
        {
            if( i== m-1 && j== n-1)
            {
                return dp[i][j] = 1;
            }
            
            if(dp[i][j] > 0)
            {
                return dp[i][j];
            }
            
            int[][] dirs = {{0,1},{1,0}};
            int count= 0;
            for(int[] dir : dirs)
            {
                int r = dir[0] + i;
                int c = dir[1] + j;
                
                if(r>=0 && r<m && c>=0 && c<n)
                {
                    count += path_memo(m,n,r,c,dp);
                }
            }
            
            return dp[i][j] = count;
        }
        
        
        
        
        
    //     Sir ka code
        public int path_memo_sir(int er, int ec, int i, int j,int[][] dp)
        {
            if( er == i && ec==j)
            {
                return dp[i][j] = 1;
            }
            
            if(dp[er][ec] != 0)
            {
                return dp[er][ec];
            }
            
            int[][] dirs = {{0,-1},{-1,0}};
            int count= 0;
            for(int[] dir : dirs)
            {
                int r = dir[0] + er;
                int c = dir[1] + ec;
                
                if(r>=0 && r<dp.length && c>=0 && c<dp[0].length)
                {
                    count += path_memo_sir(r,c,i,j,dp);
                }
            }
            
            return dp[er][ec] = count;
        }
        
         public int path_memo_sir2(int er, int ec, int sr, int sc,int[][] dp)
        {
            if( er == sr && ec==sc)
            {
                return dp[sr][sc] = 1;
            }
            
            if(dp[sr][sc] != 0)
            {
                return dp[sr][sc];
            }
            
            int[][] dirs = {{0,1},{1,0}};
            int count= 0;
            for(int[] dir : dirs)
            {
                int r = dir[0] + sr;
                int c = dir[1] + sc;
                
                if(r>=0 && r<dp.length && c>=0 && c<dp[0].length)
                {
                    count += path_memo_sir2(er,ec,r,c,dp);
                }
            }
            
            return dp[sr][sc] = count;
        }
        
        
        
        
        
        
        
        
    //     Tabulation
        public int path_tab(int m, int n,int[][] dp)
        {
            
            for(int i = m-1;i>=0;i--)
            {
                for(int j = n-1;j>=0;j--)
                {
                    if( i== m-1 && j== n-1)
                    {
                        dp[i][j] = 1;
                        continue;
                    }
                    
                    int[][] dirs = {{0,1},{1,0}};
                    int count= 0;
                    
                    for(int[] dir : dirs)
                    {
                        int r = dir[0] + i;
                        int c = dir[1] + j;
    
                        if(r>=0 && r<m && c>=0 && c<n)
                        {
                            count += dp[r][c]; //path_memo(m,n,r,c,dp);
                        }
                    }
    
                    dp[i][j] = count;
                }
            }
            
            return dp[0][0];
            
        }
        
        
        public void display(int[][] dp)
        {
            for(int i=0;i<dp.length;i++)
            {
                for(int j=0;j<dp[0].length;j++)
                {
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println();
            }
        }
        
        
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            
           // int ans = path(m,n,0,0);
          // int ans = path_memo(m,n,0,0,dp);
            // int ans = path_memo_sir2(m-1,n-1,0,0,dp);
           
            int ans = path_tab(m,n,dp);
             display(dp);
            return ans;
        }
    }