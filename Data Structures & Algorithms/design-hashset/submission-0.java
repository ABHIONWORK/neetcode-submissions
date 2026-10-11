class MyHashSet {
    private ArrayList<Integer>[] buckets;

    // COLLOSION -- SEPRATE CHANINING // LF - DOUBLE HASHING


    //USED - use Separate Chaining with
    //holy grail 
    private static final int size = 10000;
    @SuppressWarnings("unchecked") // okay i knoow this might not look fimmilar but iska kaam hi yeah hai ki jo ham array create karnge usko shi nhi lagega 
    public MyHashSet() {
        buckets = new ArrayList[size]; // now u know why i used that SupressWarnigs("Unchecked") part 

    }


    public int hash(int key){
        return key % size;
    }

    
    public void add(int key) {
        int idx = hash(key);

        if(buckets[idx] == null){
            buckets[idx] = new ArrayList<>();
        }

        ArrayList<Integer> currBucket = buckets[idx];

        boolean found = false;
        for(int i = 0; i<currBucket.size(); i++){
            if(currBucket.get(i) == key){
                found  = true;
                break;
            }
        }

        if(!found){
            currBucket.add(key);
        }
        
    }
    
    public void remove(int key) {
        int idx = hash(key);
        ArrayList<Integer> bucket = buckets[idx];
        if (bucket == null) return;

        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i) == key) {
                bucket.remove(i);
                break;
            }
        }

        
    }
    
    public boolean contains(int key) {
        int idx = hash(key);
        ArrayList<Integer> bucket = buckets[idx];
        if (bucket == null) return false;
        
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i) == key) {
                return true;
            }
        }
        
        return false;
        
    }
}