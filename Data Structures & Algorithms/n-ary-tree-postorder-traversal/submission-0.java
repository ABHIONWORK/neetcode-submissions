
public class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();

        PrintPostOrder(root, res);
        return res;
    }

    private void PrintPostOrder(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }
        for (Node child : node.children) {
            PrintPostOrder(child, res);
        }
        res.add(node.val);
    }
}