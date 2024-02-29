import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static Queue<int[]> cloudPos;
    static int[][] dir = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cloudPos = new ArrayDeque<>();
        cloudPos.add(new int[]{N - 1, 0});
        cloudPos.add(new int[]{N - 1, 1});
        cloudPos.add(new int[]{N - 2, 0});
        cloudPos.add(new int[]{N - 2, 1});
        int d, s;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            d = Integer.parseInt(st.nextToken()) - 1;
            s = Integer.parseInt(st.nextToken());
            moveAndRain(d, s);
            disappearAndBug();
            makeCloud();
            reset();
        }
        System.out.println(getWater());
    }

    public static void moveAndRain(int d, int s) {
        for (int[] cloud : cloudPos) {
            cloud[0] = (N + cloud[0] + dir[d][0] * (s % N)) % N;
            cloud[1] = (N + cloud[1] + dir[d][1] * (s % N)) % N;
            arr[cloud[0]][cloud[1]]++;
        }
    }

    public static void disappearAndBug() {
        while (!cloudPos.isEmpty()) {
            int[] cloud = cloudPos.poll();
            int x = cloud[0];
            int y = cloud[1];
            visited[x][y] = true;
            int basket = 0;
            for (int d = 1; d <= 7; d += 2) {
                int nx = x + dir[d][0];
                int ny = y + dir[d][1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                if (arr[nx][ny] > 0) {
                    basket++;
                }
            }
            arr[x][y] += basket;
        }
    }

    public static void makeCloud() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && arr[i][j] >= 2) {
                    cloudPos.add(new int[]{i, j});
                    arr[i][j] -= 2;
                }
            }
        }
    }

    public static void reset() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) {
                    visited[i][j] = false;
                }
            }
        }
    }

    public static int getWater() {
        int water = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                water += arr[i][j];
            }
        }
        return water;
    }
}