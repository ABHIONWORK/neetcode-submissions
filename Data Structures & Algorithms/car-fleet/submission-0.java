class Solution {

    public class PairComp implements Comparator<int[]>{
        public int compare(int a[] , int b[]){
            return Integer.compare(b[0] , a[0]);
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        
        int arr[][] = new int[position.length][2];
        for(int i = 0; i<position.length; i++){
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }

        Arrays.sort(arr , new PairComp());

        int fleet = 0;
        double mtime = 0.0;


        for(int i = 0; i<position.length; i++){

            double time = (double)(target - arr[i][0]) / arr[i][1];
            if(time > mtime){
                fleet++;
                mtime = time;
            }

        }

        return fleet;
    }
}
