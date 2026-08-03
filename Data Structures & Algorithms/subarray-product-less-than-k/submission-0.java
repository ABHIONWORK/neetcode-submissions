class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int product = 1;

        int l = 0;
        int res = 0;

        if(k<=1){
            return 0;
        }

        for(int r = 0; r<nums.length; r++){
            product = product * nums[r];


            while(product >=k){
                product = product/nums[l];
                l++;
            }


            res+=r-l+1;
        }

        return res;
    }
}