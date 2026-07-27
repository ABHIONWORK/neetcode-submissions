class Solution {

    public boolean isPossible(int nums[] , int mid , int k){
        int count = 1;
        int curr_sum = 0;
        for(int i = 0; i<nums.length; i++){
            if(curr_sum+nums[i]<=mid){
                curr_sum +=nums[i];

            }else{
                    curr_sum = nums[i];
                    count++;

            }
        }


        return count<=k;
    }
    public int splitArray(int[] nums, int k) {

        int sum = 0;
        int largest = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++){
            sum+=nums[i];
            largest = Math.max(nums[i] , largest);
        }
        int l = largest;
        int r = sum ;

        int res = 0;

        while(l<=r){
            int mid = l + (r-l)/2;

            if(isPossible(nums,mid, k)){
                res = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return res;
    }
}