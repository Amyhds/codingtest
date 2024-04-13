class Solution {
    static boolean[] visited;
    static int n;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        this.n = n;
        visited = new boolean[n];
        for(int comp = 0; comp < n; comp++) {
            if (!visited[comp]) {
                visited[comp] = true;
                dfs(comp, computers);
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs(int start, int[][] computers) {
        for(int next = 0; next < n; next++) {
            if (!visited[next] && computers[start][next] == 1) {
                visited[next] = true;
                dfs(next, computers);
            }
        }
    }
}