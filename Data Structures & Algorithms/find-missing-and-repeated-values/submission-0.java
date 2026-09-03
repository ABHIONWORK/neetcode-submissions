class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashMap<Integer , Integer > hm = new HashMap<>();
        int n = grid.length;
        int m = grid[0].length;
        int [] res = new int[2];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(!hm.containsKey(grid[i][j])){
                    hm.put(grid[i][j] , 1);
                }else{
                    hm.put(grid[i][j] , (hm.get(grid[i][j]) + 1 ));
                }
            }
        }
        
        for(int i = 1; i<=n*n; i++){
            if(hm.containsKey(i) && hm.get(i)==2){
                res[0] = i;
            }else if(!hm.containsKey(i)){
                res[1] = i;
            }
        }
    return res;

    }
}