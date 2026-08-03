class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int l = 0;
        int pfsum = 0;
        int res = 0;
        

        HashMap<Integer , Integer> hm = new HashMap<>();
        hm.put(0 , 1);



        for(int num : nums){
            pfsum+=num;

            if(hm.containsKey(pfsum - goal)){
                res+=hm.get(pfsum - goal);
                
            }

            hm.put(pfsum , hm.getOrDefault(pfsum ,0) + 1);

        }


        return res;


        // // int currsum = 0;

        // int cntOfOne = 0;
        // int cntOfzero = 0;
        // int res = 0;

        // for(int r = 0; r<nums.length; r++){

        //     if(nums[r] == 1){
        //         cntOfOne++;
        //     }else{
        //         cntOfzero++;
        //     }

        //     while(cntOfOne == 2){
        //         res++;
        //     }


            


        

    }
}