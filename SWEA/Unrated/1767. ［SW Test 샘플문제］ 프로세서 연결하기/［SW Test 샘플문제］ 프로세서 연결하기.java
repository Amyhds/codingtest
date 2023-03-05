import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	static class Core { // 코어 클래스
		int x, y;

		public Core(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static int N, exclude, include, min;
	static int[][] processor;
	static int[][] copy;
	static List<Core> cores;
	static List<Core> selectedCores;
	static boolean[] isSelected;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	private static void init() { // 초기화
		copy = new int[N][N]; // 카피 프로세서(전선 표시하기 위해)
		for (int row = 0; row < N; row++) {
			copy[row] = processor[row].clone();
		}
	}
	
	private static void reset(int curr, int len, int d) {    // 갔던 길 리셋
		int cX = selectedCores.get(curr).x;
		int cY = selectedCores.get(curr).y;
		for (int i = 0; i < len; i++) {
			cX += dir[d][0];
			cY += dir[d][1];
			copy[cX][cY] = 0;
		}
	}

	private static void connect(int curr, int total) { // 전원 연결

		if (curr == selectedCores.size()) { // 다 연결됐다면 끝! true 리턴
			min = Math.min(min, total); // 전선 길이 최소값 업데이트
			return; // 다음 방향으로
		}

		for (int d = 0; d < 4; d++) {
			boolean flag = false;  // 방향 바꿀때마다 이전 방향의 기록은 리셋해야 함
			int len = 0;
			int x = selectedCores.get(curr).x;
			int y = selectedCores.get(curr).y;
			while (true) {
				x += dir[d][0];
				y += dir[d][1];
				if (x < 0 || x >= N || y < 0 || y >= N) { // 전원에 연결되었다면 true
					flag = true;
					break;
				}
				if (copy[x][y] == 0) { // 더 나아갈 수 있다면 len + 1
					copy[x][y] = 2;  // 2로 표시
					len++;
				} else { // 전선이나 다른 코어 만나면 끝
					reset(curr, len, d);   // 리셋하고
					len = 0;   // 길이 0으로
					break;
				}
			}
			if (flag) { // 이번 코어에서 연결되었다면 다음 코어로 넘어가기
				connect(curr + 1, total + len);
				// 연결되지 않았거나 이후 코어에서 돌아왔다면 2로 표시한 것 원래대로 돌려두고 다음 방향으로
				reset(curr, len, d);
			}
		}
	}

	// n개 중 target개 선택 후 연결하고 길이 재기
	private static void chooseCore(int start, int cnt, int target) {
		if (cnt == target) {
			init(); // copy 배열 초기화

			selectedCores = new ArrayList<>(); // target개 선택된 코어 넣는 리스트
			for (int i = 0; i < include; i++) {
				if (isSelected[i])
					selectedCores.add(cores.get(i));
			}

			connect(0, 0); // target개 모두 전원 연결
			return;
		}

		for (int i = start; i < include; i++) {
			isSelected[i] = true;
			chooseCore(i + 1, cnt + 1, target);
			isSelected[i] = false;
		}

	}

	private static void findCore() { // 코어 찾고 표시, 리스트에 넣기
		include = 0;
		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < N - 1; j++) {
				if (processor[i][j] == 1) {
					include++;
					cores.add(new Core(i, j));
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력 및 할당
			N = Integer.parseInt(bf.readLine());
			processor = new int[N][N];
			isSelected = new boolean[N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < N; j++) {
					processor[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 이미 전원 연결된 core 제외하고 리스트에 넣기
			cores = new ArrayList<>();
			findCore();
			// 가장 많이 뽑을 때부터 가장 적게 뽑을 때까지
			// nCn, nCn-1, ... , nC1
			for (int r = include; r >= 1; r--) {
				min = Integer.MAX_VALUE; // 조합마다 min값 초기화
				chooseCore(0, 0, r);
				// i개 뽑을 때 다 연결 가능하다면 끝내기
				// 왜냐면 최대한 많은 코어에 전원을 연결한 것이므로
				if (min != Integer.MAX_VALUE)
					break;
			}

			System.out.println("#" + test_case + " " + min);
		}
	}
}