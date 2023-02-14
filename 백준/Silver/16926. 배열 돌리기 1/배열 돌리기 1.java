import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, R;
	static int[][] arr;
	static int depth;
	static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static StringBuilder sb;

	private static int[][] spin() {
		
		int[][] arr2 = new int[N][M];

		for (int i = 0; i < depth; i++) {
			int x = i;
			int y = i;
			for (int d = 0; d < 4; d++) {
				while (true) {
					int nx = x + dir[d][0];
					int ny = y + dir[d][1];
					if (nx < i || nx >= N - i || ny < i || ny >= M - i) {
						break;
					}
					arr2[nx][ny] = arr[x][y];
					x = nx;
					y = ny;
				}
			}
		}
		return arr2;
	}


	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		depth = Math.min(N, M) / 2;
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < R; i++) {  // 회전 횟수
			arr = spin();
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
