import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N, B, res;
	static int[] heights;

	private static void makeTower(int tower, int cnt) {
		if (cnt == N) {
			if (tower >= B) {
				res = Math.min(res, tower - B);
				return;
			} else {
				return;
			}
		} 

		makeTower(tower + heights[cnt], cnt + 1);
		makeTower(tower, cnt + 1);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken()); // 점원 수
			B = Integer.parseInt(st.nextToken()); // 탑의 높이
			heights = new int[N]; // 키 저장 배열
			res = Integer.MAX_VALUE; // 탑의 크기 최소값
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < N; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
			}

			makeTower(0, 0);
			System.out.println("#" + test_case + " " + res);
		}
	}

}