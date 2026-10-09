class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int needed_rights = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                // If needed_rights is odd, we need 1 extra ')' to complete the previous pair
                if (needed_rights % 2 != 0) {
                    insertions++;
                    needed_rights--;
                }
                needed_rights += 2;
            } else { // c == ')'
                needed_rights--;

                // Encountered an unmatched ')' without an opening '('
                if (needed_rights < 0) {
                    insertions++; // Insert '('
                    needed_rights += 2; // '(' needs 2 ')'
                }
            }
        }

        return insertions + needed_rights;
    }
}