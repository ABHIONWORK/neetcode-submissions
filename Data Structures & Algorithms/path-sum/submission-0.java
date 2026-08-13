class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }

        targetSum-=root.val;

        return hasPathSum(root.left , targetSum) || hasPathSum(root.right  , targetSum) || (targetSum == 0 && root.left == null && root.right == null);
    }
}