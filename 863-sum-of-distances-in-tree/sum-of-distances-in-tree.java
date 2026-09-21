class Solution {
    int[] count;
    int[] ans;
    List<List<Integer>> graph;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        count = new int[n];
        ans = new int[n];
        dfs1(0, -1);
        dfs2(0, -1, n);
        return ans;
    }
    public void dfs1(int node, int parent) {
        count[node] = 1;
        for (int child : graph.get(node)) {
            if (child == parent) {
                continue;
            }
            dfs1(child, node);
            count[node] += count[child];
            ans[node] += ans[child] + count[child];
        }
    }
    public void dfs2(int node, int parent, int n) {
        for (int child : graph.get(node)) {
            if (child == parent) {
                continue;
            }
            ans[child] = ans[node]
                       - count[child]
                       + (n - count[child]);
            dfs2(child, node, n);
        }
    }
}