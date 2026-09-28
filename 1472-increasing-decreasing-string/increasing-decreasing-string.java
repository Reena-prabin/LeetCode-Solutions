class Solution {
    public String sortString(String s) {
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        int totalLength = s.length();
        while (sb.length() < totalLength) {
            for (int i = 0; i < 26; i++) {
                if (counts[i] > 0) {
                    sb.append((char) (i + 'a'));
                    counts[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (counts[i] > 0) {
                    sb.append((char) (i + 'a'));
                    counts[i]--;
                }
            }
        }

        return sb.toString();
    }
}