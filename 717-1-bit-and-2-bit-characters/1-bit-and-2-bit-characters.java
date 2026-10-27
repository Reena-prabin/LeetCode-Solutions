class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        int n = bits.length;
        
        while (i < n - 1) {
            if (bits[i] == 1) {
                // If it's a 2-bit character, skip the next bit as well
                i += 2;
            } else {
                // If it's a 1-bit character, move forward by 1
                i += 1;
            }
        }
        
        // If our pointer lands exactly on the last index, 
        // it means the last character must be a 1-bit character.
        return i == n - 1;
    }
}