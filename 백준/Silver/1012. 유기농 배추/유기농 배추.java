import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int N, M, K, worm;
  static boolean[][] land;
  static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

  public static void bfs(int i, int j) {
    Queue<int[]> que = new ArrayDeque<>();
    que.offer(new int[]{i, j});
    land[i][j] = false;
    while (!que.isEmpty()) {
      int[] curr = que.poll();
      int x = curr[0];
      int y = curr[1];
      for (int d = 0; d < 4; d++) {
        int nx = x + dir[d][0];
        int ny = y + dir[d][1];
        if (nx < 0 || nx >= N || ny < 0 || ny >= M || !land[nx][ny]) {
          continue;
        }
        land[nx][ny] = false;
        que.offer(new int[]{nx, ny});
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(bf.readLine());
    for (int t = 1; t <= T; t++) {
      StringTokenizer st = new StringTokenizer(bf.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());
      land = new boolean[N][M];
      worm = 0;
      for (int k = 1; k <= K; k++) {
        st = new StringTokenizer(bf.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        land[x][y] = true;
      }

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if (land[i][j]) {
            bfs(i, j);
            worm++;
          }
        }
      }

      System.out.println(worm);
    }


  }
}