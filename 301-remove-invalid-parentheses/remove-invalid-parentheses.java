import java.util.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) return result;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(s);
        visited.add(s);

        boolean foundValidAtThisLevel = false;

        while (!queue.isEmpty()) {
            String current = queue.poll();

            // If the current string is valid, add it to results
            if (isValid(current)) {
                result.add(current);
                foundValidAtThisLevel = true;
            }

            // If we found valid strings at the current level (minimum removals),
            // we stop generating next levels.
            if (foundValidAtThisLevel) continue;

            // Generate next state by removing one parenthesis at a time
            for (int i = 0; i < current.length(); i++) {
                char c = current.charAt(i);
                if (c != '(' && c != ')') continue;

                String next = current.substring(0, i) + current.substring(i + 1);

                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.add(next);
                }
            }
        }

        return result;
    }

    // Helper function to check if a string of parentheses is valid
    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) return false; // More closing brackets than opening ones
            }
        }
        return count == 0;
    }
}