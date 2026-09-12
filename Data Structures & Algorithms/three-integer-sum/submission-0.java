class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> al = new ArrayList<>();


        //resolved this -- and i still fumbled with the duplicate ones .....


        
        Arrays.sort(nums);

        for(int i = 0; i<nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }


            int l = i + 1;
            int r = nums.length -1;
            int rem = -(nums[i]);



            while(l<r){
                int sum = nums[l] + nums[r];

                if(sum > rem){
                    r--;
                }
                else if (sum < rem){
                    l++;
                }

                else{
                    al.add(Arrays.asList(nums[i] , nums[l] , nums[r]));

                    l++;
                    r--;

                    while(l<r && nums[l] == nums[l-1]){
                        l++;
                    }


                    while(l<r && nums[r] == nums[r + 1]){
                        r--;
                    }
                }
                
            }
        }

        return al;
    }
}