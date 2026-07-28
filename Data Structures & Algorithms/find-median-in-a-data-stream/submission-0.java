class MedianFinder {

    public PriorityQueue<Integer> minHeap ;
    public PriorityQueue<Integer> maxHeap ;


    // public ArrayList<Integer> al ;
    // public double avg;
    // public double mid;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        // al = new ArrayList<>();
        // // avg = 0;
        // // mid = 0;

    }


    
    public void addNum(int num) {

        if(maxHeap.isEmpty() || num <=maxHeap.peek()){
            maxHeap.offer(num);
        }else{
            minHeap.offer(num);
        }


        if(maxHeap.size() - minHeap.size()>1){
            minHeap.offer(maxHeap.poll());
        }

        if(minHeap.size() - maxHeap.size() >= 1){
            maxHeap.offer(minHeap.poll());
        }





        // al.add(num);
        // Collections.sort(al); //This one getting issue with as the sorting ebverytime will take o(n) operations ; so its reduandant 
    }
    
    public double findMedian() {

        if((minHeap.size() + maxHeap.size())%2 == 1){
            return (double)maxHeap.peek();
        }

        return (double) (minHeap.peek() + maxHeap.peek())/2;
        
    //     int sz = al.size();
    //     if(al.size() %2 == 1){
    //         int idx = sz/2;
    //         return (double)al.get(idx);
    //         // for(int i = 0; i<al.size()/2; i++){

    //         // }
    //     }else{
    //         int idx1 = sz/2;
    //         int idx2 = (sz/2) -1;
    //         return (double)(al.get(idx1) + al.get(idx2))/2;
    //     }
    }

}



/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */