class Solution {
    
    //     recursion
        public int climb(int[] cost, int n)
        {
            if(n==1 || n==0)
                return cost[n];
            
            int ans = Integer.MAX_VALUE;
            
            ans = Math.min(climb(cost,n-1), climb(cost,n-2)) + cost[n];
            
            return ans;
        }
        
        
        
        
    //     memoization
        public int climb_memo(int[] cost, int n, int[] dp)
        {
            if(n==1 || n==0)
                return dp[n] = cost[n];
            
            if(dp[n] >0)
                return dp[n];
            
            int ans = Integer.MAX_VALUE;
            
            ans = Math.min(climb_memo(cost,n-1,dp), climb_memo(cost,n-2,dp)) + cost[n];
            
            return dp[n] = ans;
        }
        
        
        
        
        
    //     Tabulation
         public int climb_tab(int[] cost, int N, int[] dp)
         {
             for(int n = 0;n<=N;n++)
             {
                if(n==1 || n==0)
                {
                   dp[n] = cost[n];
                    continue;
                }
    
                int ans = Integer.MAX_VALUE;
    
                ans = Math.min(dp[n-1],dp[n-2])+cost[n]; //Math.min(climb_memo(cost,n-1,dp), climb_memo(cost,n-2,dp)) + cost[n];
    
                dp[n] = ans;
            }
             
             
             return dp[N];
         }
        
        
        
        
        
        
        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length;
            int[] dp = new int[n];
            
            // int ans = Math.min(climb(cost,n-1),climb_memo(cost));
            // int ans = Math.min(climb_memo(cost,n-1,dp),climb_memo(cost,n-2,dp));
            int ans = Math.min(climb_tab(cost,n-1,dp),climb_tab(cost,n-2,dp));
            
            return ans;
        }
    }