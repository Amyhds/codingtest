import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, max, maxIndex;
    static int[] arr, dp, prev, seq;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N + 1];
        prev = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i] = 1;
            prev[i] = i;
        }
        solution();
        System.out.println(max);
        getSequence();
        for (int s : seq
        ) {
            System.out.print(s + " ");
        }
    }

    public static void solution() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                if (arr[j] < arr[i]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if (max < dp[i]) {
                max = dp[i];
                maxIndex = i;
            }
        }
    }

    public static void getSequence() {
        seq = new int[max];
        int i = max - 1;
        int curr = maxIndex;
        while (i >= 0) {
            seq[i] = arr[curr];
            curr = prev[curr];
            i--;
        }
    }

}