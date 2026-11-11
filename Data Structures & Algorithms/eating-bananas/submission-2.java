class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min_take = 1;
        int max_take = 0;
        for(int num : piles){
            if(num > max_take){
                max_take = num;
            }
        }
        int res = max_take;

        int l = min_take;
        int r = max_take;

        while(l<=r){
            int mid = l + (r-l)/2;

            if(check(piles , mid ,  h )){
                res = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }

        return res;
    }

    public boolean check(int []piles , int mid , int h){
        long hr = 0;

        for(int banana : piles){
            hr += (banana + mid - 1)/mid;
        }

        return hr<=h;
    }
}
