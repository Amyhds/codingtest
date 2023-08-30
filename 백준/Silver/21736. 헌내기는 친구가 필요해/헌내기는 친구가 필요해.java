import java.util.*;
import java.io.*;

public class Main {

    static int N, M, answer;
    static char[][] map;
    static boolean[][] visited;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void bfs(int sx, int sy) {
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{sx, sy});
        visited[sx][sy] = true;
        while(!que.isEmpty()) {
            int[] curr = que.poll();
            int x = curr[0];
            int y = curr[1];
            for(int d = 0; d < 4; d++) {
                int nx = x + dir[d][0];
                int ny = y + dir[d][1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 'X' || visited[nx][ny]) {
                    continue;
                }
                if (map[nx][ny] == 'P') {
                    answer++;
                }
                que.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = 0;
        map = new char[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            String temp = bf.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j);
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if (map[i][j] == 'I') {
                    bfs(i, j);
                    break;
                }
            }
        }

        System.out.println(answer > 0 ? answer : "TT");
    }
}