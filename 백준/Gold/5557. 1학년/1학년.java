import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] numbers;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        numbers = new int[N];
        dp = new long[N + 1][21];
        reset();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(1, numbers[0]));
    }

    public static long solution(int cnt, int sum) {
        if (sum < 0 || sum > 20) {
            return 0;
        }
        if (dp[cnt][sum] != -1) {
            return dp[cnt][sum];
        }
        if (cnt == N - 1) {
            if (sum == numbers[N - 1]) {
                dp[cnt][sum] = 1;
            } else {
                dp[cnt][sum] = 0;
            }
            return dp[cnt][sum];
        }
        dp[cnt][sum] =
            solution(cnt + 1, sum + numbers[cnt]) + solution(cnt + 1, sum - numbers[cnt]);
        return dp[cnt][sum];
    }

    public static void reset() {
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= 20; j++) {
                dp[i][j] = -1;
            }
        }
    }
}