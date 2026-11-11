class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = findBound(nums, target, true);
        int right = findBound(nums, target, false);
        return new int[]{left, right};
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int l = 0;
        int r = nums.length - 1;
        int bound = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                bound = mid; 
                if (isFirst) {
                    r = mid - 1; 
                } else {
                    l = mid + 1; 
                }
            }
        }
        return bound;
    }
}