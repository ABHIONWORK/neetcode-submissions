class Solution {
    public int trap(int[] height) {
        if(height.length == 0){
            return 0;
        }

    int res = 0;

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i<height.length; i++){

            while(!st.isEmpty() && height[i] >= height[st.peek()]){
                int curr = height[st.pop()];

                if(!st.isEmpty()){
                    int left = height[st.peek()];
                    int right = height[i];

                    int width = i - st.peek() - 1;

                    int h = (Math.min(left , right) - curr);
                    res+= h *width;

                }
            }
            st.push(i);
        }

        return res;
    }
}
