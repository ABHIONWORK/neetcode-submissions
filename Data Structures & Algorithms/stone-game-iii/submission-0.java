class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int dp[] = new int [n + 1];

        for(int i = n-1; i >= 0; i--){
            // ek lelo
            dp[i] = stoneValue[i] - dp[i+1];
            
            // 2 lelo
            if(i+2 <= n){
                dp[i] = Math.max(dp[i] , stoneValue[i] + stoneValue[i+1] - dp[i+2]);
            }

            //3 lelo
            if(i+3 <= n){
                dp[i] = Math.max(dp[i] ,stoneValue[i]+stoneValue[i+1]+stoneValue[i+2] - dp[i+3]);
            }

        }

        if(dp[0] < 0){
            return "Bob";
        }else if (dp[0] > 0){
            return "Alice";
        }


        return "Tie";
    }
}