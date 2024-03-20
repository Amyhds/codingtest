import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, people;
    static boolean[][] relation;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());
        relation = new boolean[N + 1][N + 1];
        depth = new int[N + 1];
        StringTokenizer st = null;
        int a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            relation[a][b] = true;
            relation[b][a] = true;
        }
        solution();
        System.out.println(people);
    }

    public static void solution() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        boolean[] visited = new boolean[N + 1];
        visited[1] = true;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && relation[curr][i]) {
                    queue.offer(i);
                    visited[i] = true;
                    depth[i] = depth[curr] + 1;
                    if (depth[i] == 3) {
                        return;
                    }
                    people++;
                }
            }
        }
    }
}