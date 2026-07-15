class Solution {

    public static class PairComprator implements Comparator<int[]>{
        @Override
        public  int compare(int[] a , int[] b){
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        }
    }
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new PairComprator());

        int inidx = 0;
        for(int num : nums){
            pq.offer(new int[]{num , inidx});
            inidx++;
        }



        while(k-->0){
            int arr[] = pq.peek();
            int val = arr[0];
            int idx = arr[1];
            pq.poll();


            nums[idx] = val*multiplier;

            pq.offer(new int[]{nums[idx],idx});
        }

        return nums;


    }
}