class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        if (n == 1) return true;

        // Case 1 & 3: If the first letter is uppercase
        if (Character.isUpperCase(word.charAt(0))) {
            boolean allUpper = true;
            boolean allLower = true;

            for (int i = 1; i < n; i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    allLower = false;
                } else {
                    allUpper = false;
                }
            }
            return allUpper || allLower;
        } 
        
        // Case 2: If the first letter is lowercase, all subsequent letters must be lowercase
        for (int i = 1; i < n; i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                return false;
            }
        }
        
        return true;
    }
}