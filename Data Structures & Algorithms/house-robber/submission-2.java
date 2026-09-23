class Solution {
    int dp[];
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp , -1);
        return dfs(nums , 0);
    }

    public int dfs(int nums[] , int i){
        if(i >=nums.length){
            return 0;
        }

        if(dp[i]!=-1){
            return dp[i];
        }

        int steal = nums[i] + dfs(nums , i+2);
        int skip = dfs(nums , i+1);

        int res = Math.max(steal , skip);

        return dp[i] = res;

    }
}
