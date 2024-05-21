import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, result;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N + 1];
        dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        // 마지막 계단은 무조건 밟아야하니까 거꾸로 생각!
        System.out.println(recur(N));
    }

    public static int recur(int cnt) {
        if (cnt <= 0) {
            return 0;
        }
        if (dp[cnt] > 0) {
            return dp[cnt];
        }
        // oox
        // oxo
        dp[cnt] = Math.max(recur(cnt - 2), recur(cnt - 3) + arr[cnt - 1]) + arr[cnt];
        return dp[cnt];
    }


}