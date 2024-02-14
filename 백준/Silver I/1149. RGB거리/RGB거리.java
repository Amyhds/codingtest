import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] costArray, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        costArray = new int[N][3];
        dp = new int[N + 1][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 3; j++) {
                costArray[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = 10000000;
            }
        }
        System.out.println(solution(0, 0));
    }

    public static int solution(int curr, int type) {
        if (curr == N) {
            return 0;
        }
        if (dp[curr][type] != 10000000) {
            return dp[curr][type];
        }
        for (int color = 0; color < 3; color++) {
            if (curr > 0 && type == color) {
                continue;
            }
            dp[curr][type] = Math.min(solution(curr + 1, color) + costArray[curr][color],
                dp[curr][type]);
        }
        return dp[curr][type];
    }
}