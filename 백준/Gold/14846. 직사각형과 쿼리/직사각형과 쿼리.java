import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] arr = new int[N + 1][N + 1];
        int[][][] sum = new int[N + 1][N + 1][11];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= 10; k++) {
                    sum[i][j][k] = sum[i][j - 1][k] + sum[i - 1][j][k] - sum[i - 1][j - 1][k];
                }
                sum[i][j][arr[i][j]]++;
            }
        }
        int Q = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int answer = 0;
            for (int k = 1; k <= 10; k++) {
                int temp =
                    sum[x2][y2][k] - sum[x1 - 1][y2][k] - sum[x2][y1 - 1][k] + sum[x1 - 1][y1
                        - 1][k];
                if (temp > 0) {
                    answer++;
                }
            }
            sb.append(answer + "\n");
        }
        System.out.println(sb);

    }

}