class Solution {
    public int maxFrequency(int[] nums, int k) {

        Arrays.sort(nums);

        int l = 0;
        int mxfrq = 1;
        long wsum = 0;


        for(int r = 0; r<nums.length; r++){
            wsum+=nums[r];

            while((long)nums[r] * (r - l+ 1) - wsum >k){
                wsum-=nums[l];
                l++;
            }

            mxfrq = Math.max(mxfrq , r - l + 1);
        }

        return mxfrq;
    }
}