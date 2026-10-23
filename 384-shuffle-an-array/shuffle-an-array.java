
import java.util.*;

class Solution {
    int[] a;
    Random r = new Random();

    public Solution(int[] nums) {
        a = nums.clone();
    }

    public int[] reset() {
        return a.clone();
    }

    public int[] shuffle() {
        int[] b = a.clone();

        for (int i = b.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            int t = b[i];
            b[i] = b[j];
            b[j] = t;
        }

        return b;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */