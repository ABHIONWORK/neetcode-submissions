class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null){
            return true;
        }

        if(root == null){
            return false;
        }

        if(isSame(root , subRoot)){
            return true;
        }
        return isSubtree(root.left , subRoot) || isSubtree(root.right , subRoot);
    }


    public boolean isSame(TreeNode root , TreeNode subroot){
        if(root == null && subroot == null){
            return true;
        }

        if(root != null && subroot!= null && root.val == subroot.val){
            return isSame(root.left , subroot.left ) && isSame(root.right , subroot.right);
        }else{
            return false;
        }
    }
}
