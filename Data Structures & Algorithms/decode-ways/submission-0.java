class Solution {
    int dp[];
    
    public int numDecodings(String s) {
        int n = s.length();
        dp = new int[101];
        Arrays.fill(dp, -1); 
        return dfs(s, 0, n);
    }
    
    public int dfs(String s, int idx, int n) {
        if (idx >= n) {
            return 1; 
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        if (s.charAt(idx) == '0') {
            return dp[idx] = 0;
        }
        
        int if_take_one = dfs(s, idx + 1, n);
        int if_take_two = 0;
        
        if (idx + 1 < n) {
            if (s.charAt(idx) == '1' || (s.charAt(idx) == '2' && s.charAt(idx + 1) <= '6')) {
                if_take_two = dfs(s, idx + 2, n);
            }
        }
        
        return dp[idx] = if_take_one + if_take_two;
    }
}