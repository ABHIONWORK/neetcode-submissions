class Solution {

    static class PairComparator implements Comparator<int[]>{
        @Override 
        public int compare(int[] a, int[] b){
            return b[0] - a[0];
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new PairComparator());

        if(a != 0){
            pq.offer(new int[]{a , 'a'});
        }
        if(b != 0){
            pq.offer(new int[]{b , 'b'});
        }
        if(c != 0){
            pq.offer(new int[]{c , 'c'});
        }


        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {

            // Take the character with the highest remaining frequency
            int[] first = pq.poll();

            int freq1 = first[0];
            char ch1 = (char) first[1];

            // If using this character creates three consecutive same characters
            if (sb.length() >= 2 &&
                sb.charAt(sb.length() - 1) == ch1 &&
                sb.charAt(sb.length() - 2) == ch1) {

                // No other character is available
                if (pq.isEmpty()) {
                    break;
                }

                // Take the second most frequent character
                int[] second = pq.poll();

                int freq2 = second[0];
                char ch2 = (char) second[1];

                // Use it once
                sb.append(ch2);
                freq2--;

                // Put it back if it still has remaining frequency
                if (freq2 > 0) {
                    pq.offer(new int[]{freq2, ch2});
                }

                // Put the first character back because we didn't use it
                pq.offer(first);

            } else {

                // Safe to use the most frequent character
                sb.append(ch1);
                freq1--;

                // Put it back if it still has remaining frequency
                if (freq1 > 0) {
                    pq.offer(new int[]{freq1, ch1});
                }
            }
        }

        return sb.toString();
        

    }
}