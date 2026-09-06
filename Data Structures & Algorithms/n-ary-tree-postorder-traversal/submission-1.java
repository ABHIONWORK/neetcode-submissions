/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        printPost(root , res);
        return res;
        
    }

    public static void printPost(Node root , List<Integer> res ){
        if(root == null){
            return;
        }

        for(Node child : root.children){
            printPost(child , res);
        }

        res.add(root.val);

    }
}