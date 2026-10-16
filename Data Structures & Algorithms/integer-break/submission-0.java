class Solution {
    public int integerBreak(int n) {
        if(n == 2){
            return 1;
        }        

        if( n== 3){
            return 2;
        }

        int dp[] = new int[n+1];


        return dfs(n , dp);

    }

    public int dfs(int target , int [] dp){
        if( target == 1){
            return 1;
        }

        if(dp[target]!= 0){
            return dp[target];
        }

        int maxprod = 0;

        for(int i = 1; i<target ; i++){
            int currmax = i * (Math.max(target - i , dfs(target - i , dp)));
            maxprod = Math.max(currmax , maxprod);
        }

        return dp[target] = maxprod;
           
    }
}