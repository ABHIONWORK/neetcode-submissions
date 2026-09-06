/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        
        return reverse(root);

    }

    public static TreeNode reverse(TreeNode root){

        if(root == null){
            return null;
        }

        TreeNode l = reverse(root.left);
        TreeNode r = reverse(root.right);

        root.left = r;
        root.right = l;


        return root;
    }
}
