class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0;

        int zeros = 0;
        int ones = 0;

        int currmaxWindow = 0;
        int res =0;



        for(int r = 0; r<nums.length; r++){
           
            if(nums[r] == 0){
                zeros++;
            }


            while(zeros > k){
                if(nums[l] == 0){
                    zeros --;
                }
                l++;

            }   

        res = Math.max(res , r - l + 1);



            


        }

        return res;
    }
}