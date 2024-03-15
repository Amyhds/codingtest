import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] box;
    static boolean[][] visited;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if (isRiped()) { // 처음부터 익어있음
            System.out.println(0);
        } else {
            boolean flag = false;
            List<int[]> startList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && box[i][j] > 0) {
                        visited[i][j] = true;
                        startList.add(new int[]{i, j});
                    }
                }
            }
            bfs(startList);
            System.out.println(isRiped() ? getDay() - 1 : -1);
        }
    }

    public static void bfs(List<int[]> startList) {
        Queue<int[]> queue = new ArrayDeque<>();
        for (int[] start : startList) {
            queue.offer(start);
        }
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int r = pos[0];
            int c = pos[1];
            for (int d = 0; d < 4; d++) {
                int nr = r + dir[d][0];
                int nc = c + dir[d][1];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                    continue;
                }
                if (box[nr][nc] != 0) { // 토마토가 없거나 이미 지나간 칸
                    continue;
                }
                queue.offer(new int[]{nr, nc});
                box[nr][nc] = box[r][c] + 1;
            }
        }
    }

    public static boolean isRiped() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int getDay() {
        int day = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                day = Math.max(day, box[i][j]);
            }
        }
        return day;
    }
}