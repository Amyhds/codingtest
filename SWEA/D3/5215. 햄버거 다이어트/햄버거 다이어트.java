import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N, Limit;
	static int[] Score, Kal;
	static int[][] D;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken()); // 재료 개수
			Limit = Integer.parseInt(st.nextToken()); // 제한 칼로리
			Score = new int[N + 1]; // 점수 배열
			Kal = new int[N + 1]; // 칼로리 배열
			D = new int[N + 1][Limit + 1];
			for (int n = 1; n <= N; n++) {
				st = new StringTokenizer(bf.readLine());
				Score[n] = Integer.parseInt(st.nextToken());
				Kal[n] = Integer.parseInt(st.nextToken());
			}

			for (int n = 1; n <= N; n++) {
				for (int lc = 1; lc <= Limit; lc++) {
					if (Kal[n] > lc) {
						D[n][lc] = D[n - 1][lc];
					} else {
						D[n][lc] = Math.max(Score[n] + D[n - 1][lc - Kal[n]], D[n - 1][lc]);
					}
				}
			}

			int ans = 0;
			for (int i = 0; i <= N; i++) {
				for (int j = 0; j <= Limit; j++) {
					ans = Math.max(ans, D[i][j]);
				}
			}

			System.out.println("#" + test_case + " " + ans);
		}
	}

}