class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> outgoingCities = new HashSet<>();
        for (List<String> path : paths) {
            outgoingCities.add(path.get(0));
        }
        for (List<String> path : paths) {
            String destinationCandidate = path.get(1);
            if (!outgoingCities.contains(destinationCandidate)) {
                return destinationCandidate;
            }
        }

        return "";
    }
}