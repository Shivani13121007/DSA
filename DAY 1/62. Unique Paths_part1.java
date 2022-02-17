class Solution {
    
    //     when you started from end
        
    //     Recursion
        public int path(int er, int ec, int sr, int sc, int m, int n)
        {
            if(er == sr && ec == sc)
                return 1;
            
            int count=0;
            int[][] dirs = {{0,-1},{-1,0}};
            
            for(int[] dir : dirs)
            {
                int r = dir[0] + er;
                int c = dir[1] + ec;
                
                if(r>=0 && r<m && c>=0 && c<n)
                {
                    count+=path(r,c,sr,sc,m,n);
                }
            }
            
            return count;
        }
        
        public int path_memo(int er, int ec, int sr, int sc, int m, int n,int[][] dp)
        {
            if(er == sr && ec == sc)
                return dp[er][ec] = 1;
            
            
            if(dp[er][ec] != 0)
                return dp[er][ec];
            
            int count=0;
            int[][] dirs = {{0,-1},{-1,0}};
            
            for(int[] dir : dirs)
            {
                int r = dir[0] + er;
                int c = dir[1] + ec;
                
                if(r>=0 && r<m && c>=0 && c<n)
                {
                    count+=path_memo(r,c,sr,sc,m,n,dp);
                }
            }
            
            return dp[er][ec] = count;
        }
        
        
        public int path_tab(int ER, int EC, int sr, int sc,int[][] dp)
        {
            for(int er = sr;er<=ER;er++)
            {
                for(int ec = sc;ec<=EC;ec++)
                {
                    if(er == sr && ec == sc)
                    {
                        dp[er][ec] = 1;
                        continue;
                    }
    
                    int count=0;
                    int[][] dirs = {{0,-1},{-1,0}};
    
                    for(int[] dir : dirs)
                    {
                        int r = dir[0] + er;
                        int c = dir[1] + ec;
    
                        if(r>=0 && r<dp.length && c>=0 && c<dp[0].length)
                        {
                            count+= dp[r][c];//path_tab(r,c,sr,sc,m,n,dp);
                        }
                    }
    
                    dp[er][ec] = count;
                }
            }
            
            return dp[ER][EC];
        }
        
        
        public void display(int[][] dp)
        {
            for(int i=0;i<dp.length;i++)
            {
                for(int j=0;j<dp[0].length;j++)
                {
                    System.out.print(dp[i][j]);
                }
                System.out.println();
            }
            
        }
        
        public int uniquePaths(int m, int n) {
            
            int[][] dp = new int[m][n];
            
            // int ans = path(m-1,n-1,0,0,m,n);
            // int ans = path_memo(m-1,n-1,0,0,m,n,dp);
            // display(dp);
            
            int ans = path_tab(m-1,n-1,0,0,dp);
            
            return ans;
        }
    }