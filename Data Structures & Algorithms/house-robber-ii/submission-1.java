class Solution {
    int dp[];
    
    public int rob(int[] nums) {
        int n = nums.length;
        
        // Handle the edge case where there is only 1 house
        if (n == 1) {
            return nums[0];
        }
        
        dp = new int[n];

        // First pass: rob from index 0 to n-2 (skip the last house)
        Arrays.fill(dp, -1);
        int skip_last_idx = dfs(nums, 0, n - 1);

        // Second pass: rob from index 1 to n-1 (skip the first house)
        // We must reset the DP array because the boundaries have changed
        Arrays.fill(dp, -1);
        int skip_1st_idx = dfs(nums, 1, n);

        return Math.max(skip_1st_idx, skip_last_idx);
    }

    public int dfs(int[] nums, int i, int n) {
        // Fix: Use >= to prevent accessing dp[n] or out-of-bounds indices
        if (i >= n) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int skip = dfs(nums, i + 1, n);
        int steal = nums[i] + dfs(nums, i + 2, n);

        dp[i] = Math.max(skip, steal);

        return dp[i];
    }
}