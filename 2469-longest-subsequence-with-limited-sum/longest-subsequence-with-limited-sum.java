import java.util.Arrays;

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        // Step 1: Sort the nums array to pick the smallest elements first
        Arrays.sort(nums);
        
        // Step 2: Convert nums into a prefix sum array
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        
        int m = queries.length;
        int[] answer = new int[m];
        
        // Step 3: For each query, find the maximum number of elements using binary search
        for (int i = 0; i < m; i++) {
            int query = queries[i];
            int index = Arrays.binarySearch(nums, query);
            
            if (index >= 0) {
                // Exact match found, index + 1 is the count of elements
                answer[i] = index + 1;
            } else {
                // If not found, binarySearch returns (-(insertion point) - 1)
                // The insertion point gives the number of elements whose sum is <= query
                int insertionPoint = -index - 1;
                answer[i] = insertionPoint;
            }
        }
        
        return answer;
    }
}