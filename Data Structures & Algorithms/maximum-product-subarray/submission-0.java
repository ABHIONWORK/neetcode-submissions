class Solution {
    public int maxProduct(int[] nums) {
        int max_till = nums[0];
        int min_till = nums[0];

        int res = nums[0];

        for(int i = 1; i<nums.length; i++){
            int num = nums[i];
            int tmp = max_till;

            max_till = Math.max(Math.max(max_till * num , num * min_till ) , num);
            min_till = Math.min(Math.min(tmp * num , min_till * num) , num);

            res = Math.max(max_till , res);

        }

        return res;
    }
}
