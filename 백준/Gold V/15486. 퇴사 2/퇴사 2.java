import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] day;
    static int[] pay;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        day = new int[N + 1];
        pay = new int[N + 1];
        dp = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            day[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }
        for (int curr = N; curr >= 1; curr--) {
            int next = curr + day[curr];
            if (next > N + 1) {
                dp[curr] = dp[curr + 1];
            } else {
                dp[curr] = Math.max(dp[curr + 1], dp[next] + pay[curr]);
            }
        }
        System.out.println(dp[1]);
    }

}