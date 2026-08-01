class Solution {
    public int totalFruit(int[] fruits) {
        HashMap <Integer , Integer > hm = new HashMap<>();


        int maxpic = 0;
        int currpic = 0;
        int l = 0;
        int idx = -1;

        for(int i : fruits){
            idx++;
            hm.put(i , hm.getOrDefault(i , 0) + 1);

            if(hm.size() > 2){
                if(hm.get(fruits[l]) == 1){
                    hm.remove(fruits[l]);
                }else{
                    hm.put(fruits[l] , hm.get(fruits[l]) - 1);
                }

                l++;
            }


            currpic =  idx - l + 1;

            if( currpic > maxpic){
                maxpic = currpic;
            }


        }

        return maxpic;
    }
}