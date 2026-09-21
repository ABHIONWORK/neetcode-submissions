class Solution {
    int dp[][];
    public String longestPalindrome(String s) {
        dp = new int [1001][1001];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        // Arrays.fill(dp , -1);
        if(s.length() == 1){
            return s;
        }
        int maxLen = Integer.MIN_VALUE;
        int si = 0;

        for(int i = 0; i<s.length(); i++){
            for(int j = i; j<s.length(); j++){
                if(isPlaindrome(s , i , j)){
                    // maxLen = Math.max(maxLen , j - i + 1);
                    int currLen = j - i + 1;

                    if(currLen > maxLen){
                        maxLen = currLen;
                        si = i;
                    }
                }
            }
        }


        return s.substring(si , si + maxLen);
    }


        public boolean isPlaindrome(String s, int i, int j) {
            // Base case: 1 or 0 character strings are palindromes
            if (i >= j) {
                return true; 
            }
            
            // Check memoized results (using 'dp' instead of 't')
            if (dp[i][j] != -1) {
                return dp[i][j] == 1; // Returns true if 1, false if 0
            }
            
            // Calculate and store the result
            if (s.charAt(i) == s.charAt(j)) {
                boolean isPal = isPlaindrome(s, i + 1, j - 1);
                dp[i][j] = isPal ? 1 : 0;
                return isPal;
            } else {
                dp[i][j] = 0;
                return false;
            }
        }
}

