class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";
        
        // Construct the modified string: s + "#" + reverse(s)
        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev;
        
        // Compute the KMP LPS (Longest Prefix Suffix) table
        int[] lps = new int[combined.length()];
        for (int i = 1; i < combined.length(); i++) {
            int j = lps[i - 1];
            while (j > 0 && combined.charAt(i) != combined.charAt(j)) {
                j = lps[j - 1];
            }
            if (combined.charAt(i) == combined.charAt(j)) {
                j++;
            }
            lps[i] = j;
        }
        
        // The last value in the LPS array gives the length of the longest palindromic prefix of s
        int palindromicLen = lps[combined.length() - 1];
        
        // Take the remaining suffix that is not part of the palindrome, reverse it, and prepend it to s
        String suffixToAdd = rev.substring(0, n - palindromicLen);
        return suffixToAdd + s;
    }
}