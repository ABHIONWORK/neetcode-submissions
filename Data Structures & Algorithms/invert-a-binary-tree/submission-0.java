class Solution {
    public TreeNode invertTree(TreeNode root) {
        return reverse(root);
    }

public TreeNode reverse(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode l = reverse(root.left);
        TreeNode r = reverse(root.right);

        root.left = r;
        root.right = l;

        return root;
    } 
}
