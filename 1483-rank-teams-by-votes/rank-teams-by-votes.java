class Solution {
    public String rankTeams(String[] votes) {
        int numTeams = votes[0].length();
        int[][] count = new int[26][26];
        for (String vote : votes) {
            for (int i = 0; i < numTeams; i++) {
                count[vote.charAt(i) - 'A'][i]++;
            }
        }
        Character[] teams = new Character[numTeams];
        for (int i = 0; i < numTeams; i++) {
            teams[i] = votes[0].charAt(i);
        }
        Arrays.sort(teams, (a, b) -> {
            for (int i = 0; i < numTeams; i++) {
                if (count[a - 'A'][i] != count[b - 'A'][i]) {
                    return count[b - 'A'][i] - count[a - 'A'][i];
                }
            }
            return a - b;
        });
        StringBuilder sb = new StringBuilder();
        for (char team : teams) {
            sb.append(team);
        }

        return sb.toString();
    }
}