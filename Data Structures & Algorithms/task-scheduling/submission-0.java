class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character , Integer> hm = new HashMap<>();

        for(char c : tasks){
            hm.put(c , hm.getOrDefault(c , 0) + 1);

        } 


        ArrayList<Integer> al = new ArrayList<>(hm.values());
        Collections.sort(al, Collections.reverseOrder());

        int maxfreq = al.get(0);

        int ghadee = maxfreq - 1;

        int idlespace = ((maxfreq - 1) * n);

         for(int i = 1; i<al.size(); i++){
            idlespace -= Math.min(ghadee , al.get(i));
            idlespace = Math.max(0 , idlespace);
        }

        if(idlespace > 0){
            return tasks.length + idlespace;
        }

        return tasks.length;
    }
}
