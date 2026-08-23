class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();

        int leftpart [] = new int[heights.length];
        int rightpart[] = new int[heights.length];
        
        for(int i = 0; i<heights.length; i++){
            leftpart[i] = -1;

            int currheight = heights[i];

            while(!st.isEmpty() && heights[st.peek()] >= currheight){
                st.pop();
            }

            if(!st.isEmpty()){
                leftpart[i] = st.peek();
            }

            st.push(i);
        }

        st.clear();


        for(int i = heights.length - 1; i>=0; i--){
            int curr = heights[i];
            rightpart[i] = heights.length;
            while(!st.isEmpty() && heights[st.peek()] >= curr){
                st.pop();
                
            }

            if(!st.isEmpty()){
                rightpart[i] = st.peek();
            }

            st.push(i);
        }

        int area = 0;

        for(int i = 0; i<heights.length; i++){
            
            area = Math.max(area ,(heights[i]*(rightpart[i] - leftpart[i] - 1)));
        }
            return area;
    }

}