class Solution {
    public int tribonacci(int n) {

        int dp[] = new int[n + 1];
        if (n == 0 || n == 1){
            return n;
        }else if (n == 2){
            return 1;
        }

        return calTri(n , dp);

    }

    public int calTri(int n , int dp[]){
        if (n == 0 || n == 1){
            return n;
        }else if ( n == 2){
            return 1;
        }

        if(dp[n]!=0){
            return dp[n];
        }

        dp[n] = calTri(n-1 , dp) + calTri(n-2 , dp) + calTri(n-3 , dp);

        return dp[n];
    }
}