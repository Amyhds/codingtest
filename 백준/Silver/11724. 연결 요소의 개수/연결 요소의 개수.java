import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N, M, cnt;
    static boolean[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = true;
            arr[b][a] = true;
        }
        visited = new boolean[N + 1];
        for (int node = 1; node <= N; node++) {
            if (!visited[node]) {
                dfs(node);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void dfs(int node) {
        visited[node] = true;
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && arr[node][i]) {
                dfs(i);
            }
        }
    }
}