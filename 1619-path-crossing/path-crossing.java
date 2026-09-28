class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> visited = new HashSet<>();
        int x = 0;
        int y = 0;
        visited.add(x + "," + y);
        for (char dir : path.toCharArray()) {
            if (dir == 'N') {
                y++;
            } else if (dir == 'S') {
                y--;
            } else if (dir == 'E') {
                x++;
            } else if (dir == 'W') {
                x--;
            }
            String currentPos = x + "," + y;
            if (visited.contains(currentPos)) {
                return true;
            }
            
            visited.add(currentPos);
        }

        return false;
    }
}