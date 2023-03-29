import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coin = new int[n];
		int[] dp = new int[k + 1];

		for (int c = 0; c < n; c++) {
			coin[c] = Integer.parseInt(bf.readLine());
		}

		Arrays.sort(coin); // 동전 가치 오름차순 정렬

		dp[0] = 0;

		for (int value = 1; value <= k; value++) { // 1~k원까지
			int min = Integer.MAX_VALUE; // value만큼 만들기 위해 가장 적게 쓰는 동전 개수
			for (int c = 0; c < n; c++) { // 모든 동전을 돌면서..
				int prev = value - coin[c];
				if (prev >= 0) { // value가 동전 가치보다 큰 경우
					// 차가 0보다 큰데 dp 테이블에 값이 없다면 동전들을 조합해서 만들 수 없는 금액
					if (prev != 0 && dp[prev] == 0)
						continue;
					min = Math.min(min, dp[prev] + 1);
				} else   // value가 동전 가치보다 작으면 볼 필요가 없다
					break;
			}
			// min이 초기값이면 value보다 작은 동전 가치가 없는 것이므로 0
			dp[value] = (min == Integer.MAX_VALUE ? 0 : min);
		}
		// k만큼 만들기 위해 가장 적게 쓴 동전의 개수
		System.out.println(dp[k] == 0 ? -1 : dp[k]);
	}
}