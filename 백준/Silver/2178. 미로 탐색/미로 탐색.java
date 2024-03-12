import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static boolean[][] map;
    static int[][] visited;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            String temp = bf.readLine();
            for (int j = 0; j < M; j++) {
                int curr = temp.charAt(j) - '0';
                if (curr == 0) {
                    map[i][j] = false;
                } else {
                    map[i][j] = true;
                }
            }
        }
        bfs();
        System.out.println(visited[N - 1][M - 1]);
    }

    public static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = 1;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];
            for (int d = 0; d < 4; d++) {
                int nx = x + dir[d][0];
                int ny = y + dir[d][1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (visited[nx][ny] > 0 || !map[nx][ny]) {
                    continue;
                }
                queue.offer(new int[]{nx, ny});
                visited[nx][ny] = visited[x][y] + 1;
            }
        }
    }

}