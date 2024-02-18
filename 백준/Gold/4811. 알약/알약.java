import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, answer;
    static long[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            N = Integer.parseInt(bf.readLine());
            if (N == 0) {
                break;
            }
            answer = 0;
            dp = new long[2 * N + 1][N + 1][N + 1];
            reset();
            System.out.println(solution(0, N, 0));
        }
    }

    public static long solution(int cnt, int whole, int half) {
        if (cnt == 2 * N) {
            return 1;
        }
        if (dp[cnt][whole][half] != -1) {
            return dp[cnt][whole][half];
        }
        if (whole == 0 && half > 0) {
            dp[cnt][whole][half] = solution(cnt + 1, whole, half - 1);
        } else if (half == 0 && whole > 0) {
            dp[cnt][whole][half] = solution(cnt + 1, whole - 1, half + 1);
        } else if (half > 0 && whole > 0) {
            dp[cnt][whole][half] =
                solution(cnt + 1, whole, half - 1) + solution(cnt + 1, whole - 1, half + 1);
        }
        return dp[cnt][whole][half];
    }

    public static void reset() {
        for (int i = 0; i <= 2 * N; i++) {
            for (int j = 0; j <= N; j++) {
                for (int k = 0; k <= N; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
    }
}