class Solution {
    public int maximumCount(int[] nums) {
        int negCount = findFirstGreaterOrEqual(nums, 0);
        int posCount = nums.length - findFirstGreaterThan(nums, 0);
        
        return Math.max(negCount, posCount);
    }
    
    // Finds the first index where nums[i] >= target (used for counting negatives < 0)
    private int findFirstGreaterOrEqual(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    // Finds the first index where nums[i] > target (used for counting positives > 0)
    private int findFirstGreaterThan(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}