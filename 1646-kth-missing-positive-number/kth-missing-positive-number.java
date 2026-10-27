class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // The number of missing positive integers before arr[mid] 
            // is given by: arr[mid] - (mid + 1)
            int missingCount = arr[mid] - (mid + 1);
            
            if (missingCount < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        // After the binary search loop finishes, 'left' points to the first index 
        // where missingCount >= k. 
        // The Kth missing number can be computed using: left + k
        return left + k;
    }
}