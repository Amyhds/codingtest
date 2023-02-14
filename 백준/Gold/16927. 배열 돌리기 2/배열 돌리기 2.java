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

	private static void spin(int currDepth, int cnt) {

		for (int i = 0; i < cnt; i++) {
			int temp = arr[currDepth][currDepth];
			
			for (int col = currDepth + 1; col < M - currDepth; col++) {
				arr[currDepth][col - 1] = arr[currDepth][col];
			}
			for (int row = currDepth + 1; row < N - currDepth; row++) {
				arr[row - 1][M - currDepth - 1] = arr[row][M - currDepth - 1];
			}
			for (int col = M - currDepth - 2; col >= currDepth; col--) {
				arr[N - currDepth - 1][col + 1] = arr[N - currDepth - 1][col];
			}
			for (int row = N - currDepth - 2; row >= currDepth; row--) {
				arr[row + 1][currDepth] = arr[row][currDepth];
			}
			
			arr[currDepth + 1][currDepth] = temp;
		}
		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		depth = Math.min(N, M) / 2; // 깊이, 배열의 겉부터 안으로 들어가야 하므로
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int changeCycle = 2 * (N + M - 2);
		// depth가 1 늘어날 때마다 회전 사이클은 -8 * depth가 됨
		// 2 * (N - 2*depth + M - 2*depth - 2)
		for (int i = 0; i < depth; i++) {
			if ((changeCycle - 8 * i) < 0) break;
			spin(i, R % (changeCycle - 8 * i));
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