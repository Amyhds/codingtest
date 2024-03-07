import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, A, B, M, answer;
    static int[][] arr;
    static boolean[] visited;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(bf.readLine());
        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        dfs(A, 0);
        System.out.println(answer);
    }

    public static void dfs(int person, int relative) {
        visited[person] = true;
        if (person == B) {
            flag = true;
            answer = relative;
            return;
        }
        for (int p = 1; p <= N; p++) {
            if (!visited[p] && arr[person][p] == 1) {
                dfs(p, relative + 1);
            }
        }
        if (!flag) {
            answer = -1;
        }
    }
}