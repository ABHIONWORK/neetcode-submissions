class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        int dp[][] = new int [m + 1][n + 1];
        for(int arr[] : dp){
            Arrays.fill(arr , -1);
        }

        if(n>m){
            return 0;
        }

        return dfs(s , t , 0 , 0 , dp);
    }

    public int dfs(String s , String t , int i , int j , int [][] dp){


        if(j == t.length()){
            return 1;
        }

        if(i == s.length()){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int res = dfs(s , t, i+1 , j , dp);
        if(s.charAt(i) == t.charAt(j)){
            res+=dfs(s , t, i+1 , j+1 , dp);
        }
        return dp[i][j] =  res;
    }
}
