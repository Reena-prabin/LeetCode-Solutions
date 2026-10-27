class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        
        // Traverse the string from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            
            if (c == '-') {
                continue; // Skip existing dashes
            }
            
            // Add a dash after every k characters from the right
            if (count > 0 && count % k == 0) {
                sb.append('-');
            }
            
            // Append the uppercase character
            sb.append(Character.toUpperCase(c));
            count++;
        }
        
        // Since we built the string backwards, reverse it to get the final answer
        return sb.reverse().toString();
    }
}