class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        class PairComp implements Comparator<int[]>{
            @Override
            public int compare(int []a , int[]b){
                if(a[0] == b[0]){
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<> 
                             (new PairComp());

        ArrayList<Integer> al = new ArrayList<>();
        
        for(int num : arr){    
                int diff = Math.abs(num - x);
                pq.offer(new int[]{diff ,num});
        }   


        
        while(k-- > 0){
            int smalldiffarr[] = pq.poll();
            int valThatIsClose = smalldiffarr[1];
            al.add(valThatIsClose);
        }

        Collections.sort(al);
        return al;

    }
}
