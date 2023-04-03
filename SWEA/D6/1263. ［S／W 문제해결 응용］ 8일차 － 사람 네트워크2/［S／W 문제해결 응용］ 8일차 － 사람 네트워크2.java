import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[][] floyd;
	static int N, min;
	static final int INF = 99999;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			floyd = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					floyd[i][j] = Integer.parseInt(st.nextToken());
					if (i != j && floyd[i][j] == 0) {
						floyd[i][j] = INF;
					}
				}
			}

			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					if (i == k)
						continue;
					for (int j = 0; j < N; j++) {
						floyd[i][j] = Math.min(floyd[i][j], floyd[i][k] + floyd[k][j]);
					}
				}
			}

			min = INF;
			for (int i = 0; i < N; i++) {
				int row = 0;
				for (int j = 0; j < N; j++) {
					row += floyd[i][j];
				}
				min = Math.min(min, row);
			}

			System.out.println("#" + test_case + " " + min);
		}
	}

}