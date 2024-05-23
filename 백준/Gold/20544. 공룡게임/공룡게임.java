import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static long[][][][] dp;
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        dp = new long[N + 1][3][3][2];

        System.out.println(recur(1, 0, 0, 0) % MOD);
    }

    public static long recur(int cnt, int before, int now, int hasTwo) {
        if (cnt == N) {
            if (hasTwo == 1) {
                return dp[cnt][now][before][hasTwo] = 1;
            } else {
                return dp[cnt][now][before][hasTwo] = 0;
            }
        }
        if (dp[cnt][now][before][hasTwo] != 0) {
            return dp[cnt][now][before][hasTwo];
        }
        if (now == 0) { // 현재 바닥
            dp[cnt][now][before][hasTwo] += recur(cnt + 1, now, 0, hasTwo) % MOD;
            dp[cnt][now][before][hasTwo] += recur(cnt + 1, now, 1, hasTwo) % MOD;
            dp[cnt][now][before][hasTwo] += recur(cnt + 1, now, 2, 1) % MOD;
        } else if (now == 1) { // 현재 선인장1
            if (before == 0) {
                dp[cnt][now][before][hasTwo] += recur(cnt + 1, now, 0, hasTwo) % MOD;
                dp[cnt][now][before][hasTwo] += recur(cnt + 1, now, 1, hasTwo) % MOD;
                dp[cnt][now][before][hasTwo] += recur(cnt + 1, now, 2, 1) % MOD;
            } else {
                dp[cnt][now][before][hasTwo] += recur(cnt + 1, now, 0, hasTwo) % MOD;
            }
        } else if (now == 2) { // 현재 선인장2
            if (before == 0) {
                dp[cnt][now][before][hasTwo] += recur(cnt + 1, now, 0, hasTwo) % MOD;
                dp[cnt][now][before][hasTwo] += recur(cnt + 1, now, 1, hasTwo) % MOD;
            } else {
                dp[cnt][now][before][hasTwo] += recur(cnt + 1, now, 0, hasTwo) % MOD;
            }
        }
        return dp[cnt][now][before][hasTwo] % MOD;
    }
}