import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

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
				if (isSelected[i] && isSelected[j]) {
					totalA += synergy[i][j] + synergy[j][i];
				}
				else if (!isSelected[i] && !isSelected[j]) {
					totalB += synergy[i][j] + synergy[j][i];
				}
			}
		}

		return Math.abs(totalA - totalB);

	}

	private static void comb(int cnt, int start) {
		if (cnt == N / 2) {
			min = Math.min(min, calDiff());
			return;
		}
		for (int i = start; i < N; i++) {
			isSelected[i] = true;
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
			isSelected = new boolean[N];

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
