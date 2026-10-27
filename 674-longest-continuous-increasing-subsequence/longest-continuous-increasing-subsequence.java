class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int maxLength = 1;
        int currentLength = 1;
        
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                currentLength++;
            } else {
                currentLength = 1; // Reset streak if not strictly increasing
            }
            maxLength = Math.max(maxLength, currentLength);
        }
        
        return maxLength;
    }
}