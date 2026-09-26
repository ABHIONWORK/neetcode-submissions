class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return dfs(nums, 0, 0, target, memo);
    }

    public int dfs(int[] nums, int idx, int currSum, int target, Map<String, Integer> memo) {
        String key = idx + "," + currSum;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (idx == nums.length) {
            if (currSum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        int plus = dfs(nums, idx + 1, currSum + nums[idx], target, memo);
        int minus = dfs(nums, idx + 1, currSum - nums[idx], target, memo);

        memo.put(key, plus + minus);
        return memo.get(key);
    }
}