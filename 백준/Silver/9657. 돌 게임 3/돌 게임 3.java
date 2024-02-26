import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] arr = {1, 3, 4};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        boolean result = bottomUp(N);
        if (result) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }

    public static boolean bottomUp(int n) {
        boolean[] dp = new boolean[1001];
        dp[1] = true;
        dp[2] = false;
        dp[3] = true;
        dp[4] = true;
        for (int i = 5; i <= n; i++) {
            dp[i] = !((dp[i - 1] && dp[i - 3]) && dp[i - 4]);
        }
        return dp[n];
    }

    public static boolean topDown(int n) {
        if (n < 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        int win = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!topDown(n - arr[i])) {
                win++;
            }
        }
        if (win > 0) {
            return true;
        } else {
            return false;
        }
    }

}