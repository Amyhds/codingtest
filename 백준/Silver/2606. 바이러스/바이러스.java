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
        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());
        arr = new boolean[N + 1][N + 1];
        StringTokenizer st = null;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = true;
            arr[b][a] = true;
        }
        visited = new boolean[N + 1];
        dfs(1);
        System.out.println(cnt - 1);
    }

    public static void dfs(int computer) {
        visited[computer] = true;
        cnt++;
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && arr[computer][i]) {
                dfs(i);
            }
        }
    }
}