class Solution {
    
    //     Recursion
        public int jump(int n)
        {
            if(n == 0 || n==1)
            {
                return 1;
            }
            
            int count =0;
            for(int i=1;i<=2 ;i++)
            {
                if(n-i>=0)
                count += jump(n-i);
            }
            
            return count; 
        }
        
        
        
        
    //     Memoization
        public int jump_memo(int n,int[] dp)
        {
            if(n == 0 || n==1)
            {
                return dp[n] = 1;
            }
            
            if(dp[n] >0)
                return dp[n];
            
            int count =0;
            for(int i=1;i<=2 ;i++)
            {
                if(n-i>=0)
                count += jump_memo(n-i,dp);
            }
            
            return dp[n] = count; 
        }
        
        
        
        
        
    //     Tabulation
        public int jump_tab(int N, int[] dp)
        {
            for(int n = 0;n<=N;n++)
            {
                if(n == 0 || n==1)
                {
                    dp[n] = 1;
                    continue;
                }
    
                int count =0;
                for(int i=1;i<=2 ;i++)
                {
                    if(n-i>=0)
                    count += dp[n-i];//jump_memo(n-i,dp);
                }
    
                dp[n] = count;
            }
            
            return dp[N];
        }
        
        
        
        
        public int climbStairs(int n) {
            
            int[] dp = new int[n+1];
            
            // int ans = jump(n);
            // int ans = jump_memo(n,dp);
            int ans = jump_tab(n,dp);
            
            return ans;
        }
    }