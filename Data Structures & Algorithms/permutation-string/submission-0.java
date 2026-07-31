class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //Coded with priyanshu bhai 
        HashMap<Character , Integer > hm = new HashMap<>();
        for(char c : s1.toCharArray()){
            hm.put(c , hm.getOrDefault(c , 0) + 1);

        }

        int l = 0;
        int r = s1.length() - 1;


        boolean isTrue = false;
        while(r<s2.length()){
            HashMap<Character , Integer> hm2 = new HashMap<>();
            for(int i = l; i<=r; i++){
                hm2.put(s2.charAt(i) , hm2.getOrDefault(s2.charAt(i) , 0) + 1);
            }

             isTrue = hm2.equals(hm);

            if(isTrue) {
                isTrue = true;
                break;
            }
            l++;
            r++;
        }


        return isTrue;
    }
}