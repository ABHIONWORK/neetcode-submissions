class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < asteroids.length; i++) {
            int val = asteroids[i];
            boolean destroyed = false; // Replaced 'fata' with a descriptive variable name
            
            while (!st.isEmpty() && val < 0 && st.peek() > 0) {
                int incomingSize = -val; // Compare sizes without modifying 'val'
                
                if (incomingSize > st.peek()) {
                    st.pop(); // Top asteroid explodes, continue checking the stack
                } else if (incomingSize < st.peek()) {
                    destroyed = true; // Incoming asteroid explodes
                    break;
                } else {
                    st.pop(); // Both explode
                    destroyed = true;
                    break;
                }
            }
            
            // Push the asteroid only if it survived all collisions
            if (!destroyed) {
                st.push(val);
            }
        }
        
        int[] res = new int[st.size()];
        int i = st.size() - 1;
        while (!st.isEmpty()) {
            res[i--] = st.pop(); // Decrement 'i' after assigning
        }
        
        return res;
    }
}
