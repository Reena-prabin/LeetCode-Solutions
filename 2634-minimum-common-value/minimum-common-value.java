class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                return nums1[i]; // Found the minimum common value
            } else if (nums1[i] < nums2[j]) {
                i++; // Increment pointer for nums1
            } else {
                j++; // Increment pointer for nums2
            }
        }
        
        return -1; // No common value found
    }
}