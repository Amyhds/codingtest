import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int[] glasses;
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		glasses = new int[N];
		dp = new int[N];
		for (int i = 0; i < N; i++) {
			glasses[i] = Integer.parseInt(bf.readLine());
		}

		dp[0] = glasses[0];

		for (int i = 1; i < N; i++) {
			if (i == 1) {
				dp[i] = dp[i - 1] + glasses[i];
			} else if (i == 2) {
				dp[i] = Math.max(dp[i - 1], Math.max(glasses[i - 2] + glasses[i], glasses[i - 1] + glasses[i]));
			} else {
				dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + glasses[i], dp[i - 3] + glasses[i - 1] + glasses[i]));
			}
		}

		System.out.println(dp[N - 1]);
	}

}