class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] answer = new int[n];
        
        // --- Pass 1: Left to Right ---
        // Track the position of the last seen character 'c'. 
        // Initialize with a large negative number so early indices before 
        // the first occurrence of 'c' get a large distance temporarily.
        int prev = -n;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            answer[i] = i - prev;
        }
        
        // --- Pass 2: Right to Left ---
        // Track the position of the last seen character 'c' from the right.
        prev = 2 * n;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            answer[i] = Math.min(answer[i], prev - i);
        }
        
        return answer;
    }
}