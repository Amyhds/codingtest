import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R, C, max;
    static int[][] board;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new int[R][C];
        for (int r = 0; r < R; r++) {
            String temp = bf.readLine();
            for (int c = 0; c < C; c++) {
                board[r][c] = (int) temp.charAt(c) - 'A';
            }
        }
        visited = new boolean[26];
        dfs(0, 0, 1);
        System.out.println(max);
    }

    public static void dfs(int r, int c, int length) {
        max = Math.max(max, length);
        visited[board[r][c]] = true;
        for (int d = 0; d < 4; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                continue;
            }
            if (!visited[board[nr][nc]]) {
                dfs(nr, nc, length + 1);
                visited[board[nr][nc]] = false;
            }
        }
    }
}