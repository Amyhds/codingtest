import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4012_요리사_한다솜 {

	static int N;
	static int[][] synergy;
	static boolean[] isSelected;
	static int min;

	// 두 음식의 맛 차이 계산
	private static int calDiff() {

		int totalA = 0;
		int totalB = 0;

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (isSelected[i] && isSelected[j]) { // 선택된 N/2개는 A의 재료
					totalA += synergy[i][j] + synergy[j][i];
				}
				if (!isSelected[i] && !isSelected[j]) { // 선택되지 않은 N/2개는 B의 재료
					totalB += synergy[i][j] + synergy[j][i];
				}
			}
		}

		return Math.abs(totalA - totalB); // 차이 리턴

	}

	private static void comb(int cnt, int start) {
		if (cnt == N / 2) {
			min = Math.min(min, calDiff()); // 최소 차이로 업데이트
			return;
		}
		for (int i = start; i < N; i++) {
			isSelected[i] = true; // N/2개를 선택하고 그것을 기록해야 함
			comb(cnt + 1, i + 1);
			isSelected[i] = false;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			N = Integer.parseInt(bf.readLine());
			synergy = new int[N][N];
			isSelected = new boolean[N]; // 한 음식에 들어가는 재료 N/2개의 선택 여부를 저장할 배열

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < N; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			min = Integer.MAX_VALUE;
			comb(0, 0);
			System.out.println("#" + test_case + " " + min);
		}

	}

}
