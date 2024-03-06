import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N, apartment, household;
    static int[][] map;
    static boolean[][] visited;
    static List<Integer> households;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String temp = bf.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }
        visited = new boolean[N][N];
        households = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    household = 0;
                    dfs(i, j);
                    households.add(household);
                    apartment++;
                }
            }
        }
        Collections.sort(households);
        System.out.println(apartment);
        for (int h : households
        ) {
            System.out.println(h);
        }
    }

    public static void dfs(int r, int c) {
        household++;
        visited[r][c] = true;
        for (int d = 0; d < 4; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                continue;
            }
            if (!visited[nr][nc] && map[nr][nc] == 1) {
                dfs(nr, nc);
            }
        }
    }
}