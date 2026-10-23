class Solution {
    int[] a;
    Random r = new Random();

    public Solution(int[] nums) {
        a = nums;
    }

    public int pick(int target) {
        int count = 0, ans = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == target) {
                count++;
                if (r.nextInt(count) == 0)
                    ans = i;
            }
        }

        return ans;
    }
}


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */