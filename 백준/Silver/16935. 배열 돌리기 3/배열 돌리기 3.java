import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, R;
	static int[][] arr;
	static StringBuilder sb;

	// 1: 상하반전
	private static void upDown() {

		int[][] arr2 = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr2[i][j] = arr[N - i - 1][j];
			}
		}

		arr =  arr2;
	}
	// 2: 좌우반전
	private static void leftRight() {

		int[][] arr2 = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr2[i][j] = arr[i][M - j - 1];
			}
		}

		arr =  arr2;
	}
	// 3: 오른쪽 90도
	private static void right90() {

		int[][] arr2 = new int[M][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr2[j][N - 1 - i] = arr[i][j];
			}
		}
		int temp = N;
		N = M;
		M = temp;
		arr =  arr2;
	}
	// 4: 왼쪽 90도
	private static void left90() {
		
		int[][] arr2 = new int[M][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr2[M - 1 - j][i] = arr[i][j];
			}
		}
		int temp = N;
		N = M;
		M = temp;
		arr =  arr2;
	}
	// 5: 구역 나누고 시계 방향 이동
	private static void subArr1() {

		int[][] arr2 = new int[N][M];
		int n = N / 2;
		int m = M / 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i < n && j >= m) {
					arr2[i][j] = arr[i][j - m];
				} else if (i >= n && j >= m) {
					arr2[i][j] = arr[i - n][j];
				} else if (i >= n && j < m) {
					arr2[i][j] = arr[i][j + m];
				} else if (i < n && j < m) {
					arr2[i][j] = arr[i + n][j];
				}
			}
		}
		arr =  arr2;
	}
	// 6: 구역 나누고 반시계 방향 이동
	private static void subArr2() {

		int[][] arr2 = new int[N][M];
		int n = N / 2;
		int m = M / 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i < n && j >= m) {
					arr2[i][j] = arr[i + n][j];
				} else if (i >= n && j >= m) {
					arr2[i][j] = arr[i][j - m];
				} else if (i >= n && j < m) {
					arr2[i][j] = arr[i - n][j];
				} else if (i < n && j < m){
					arr2[i][j] = arr[i][j + m];
				}
			}
		}
		arr =  arr2;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(bf.readLine());
		for (int r = 0; r < R; r++) {
			switch (st.nextToken()) {
				case "1": {
					upDown();
					break;
				}
				case "2": {
					leftRight();
					break;
				}
				case "3": {
					right90();
					break;
				}
				case "4": {
					left90();
					break;
				}
				case "5": {
					subArr1();
					break;
				}
				case "6": {
					subArr2();
					break;
				}
			}
		}

		for (int[] row : arr) {
			for (int col : row) {
				sb.append(col + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}