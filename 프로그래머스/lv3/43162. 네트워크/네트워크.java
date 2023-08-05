import java.util.*;

class Solution {
    
    static boolean[] visited;
    static int answer;
    static int n;
    
    public void dfs(int com, int[][] computers) {
        
        Stack<Integer> stack = new Stack<>();
        stack.push(com);
        
        while(!stack.isEmpty()) {
            int curr = stack.pop();
            for(int i = 0; i < n; i++) {
                if (visited[i] == false && computers[curr][i] == 1) {
                    visited[i] = true;
                    stack.push(i);
                }
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        answer = 0;
        this.n = n;
        visited = new boolean[n];
        
        for(int c = 0; c < n; c++) {
            if (visited[c] == false) {
                dfs(c, computers);
                visited[c] = true;
                answer++;
            }
        }
        
        return answer;
    }
}