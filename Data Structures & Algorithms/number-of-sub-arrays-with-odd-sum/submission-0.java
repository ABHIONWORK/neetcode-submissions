class Solution {
    public int numOfSubarrays(int[] arr) {
        int even = 1;
        int odd = 0;
        int res = 0;
        int mod = 1000000007;

        int pfsum = 0;

        for(int num : arr){
            pfsum+=num;

            if(pfsum % 2 != 0){
                res= (res + even) % mod;
                odd++;

            }else{
                res = (res + odd ) % mod;
                even ++; 
            }
        }

        return res;
    }
}