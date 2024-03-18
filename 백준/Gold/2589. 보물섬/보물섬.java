import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int L, W;
    static boolean[][] map;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        L = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new boolean[L][W];
        for (int i = 0; i < L; i++) {
            String temp = bf.readLine();
            for (int j = 0; j < W; j++) {
                char cell = temp.charAt(j);
                if (cell == 'L') {
                    map[i][j] = true;
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j]) {
                    answer = Math.max(answer, bfs(i, j));
                }
            }
        }
        System.out.println(answer);
    }

    public static int bfs(int startX, int startY) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startX, startY});
        int[][] visited = new int[L][W];
        visited[startX][startY] = 1;
        int max = 0;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];
            for (int d = 0; d < 4; d++) {
                int nx = x + dir[d][0];
                int ny = y + dir[d][1];
                if (nx < 0 || nx >= L || ny < 0 || ny >= W) {
                    continue;
                }
                if (!map[nx][ny] || visited[nx][ny] > 0) {
                    continue;
                }
                visited[nx][ny] = visited[x][y] + 1;
                max = Math.max(max, visited[nx][ny]);
                queue.offer(new int[]{nx, ny});
            }
        }
        return max - 1;
    }

}