class Solution {

    public static  class RealDiam{
        int height;
        int diameter;

        public RealDiam(int diameter , int height){
            this.diameter = diameter;
            this.height =height;


        }

    }


    public int diameterOfBinaryTree(TreeNode root) {
        return maxdiam(root).diameter;
    }



    public static RealDiam maxdiam (TreeNode root){

        if(root == null){
            return new RealDiam(0 , 0);
        }

        RealDiam l = maxdiam(root.left);
        RealDiam r = maxdiam(root.right);

        int maxdaim =Math.max(Math.max(l.diameter , r.diameter) , (l.height + r.height));
        int mxheight = Math.max(l.height , r.height) + 1;

        return new RealDiam(maxdaim , mxheight); 
    }
}
