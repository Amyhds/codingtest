import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        dp = new int[N + 1];
        System.out.println(solution(N));
    }

    public static int solution(int n) {
        if (dp[n] > 0) {
            return dp[n];
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        dp[n] = solution(n - 2) + solution(n - 1);
        dp[n] %= 10007;
        return dp[n];
    }

}