class Solution {
    public Node connect(Node root) {
        
        Node curr = root;
        Node nxt = (root != null) ? root.left : null;


        while(curr!= null && nxt!= null){

            curr.left.next = curr.right;

            if(curr.next!= null){
                curr.right.next = curr.next.left;
            }

            curr = curr.next;
            if(curr == null){
                curr = nxt;
                nxt = curr.left;
            }
        }

        return root;
    }
}