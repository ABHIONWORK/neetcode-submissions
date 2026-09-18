class Solution {
    public int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n];

        Arrays.fill(dp , -1);
        
        int from0 = findcostfrom(cost , 0);
        int from1 = findcostfrom(cost , 1);

        return Math.min(from0 , from1);
    }

    public int findcostfrom(int cost[] , int currStep){
            if(currStep >= cost.length){
                return 0;
            }


            if(dp[currStep] != -1){
                return dp[currStep];
            }


        int costOfOneStep = findcostfrom(cost , currStep + 1);
        int costOfTwoStep = findcostfrom(cost , currStep + 2);
        int totalcost = cost[currStep] + Math.min(costOfOneStep ,costOfTwoStep);

        dp[currStep] = totalcost;

        return dp[currStep];
    }
}
